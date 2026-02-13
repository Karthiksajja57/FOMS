import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame {

    public AdminLogin() {
        setTitle("Admin Login - FlavourFly");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel title = new JLabel("Admin Login", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(100, 30, 300, 40);
        panel.add(title);

        JLabel userLabel = new JLabel("Admin ID:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(100, 120, 80, 25);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(180, 120, 200, 25);
        panel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(100, 170, 80, 25);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(180, 170, 200, 25);
        panel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(200, 230, 100, 35);
        panel.add(loginBtn);

        JButton backBtn = new JButton("← Back");
        backBtn.setBounds(20, 20, 90, 30);
        backBtn.addActionListener(e -> {
            new LandingPage();
            dispose();
        });
        panel.add(backBtn);

        //  LOGIN ACTION ADDED 
        loginBtn.addActionListener(e -> {
            String adminId = userField.getText();
            String password = new String(passField.getPassword());

            if (adminId.equals("admin") && password.equals("1234")) {
                new AdminDashboard(adminId);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Credentials!");
            }
        });

        setVisible(true);
    }
}
