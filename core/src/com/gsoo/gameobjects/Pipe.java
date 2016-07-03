package com.gsoo.gameobjects;

/**
 * Created by gavinsu on 17/06/16.
 */

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Pipe extends Scrollable {

    private Random r;
    private Rectangle endUp, endDown, barUp, barDown;

    public static final int VERTICAL_GAP = 45;
    public static final int CAP_WIDTH = 22;
    public static final int CAP_HEIGHT = 11;
    private float groundY;

    private boolean isScored = false;

    public Pipe(float x, float y, int width, int height, float scrollSpeed,
                float groundY) {
        super(x, y, width, height, scrollSpeed);
        r = new Random();
        endUp = new Rectangle();
        endDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();

        this.groundY = groundY;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));

        endUp.set(position.x - (CAP_WIDTH - width) / 2, position.y + height
                - CAP_HEIGHT, CAP_WIDTH, CAP_HEIGHT);
        endDown.set(position.x - (CAP_WIDTH - width) / 2, barDown.y,
                CAP_WIDTH, CAP_HEIGHT);

    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    public boolean collides(Bird bird) {
        if (position.x < bird.getX() + bird.getWidth()) {
            return (Intersector.overlaps(bird.getBoundingCircle(), barUp)
                    || Intersector.overlaps(bird.getBoundingCircle(), barDown)
                    || Intersector.overlaps(bird.getBoundingCircle(), endUp) || Intersector
                    .overlaps(bird.getBoundingCircle(), endDown));
        }
        return false;
    }

    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }

    public Rectangle getEndUp() {
        return endUp;
    }

    public Rectangle getEndDown() {
        return endDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean b) {
        isScored = b;
    }

}