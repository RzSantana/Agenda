import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldPrompt extends JTextField {
    private String placeholder;
    private Font italicFont = new Font(getFont().getName(), Font.ITALIC, 12);
    private Font normalFont = new Font(getFont().getName(), Font.PLAIN, 12);


    public JTextFieldPrompt(String text, int columns) {
        super();
        this.placeholder = text;
        setColumns(columns);

        setText(this.placeholder);

        setFont(italicFont);
        setForeground(new Color(0, 0, 0, .5f));

        setMargin(new Insets(5, 10, 5, 10));

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setText("");
                setFont(normalFont);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isBlank()) {
                    setText(placeholder);
                }
            }
        });
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(String text) {
        this.placeholder = text;
    }
}
