import components.FloatingActionButton;
import components.HeaderMain;
import components.Search;
import panels.MainPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Agenda extends JFrame {
    private JPanel body;

    public Agenda() {
        setTitle("Agenda");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        setLocationRelativeTo(null);


        body = new JPanel();
        body.setBackground(Color.WHITE);
        body.setBorder(new EmptyBorder(0, 20, 0, 20));
        body.setLayout(new BorderLayout());

        setContentPane(body);

        add(new JLayer<>(new MainPanel(), new FloatingActionButton()));


    }
}
