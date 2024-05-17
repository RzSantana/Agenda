package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderMain extends JPanel {
    private String textTitle = "Contactos";
    private JLabel title;

    public HeaderMain() {
        setBorder(new EmptyBorder(20, 0, 20, 0));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        title = new JLabel(this.textTitle);
        title.setFont(new Font(getFont().getName(), Font.BOLD, 24));
        add(title);

        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }
}
