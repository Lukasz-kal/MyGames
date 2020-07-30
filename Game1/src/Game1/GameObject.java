package Game1;

import java.awt.*;

public abstract class GameObject {
    protected int x,y;
    protected ID id;
    protected  int velX, velY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract Rectangle getBoundaries();

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getVelY() {
        return velY;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }
}
