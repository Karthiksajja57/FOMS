import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewFoodItems extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewFoodItems() {

        setTitle("Available Food Items");
        setSize(800, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Food ID");
        model.addColumn("Food Name");
        model.addColumn("Category");
        model.addColumn("Price");
        model.addColumn("Availability Status");  // NEW COLUMN

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadFoodData();

        setVisible(true);
    }

    private void loadFoodData() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM food_items";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("food_id"),
                        rs.getString("food_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("status")   // FETCH STATUS
                });
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
