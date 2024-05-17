import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldPrompt extends JTextField {
    private final String placeholder;

    private Font defaultFont = new Font(getFont().getName(), Font.PLAIN, 12);
    private final Font placeholderFont = new Font(defaultFont.getName(), Font.ITALIC, defaultFont.getSize());

    private Color defaultColor = new Color(0, 0, 0, 1f);
    private final Color placeholderColor = new Color(0, 0, 0, .6f);


    public JTextFieldPrompt(String text, int columns) {
        this.placeholder = text;

        setText(placeholder);
        setColumns(columns);

        setActivePlaceholder(true);

        setMargin(new Insets(5, 10, 5, 10));

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setActivePlaceholder(false);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isBlank()) {
                    setActivePlaceholder(true);
                }
            }
        });

    }
    public void setDefaultFont(Font newFont) {
        this.defaultFont = newFont;
    }

    public void setDefaultColor(Color newColor) {
        this.defaultColor = newColor;
    }

    public void setActivePlaceholder(boolean activePlaceholder) {
        if (activePlaceholder) {
            setText(placeholder);
            setFont(placeholderFont);
            setForeground(placeholderColor);
        } else {
            setText("");
            setFont(defaultFont);
            setForeground(defaultColor);
        }
    }
}
