import javax.swing.*;
import java.awt.*;

public class CustomerChoice extends JFrame {

    public CustomerChoice() {

        setTitle("Customer Portal - FlavourFly");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel title = new JLabel("Customer Portal", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(100, 60, 300, 40);
        panel.add(title);

        JButton signInBtn = new JButton("Sign In");
        signInBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signInBtn.setBounds(170, 150, 150, 45);
        signInBtn.addActionListener(e -> {
            new CustomerLogin();
            dispose();
        });
        panel.add(signInBtn);

        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        signUpBtn.setBounds(170, 210, 150, 45);
        signUpBtn.addActionListener(e -> {
            new CustomerSignup();
            dispose();
        });
        panel.add(signUpBtn);

        JButton backBtn = new JButton("← Back");
        backBtn.setBounds(20, 20, 90, 30);
        backBtn.addActionListener(e -> {
            new LandingPage();
            dispose();
        });
        panel.add(backBtn);

        setVisible(true);
    }
}
