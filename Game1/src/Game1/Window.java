package Game1;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window (int width, int high, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, high));
        frame.setMaximumSize(new Dimension(width, high));
        frame.setMinimumSize(new Dimension(width, high));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}