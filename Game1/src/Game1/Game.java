package Game1;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    Thread thread;
    public static final int WIDHT = 1280, HIGH = WIDHT /12 * 9;
    private int score1 = 0;
    private int score2 = 0;
    private boolean running = false;
    private Handler handler;
    private Player player;
    private Player player2;
    private GameObject ball;

    public Game () {
        new Window(WIDHT, HIGH, "Mein erstes Spiel", this);
        handler = new Handler();
        player = new Player(0,HIGH/2-100,ID.Player);
        player2 = new Player(1260, HIGH/2-100, ID.Player);
        handler.addObject(player);
        handler.addObject(player2);
        this.addKeyListener(new KeyInput(handler, player, player2));
        ball = new Ball(640, 350,ID.Ball, handler, this);
        handler.addObject(ball);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 500.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                //updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDHT, HIGH);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.drawLine(WIDHT/2, 0, WIDHT/2,HIGH);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawString("Score Player 1: " + score1, WIDHT/5, 20);
        g2d.drawString("Score Player 2: " + score2, 850, 20);
        handler.render(g);
        g.dispose();
        bs.show();
    }

    public void setScore1() {
        score1++;
    }

    public void setScore2() {
        score2++;
    }

    public static void main (String args[]) {
        new Game();
    }
}
