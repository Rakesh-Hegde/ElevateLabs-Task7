import java.sql.*;

public class EmployeeDAO {
    // Add Employee
    public void addEmployee(String name, String dept, double salary) {
        String query = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("✅ Employee added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {
        String query = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("department") + " | " +
                                   rs.getDouble("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    public void updateEmployee(int id, String name, String dept, double salary) {
        String query = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Employee updated!" : "❌ Employee not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Employee deleted!" : "❌ Employee not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
