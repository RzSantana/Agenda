package panels;

import components.HeaderMain;
import components.Search;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private HeaderMain header;
    private Search search;

    public MainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        header = new HeaderMain();
        search = new Search("Buscar Contacto...");

        add(header);
        add(search);
    }
}
