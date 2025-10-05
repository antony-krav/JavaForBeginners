package ru.JavaForBegginers.App;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class App {

    private static String loadSql(String filename) {
        try (InputStream input = App.class.getResourceAsStream("/sqlQueries/" + filename)) {
            assert input != null;
            return new String(input.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке SQL-скрипта: " + filename, e);
        }
    }

    private static final String CREATE_PRODUCT = loadSql("createProducts.sql");
    private static final String CREATE_CUSTOMER = loadSql("createCustomer.sql");
    private static final String LAST_5_ORDERS = loadSql("getLast5orders.sql");
    private static final String CREATE_ORDER = loadSql("createOrder.sql");
    private static final String UPDATE_PRODUCT_PRICE = loadSql("updateProductPrice.sql");
    private static final String UPDATE_PRODUCT_QUANTITY = loadSql("updateProductQuantity.sql");
    private static final String DELETE_ORDER = loadSql("deleteOrder.sql");
    private static final String DELETE_TEST_DATA = loadSql("deleteTestData.sql");
    private static final String TEST_QUERIES = loadSql("test-queries.sql");

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            try {
                properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Flyway flyway = Flyway.configure().dataSource(
                            properties.getProperty("flyway.url"),
                            properties.getProperty("flyway.user"),
                            properties.getProperty("flyway.password")
                    )
                    .locations(properties.getProperty("flyway.locations"))
                    .load();

            flyway.migrate();

            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password")
            )) {
                connection.setAutoCommit(false);
                try {
                    showLastOrders(connection);
                    int productId = insertProduct(connection, "Тестовый продукт", 99999., 10, "Тест");
                    int customerId = insertCustomer(connection, "Тест", "Тестов", "77777777777", "test@test@test.com");
                    int orderID = createOrder(connection, productId, customerId, 1, 1);
                    showLastOrders(connection);
                    updateProductPrice(connection, productId, 9999);
                    updateProductQuantity(connection, productId, 1);
                    deleteOrder(connection, orderID);
                    connection.commit();
                    showLastOrders(connection);
                    testQueries(connection);
                    deleteTestData(connection);
                    connection.commit();
                    connection.close();

                } catch (Exception e) {
                    connection.rollback();
                    throw e;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int insertProduct(
            Connection connection, String description, double price, int quantity, String category) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, description);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, category);

            int rows = ps.executeUpdate();
            System.out.printf("\nДобавлен товар: %s%n", description);

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int productId = keys.getInt(1);
                    System.out.printf("ID нового товара: %d%n", productId);
                    return productId;
                }
            }
        }
        return -1;
    }

    private static int insertCustomer(
            Connection connection, String firstName, String lastName, String phone, String email) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setString(4, email);

            int rows = ps.executeUpdate();
            System.out.printf("\nДобавлен покупатель: %s%n", firstName + " " + lastName);

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int customerId = keys.getInt(1);
                    System.out.printf("ID нового покупателя: %d%n", customerId);
                    return customerId;
                }
            }
        }
        return -1;
    }

    private static int createOrder(Connection connection, int productId, int customerId, int quantity, int statusId)
            throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, productId);
            ps.setInt(2, customerId);
            ps.setInt(3, quantity);
            ps.setInt(4, statusId);

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int orderId = keys.getInt(1);
                    System.out.printf("\nСоздан заказ с ID: %d%n", orderId);
                    return orderId;
                }
            }
        }
        return -1;
    }

    private static void showLastOrders(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(LAST_5_ORDERS)) {

            System.out.println("\nПоследние 5 заказов");
            System.out.printf("%-3s %-20s %-64s %-8s %-10s %-18s %-20s%n",
                    "ID", "Покупатель", "Товар", "Кол-во", "Цена", "Статус", "Дата");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Timestamp date = rs.getTimestamp("order_date");
                String customerName = rs.getString("customer");
                String product = rs.getString("description");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String status = rs.getString("status");

                System.out.printf("%-3d %-20s %-64s %-8d %-10.2f %-15s %-20s%n",
                        orderId, customerName, product, quantity, price, status, date.toLocalDateTime().toLocalDate());
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    private static void updateProductPrice(Connection connection, int productId, double newPrice) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_PRICE)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, productId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.printf("\nЦена товара с ID %d изменена. Новая цена: %.2f%n", productId, newPrice);
            } else {
                System.out.printf("Товар с ID %d не найден, обновление не выполнено.%n", productId);
            }
        }
    }

    private static void updateProductQuantity(Connection connection, int productId, int newQuantity) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_QUANTITY)) {
            ps.setInt(1, newQuantity);
            ps.setInt(2, productId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.printf("Количество товара с ID %d изменено. Новое количество: %d%n", productId, newQuantity);
            } else {
                System.out.printf("Товар с ID %d не найден, обновление не выполнено.%n", productId);
            }
        }
    }

    private static void deleteOrder(Connection connection, int orderId) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_ORDER)) {
            ps.setInt(1, orderId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.printf("\nЗаказ ID %d удалён%n", orderId);
            } else {
                System.out.printf("Заказ ID %d не найден, удаление не выполнено%n", orderId);
            }
        }
    }

    private static void deleteTestData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE_TEST_DATA);
            System.out.println("\nТестовые данные удалены");
        }
    }

    private static void testQueries(Connection connection) throws SQLException {
        System.out.println("\nВыполнение тестовых SQL-запросов");

        String[] queries = TEST_QUERIES.split(";");
        int queryCount = 1;

        for (String query : queries) {
            query = query.trim();
            //if (query.isEmpty() || query.startsWith("--")) continue;

            System.out.printf("\n[%d] Запрос:\n%s\n", queryCount++, query);

            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(query)) {

                ResultSetMetaData meta = rs.getMetaData();
                int columnCount = meta.getColumnCount();

                // Заголовки
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-64s", meta.getColumnName(i));
                }
                System.out.println("\n--------------------------------------------------");

                // Строки результата
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-64s", rs.getString(i));
                    }
                    System.out.println();
                }

            } catch (SQLException e) {
                System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            }
        }
    }


}
