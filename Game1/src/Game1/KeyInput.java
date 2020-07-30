package Game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private Player player1;
    private Player player2;

    public KeyInput(Handler handler, Player player1, Player player2) {
        this.handler = handler;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
             player1.setUP(true);
        }
        if (key == KeyEvent.VK_S) {
            player1.setDown(true);
        }
        if (key == KeyEvent.VK_UP) {
            player2.setUP(true);
        }
        if (key == KeyEvent.VK_DOWN) {
            player2.setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            player1.setUP(false);
        }
        if (key == KeyEvent.VK_S) {
            player1.setDown(false);
        }
        if (key == KeyEvent.VK_UP) {
            player2.setUP(false);
        }
        if (key == KeyEvent.VK_DOWN) {
            player2.setDown((false));
        }
    }
}
