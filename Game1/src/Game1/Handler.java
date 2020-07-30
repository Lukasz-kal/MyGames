package Game1;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    public void tick(){
        for (GameObject tempObject : gameObjects) {
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject tempObject : gameObjects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }
}
