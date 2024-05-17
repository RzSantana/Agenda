import components.HeaderMain;
import components.Search;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Agenda extends JFrame {
    private JPanel mainPanel;
    private JPanel header;
    private Search search;

    public Agenda() {
        setTitle("Agenda");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setAutoRequestFocus(false);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(0, 20, 0,20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        setContentPane(mainPanel);

        header = new HeaderMain();
        add(header);

        search = new Search("Buscar Contacto...");
        add(search);
    }
}
