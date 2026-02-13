import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageCustomers extends JFrame {

    JTextArea area;

    public ManageCustomers() {

        setTitle("Manage Customers");
        setSize(600, 400);
        setLocationRelativeTo(null);

        area = new JTextArea();
        add(new JScrollPane(area));

        loadCustomers();

        setVisible(true);
    }

    private void loadCustomers() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                area.append("ID: " + rs.getInt("customer_id")
                        + " | Name: " + rs.getString("customer_name")
                        + " | Phone: " + rs.getString("phone")
                        + " | Email: " + rs.getString("email") + "\n");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
