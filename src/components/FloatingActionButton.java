package components;

import panels.MainPanel;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class FloatingActionButton extends LayerUI<MainPanel> {
    private Shape shape;
    private Image image;
    private Color defaultColor = new Color(35, 190, 246);
    private Color pressColor = defaultColor.brighter();
    private Color hoverColor = defaultColor.darker();
    private boolean mouseHovered;
    private boolean mousePressed;

    public FloatingActionButton() {
        image = new ImageIcon(getClass().getResource("../images/plus.png")).getImage();
    }


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        if (c instanceof JLayer) {
            ((JLayer<?>) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
        }
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
        if (c instanceof JLayer) {
            ((JLayer<?>) c).setLayerEventMask(0);
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);


        Graphics2D graphics2D = (Graphics2D) g.create();

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(defaultColor);

        if (mousePressed) {
            graphics2D.setColor(pressColor);
        }

        if (mouseHovered) {
            graphics2D.setColor(hoverColor);
        }

        // Establece la forma
        int size = 50;
        int x = c.getWidth() - size - 15;
        int y = c.getHeight() - size - 15;
        shape = new Ellipse2D.Double(x, y, size, size);
        graphics2D.fill(shape);

        // Pintar icono
        int iconSize = 24;
        int iconX = (size - iconSize) / 2;
        int iconY = (size - iconSize) / 2;
        graphics2D.drawImage(image, x+iconX, y+iconY, null);

        graphics2D.dispose();
    }

    @Override
    protected void processMouseEvent(MouseEvent event, JLayer<? extends MainPanel> layer) {
        if (mouseHovered) {
            event.consume();
        }

        if (SwingUtilities.isLeftMouseButton(event)) {
            if (event.getID() == MouseEvent.MOUSE_PRESSED) {
                if (mouseHovered) {
                    mousePressed = true;
                    layer.repaint(shape.getBounds());
                }
            }

            if (event.getID() == MouseEvent.MOUSE_RELEASED) {
                mousePressed = false;
                layer.repaint(shape.getBounds());
            }
        }
    }

    @Override
    protected void processMouseMotionEvent(MouseEvent event, JLayer<? extends MainPanel> layer) {
        Point pointer = SwingUtilities.convertPoint(event.getComponent(), event.getPoint(), layer.getView());
        boolean hover = shape.contains(pointer);

        if (mouseHovered != hover) {
            mouseHovered = hover;
            layer.repaint(shape.getBounds());
        }
    }
}