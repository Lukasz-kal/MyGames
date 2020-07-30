package Game1;

import java.awt.*;

public class Player extends GameObject {

    private boolean up = false;
    private boolean down = false;

    public Player(int x, int y, ID id) {
        super(x, y, id);
        velX = 2;
        velY = 2;

    }

    public void forbiddenMoves() {
        if (y >= Game.HIGH-120) y = Game.HIGH-120;
        if (y <= 0) y = 0;
    }

    public Rectangle getBoundaries() {
        return new Rectangle(x, y, 30, 90);
    }

    public void tick() {
        move();
        forbiddenMoves();
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 90);

    }

    public void setUP (boolean isPressed) {
         up = isPressed;
    }


    public void setDown (boolean isPressed) {
        down = isPressed;
    }

    private void move() {
        if (up) y = y-1;
        if (down) y = y+1;
    }
}
