import javax.swing.*;
import java.awt.*;

public class PremiumGradient extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        Color c1 = new Color(20, 0, 40);
        Color c2 = new Color(0, 30, 60);

        GradientPaint gp = new GradientPaint(0, 0, c1, w, h, c2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}
