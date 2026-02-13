import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {

    public CustomerDashboard(String customerName) {

        setTitle("Customer Dashboard - FlavourFly");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // Title
        JLabel title = new JLabel("Welcome, " + customerName + " 👋");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(300, 40, 400, 40);
        panel.add(title);

        // Buttons
        JButton viewMenuBtn = createButton("View Menu", 250);
        JButton placeOrderBtn = createButton("Place Order", 320);
        JButton orderHistoryBtn = createButton("Order History", 390);
        JButton logoutBtn = createButton("Logout", 460);

        panel.add(viewMenuBtn);
        panel.add(placeOrderBtn);
        panel.add(orderHistoryBtn);
        panel.add(logoutBtn);

        // Logout action
        logoutBtn.addActionListener(e -> {
            new LandingPage();
            dispose();
        });

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBounds(350, y, 200, 45);
        return btn;
    }
}
