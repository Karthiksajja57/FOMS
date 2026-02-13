import javax.swing.*;
import java.awt.*;

public class CustomerSignup extends JFrame {

    public CustomerSignup() {
        setTitle("Customer Sign Up - FlavourFly");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel title = new JLabel("Customer Sign Up", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(100, 30, 300, 40);
        panel.add(title);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(100, 100, 100, 25);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 200, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(100, 140, 100, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(200, 140, 200, 25);
        panel.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(100, 180, 100, 25);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(200, 180, 200, 25);
        panel.add(passField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 240, 120, 40);
        panel.add(registerBtn);

        JButton backBtn = new JButton("← Back to Login");
        backBtn.setBounds(180, 300, 160, 35);
        backBtn.addActionListener(e -> {
            new CustomerLogin();
            dispose();
        });
        panel.add(backBtn);

        setVisible(true);
    }
}
