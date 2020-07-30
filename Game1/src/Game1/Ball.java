package Game1;

import java.awt.*;

public class Ball extends GameObject {

    private int velX = -1;
    private int velY = -1;
    private Handler handler;
    private Game game;

    public Ball(int x, int y, ID id, Handler handler, Game game) {
        super(x, y, id);
        this.handler = handler;
        this.game = game;
        try {
            game.thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Rectangle getBoundaries() {
        return new Rectangle(x, y, 10, 10);
    }

    private void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {

            GameObject tempObject = handler.gameObjects.get(i);

            if(tempObject.getId() == ID.Player) {
                if(getBoundaries().intersects(tempObject.getBoundaries())) velX *= -1;
            }

        }
    }

    private void score() throws InterruptedException {

        if (x == -11) {
            game.setScore2();
            x = Game.WIDHT/2;
            y = Game.HIGH/2;
            velX *= -1;
            velY *= -1;
            game.thread.sleep(500);
        } else if (x == Game.WIDHT) {
            game.setScore1();
            x = Game.WIDHT/2;
            y = Game.HIGH/2;
            velX *= -1;
            velY *= -1;
            game.thread.sleep(100);
        }
    }

    @Override
    public void tick() {
        x = x + velX;
        y = y + velY;

        if (y == 10 || y == Game.HIGH - 20) velY *= -1;
        collision();
        try {
            score();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10);
    }
}
