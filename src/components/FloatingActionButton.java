package components;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;

public class FloatingActionButton extends LayerUI<Component> {
    private Shape shape;
    private Image iconPlus;
    private Color defaultColor = new Color(167, 83, 223);
    private Color pressColor = defaultColor.darker();
    private Color hoverColor = defaultColor.brighter();
    private boolean mouseHovered;
    private boolean mousePressed;
    private ContactsList refContactsList;

    public FloatingActionButton() {
        iconPlus = new ImageIcon(getClass().getResource("../images/plus.png")).getImage();
    }

    public void setRefContactsList(ContactsList ref) {
        refContactsList = ref;
    }

    // Se configura el componente para que escuche eventos del raton, una vez se renderiaza
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        if (c instanceof JLayer) {
            ((JLayer<?>) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
        }
    }

    // Se desactiva la escucha de eventos del raton, una vez se deja de renderizar
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
        int size = 50;
        int x = c.getWidth() - size - 20;
        int y = c.getHeight() - size - 20;
        int iconSize = 24;
        int iconX = (size - iconSize) / 2;
        int iconY = (size - iconSize) / 2;

        Graphics2D button = (Graphics2D) g.create();
        button.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BufferedImage shadowImage = createBlurImage(size);
        button.drawImage(shadowImage, x-20, y-20, null);

        // Pinta el boton según la interacción
        if (mousePressed) {
            button.setColor(pressColor);
        } else if (mouseHovered) {
            button.setColor(hoverColor);
        } else {
            button.setColor(defaultColor);
        }

        // Establece la forma
        shape = new Ellipse2D.Double(x, y, size, size);
        button.fill(shape);

        // Pinta el icono
        button.drawImage(iconPlus, x + iconX, y + iconY, null);

        button.dispose();
    }

    @Override
    protected void processMouseEvent(MouseEvent event, JLayer<? extends Component> layer) {
        if (mouseHovered) {
            event.consume(); // Para que la interación solo afecte al layer
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
                if (mouseHovered && refContactsList != null) {
                    handleClick();
                }
                layer.repaint(shape.getBounds());
            }
        }
    }

    @Override
    protected void processMouseMotionEvent(MouseEvent event, JLayer<? extends Component> layer) {
        Point pointer = SwingUtilities.convertPoint(event.getComponent(), event.getPoint(), layer.getView());
        boolean hover = shape.contains(pointer);

        if (mouseHovered != hover) {
            mouseHovered = hover;
            layer.repaint(shape.getBounds());

            if (hover) {
                layer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                layer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }

        if (mousePressed) {
            event.consume(); // Para que la interación solo afecte al layer
        }
    }

    private BufferedImage createBlurImage(int size) {
        int shadowSize = size+40;
        BufferedImage shadowImage = new BufferedImage(shadowSize, shadowSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = shadowImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar elíptico para la sombra
        g2d.setBackground(Color.DARK_GRAY);
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fill(new Ellipse2D.Double((size*.2f)*2, (size*.2f)*2, size+(size*.1f), size+(size*.1f)));
        g2d.dispose();

        // Crear un kernel más grande para un desenfoque más notorio
        int kernelSize = 15;
        float[] matrix = new float[kernelSize * kernelSize];
        for (int i = 0; i < kernelSize * kernelSize; i++) {
            matrix[i] = .8f / (kernelSize * kernelSize);
        }

        BufferedImageOp op = new ConvolveOp(new Kernel(kernelSize, kernelSize, matrix));
        return op.filter(shadowImage, null);
    }

    public void handleClick() {
        refContactsList.addContact(new Contact("Carlos", "618 49 44 62"));
    }
}