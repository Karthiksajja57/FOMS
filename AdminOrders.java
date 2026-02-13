import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminOrders extends JFrame {

    public AdminOrders() {
        setTitle("FlavourFly - Order Management");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Column Names
        String[] columns = {
            "Order ID", "Customer Name", "Food Item", "Quantity", "Total Price", "Status"
        };

        // Sample Data
        Object[][] data = {
            {"501", "Anwar", "Chicken Biryani", "2", "₹400", "Pending"},
            {"502", "Rahim", "Veg Burger", "1", "₹120", "Delivered"},
            {"503", "Sara", "Pizza", "3", "₹900", "Preparing"}
        };

        // Table Model
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminOrders();
    }
}
