import components.FloatingActionButton;
import panels.MainPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Agenda extends JFrame {
    private JPanel body;
    private MainPanel mainPanel;
    private FloatingActionButton floatingActionButton;

    public Agenda() {
        body = new JPanel();
        body.setBackground(Color.WHITE);
        body.setBorder(new EmptyBorder(0, 20, 0, 20));
        body.setLayout(new BorderLayout());

        mainPanel = new MainPanel();
        floatingActionButton = new FloatingActionButton();
        floatingActionButton.setRefContactsList(mainPanel.getContactsList());

        setTitle("Agenda");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        setLocationRelativeTo(null);
        setContentPane(body);

        add(new JLayer<>(mainPanel, floatingActionButton));
    }
}
