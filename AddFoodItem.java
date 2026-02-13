import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddFoodItem extends JFrame {

    JTextField nameField, categoryField, priceField;

    public AddFoodItem() {

        setTitle("Add Food Item");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Food Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Category:"));
        categoryField = new JTextField();
        add(categoryField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        JButton addBtn = new JButton("Add");
        add(addBtn);

        addBtn.addActionListener(e -> addFood());

        setVisible(true);
    }

    private void addFood() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO food (food_name, category, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nameField.getText());
            ps.setString(2, categoryField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Food Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
