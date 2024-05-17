package components;

import javax.swing.*;
import java.awt.*;

public class Search extends JPanel {
    private TextFieldPrompt inputSearch;

    public Search(String placeholder) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        inputSearch = new TextFieldPrompt(placeholder, 0);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(inputSearch, gbc);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }
}
