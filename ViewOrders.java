import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewOrders extends JFrame {

    JTextArea area;

    public ViewOrders() {

        setTitle("View Orders");
        setSize(600, 400);
        setLocationRelativeTo(null);

        area = new JTextArea();
        add(new JScrollPane(area));

        loadOrders();

        setVisible(true);
    }

    private void loadOrders() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                area.append("Order ID: " + rs.getInt("order_id")
                        + " | Customer ID: " + rs.getInt("customer_id")
                        + " | Date: " + rs.getDate("order_date")
                        + " | Total: " + rs.getDouble("total_amount") + "\n");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
