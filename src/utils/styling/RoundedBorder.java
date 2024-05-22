package utils.styling;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private float weight;
    private int radius;
    private Color defaultColor;

    public RoundedBorder(int weight, int radius, Color color) {
        this.weight = weight;
        this.radius = radius;
        this.defaultColor = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D border = (Graphics2D) g.create();
        border.setColor(defaultColor);
        border.setStroke(new BasicStroke(weight));
        border.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        border.drawRoundRect(x+1, y+1, width-4, height-4, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius,this.radius,this.radius,this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
