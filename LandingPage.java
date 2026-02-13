import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {

    public LandingPage() {

        setTitle("FlavourFly - Premium Food Experience");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // SET GRADIENT PANEL AS CONTENT
        PremiumGradientPanel panel = new PremiumGradientPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // ===== TITLE =====
        JLabel title = new JLabel("FlavourFly", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 60));
        title.setForeground(new Color(255, 140, 0));
        title.setBounds(350, 80, 500, 80);
        panel.add(title);

        // TAGLINE
        JLabel tagline = new JLabel(
                "<html><div style='text-align:center;'>Elevate Your <span style='color:#FF8C00;'>Dining</span> Experience.</div></html>",
                JLabel.CENTER
        );
        tagline.setFont(new Font("Segoe UI", Font.BOLD, 45));
        tagline.setForeground(Color.WHITE);
        tagline.setBounds(250, 170, 700, 120);
        panel.add(tagline);

        //  DESCRIPTION 
        JLabel desc = new JLabel("Welcome to FlavourFly. Choose your portal to begin.", JLabel.CENTER);
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        desc.setForeground(new Color(220, 220, 220));
        desc.setBounds(300, 290, 600, 30);
        panel.add(desc);

        // CUSTOMER CARD 
        JPanel customerCard = createCard(
                "Customer Portal",
                "Explore menu, place orders, and enjoy.",
                Color.WHITE,
                Color.BLACK,
                true   
        );
        customerCard.setBounds(250, 380, 320, 220);
        panel.add(customerCard);

        // ADMIN CARD 
        JPanel adminCard = createCard(
                "Admin Dashboard",
                "Manage menu items and track orders.",
                new Color(20, 30, 60),
                Color.WHITE,
                false   
        );
        adminCard.setBounds(630, 380, 320, 220);
        panel.add(adminCard);

        setVisible(true);
    }

    JPanel createCard(String title, String desc, Color bg, Color textColor, boolean isCustomer) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(bg);
        card.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));

        JLabel t = new JLabel(title);
        t.setFont(new Font("Segoe UI", Font.BOLD, 20));
        t.setForeground(textColor);
        t.setBounds(20, 25, 260, 30);

        JLabel d = new JLabel("<html><body style='width:260px'>" + desc + "</body></html>");
        d.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        d.setForeground(textColor);
        d.setBounds(20, 65, 260, 50);

        JButton btn = new JButton("Enter →");
        btn.setFocusPainted(false);
        btn.setBounds(20, 140, 140, 40);

    
        btn.addActionListener(e -> {
            if (isCustomer) {
                new CustomerChoice();   // opens sign in / sign up page
            } else {
                new AdminLogin();       // opens admin login
            }
            dispose();   // close landing page
        });

        card.add(t);
        card.add(d);
        card.add(btn);

        return card;
    }
}
