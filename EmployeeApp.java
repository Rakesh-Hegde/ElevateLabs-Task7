import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n--- Employee Database App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    dao.addEmployee(name, dept, sal);
                    break;
                case 2:
                    dao.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = sc.next();
                    System.out.print("Enter New Dept: ");
                    String newDept = sc.next();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    dao.updateEmployee(id, newName, newDept, newSal);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteEmployee(delId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
