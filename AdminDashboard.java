import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard(String adminName) {

        setTitle("Admin Dashboard - FlavourFly");
        setSize(1000, 700);   // Increased height slightly
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // Welcome Heading
        JLabel title = new JLabel("Welcome Admin");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(250, 60, 500, 40);
        panel.add(title);

        // Buttons
        JButton addFoodBtn = createButton("Add Food Item", 180);
        JButton updateFoodBtn = createButton("Update Food Item", 250);
        JButton viewOrdersBtn = createButton("View Orders", 320);
        JButton manageUsersBtn = createButton("Manage Customers", 390);
        JButton viewFoodBtn = createButton("View Food Items", 460); // NEW BUTTON
        JButton logoutBtn = createButton("Logout", 530);

        panel.add(addFoodBtn);
        panel.add(updateFoodBtn);
        panel.add(viewOrdersBtn);
        panel.add(manageUsersBtn);
        panel.add(viewFoodBtn);   // Added
        panel.add(logoutBtn);

        // ✅ CONNECT BUTTONS TO PAGES
        addFoodBtn.addActionListener(e -> new AddFoodItem());
        updateFoodBtn.addActionListener(e -> new UpdateFoodItem());
        viewOrdersBtn.addActionListener(e -> new ViewOrders());
        manageUsersBtn.addActionListener(e -> new ManageCustomers());
        viewFoodBtn.addActionListener(e -> new ViewFoodItems()); // NEW CONNECTION

        // Logout Action
        logoutBtn.addActionListener(e -> {
            new LandingPage();
            dispose();
        });

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBounds(390, y, 220, 45);
        return btn;
    }
}
