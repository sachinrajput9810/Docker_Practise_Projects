import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLNameApp {

    // Create connection to MySQL database
    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://mysqldb:3306/userinfo";

        String user = "root";
        String password = "Albert9313@";

        return DriverManager.getConnection(url, user, password);
    }

    // Create 'names' table if it doesn't exist
    public static void createTable(Connection conn) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS names (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY," +
                       "name VARCHAR(255))";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(query);
        }
    }

    // Insert name into database
    public static void insertName(Connection conn, String name) throws SQLException {
        String query = "INSERT INTO names (name) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    // Fetch all names from database
    public static void fetchAllNames(Connection conn) throws SQLException {
        String query = "SELECT name FROM names";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            boolean found = false;
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                found = true;
            }

            if (!found) {
                System.out.println("No names found in the database.");
            }
        }
    }

    // Main CLI method
    public static void main(String[] args) {
        try (Connection conn = createConnection();
             Scanner scanner = new Scanner(System.in)) {

            createTable(conn);

            while (true) {
                System.out.println("\n1. Add a name");
                System.out.println("2. Show all names");
                System.out.println("3. Quit");
                System.out.print("Enter your choice: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter a name: ");
                        String name = scanner.nextLine();
                        insertName(conn, name);
                        System.out.println("Name '" + name + "' added to the database.");
                        break;

                    case "2":
                        System.out.println("Names in the database:");
                        fetchAllNames(conn);
                        break;

                    case "3":
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
