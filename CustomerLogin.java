import javax.swing.*;
import java.awt.*;

public class CustomerLogin extends JFrame {

    public CustomerLogin() {
        setTitle("Customer Login - FlavourFly");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel title = new JLabel("Customer Login", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(100, 30, 300, 40);
        panel.add(title);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(100, 100, 80, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(180, 100, 200, 25);
        panel.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(100, 150, 80, 25);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(180, 150, 200, 25);
        panel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(180, 200, 100, 35);
        panel.add(loginBtn);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(290, 200, 90, 35);
        signupBtn.addActionListener(e -> {
            new CustomerSignup();
            dispose();
        });
        panel.add(signupBtn);

        JButton backBtn = new JButton("← Back");
        backBtn.setBounds(20, 20, 90, 30);
        backBtn.addActionListener(e -> {
            new LandingPage();
            dispose();
        });
        panel.add(backBtn);

        //  LOGIN ACTION ADDED 
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passField.getPassword());

            if (!email.isEmpty() && !password.isEmpty()) {
                new CustomerDashboard(email);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valid credentials!");
            }
        });

        setVisible(true);
    }
}
