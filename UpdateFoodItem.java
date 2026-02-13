import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateFoodItem extends JFrame {

    JTextField idField, priceField;

    public UpdateFoodItem() {

        setTitle("Update Food Item");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Food ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("New Price:"));
        priceField = new JTextField();
        add(priceField);

        JButton updateBtn = new JButton("Update");
        add(updateBtn);

        updateBtn.addActionListener(e -> updateFood());

        setVisible(true);
    }

    private void updateFood() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE food SET price = ? WHERE food_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, Double.parseDouble(priceField.getText()));
            ps.setInt(2, Integer.parseInt(idField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Food Updated Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
