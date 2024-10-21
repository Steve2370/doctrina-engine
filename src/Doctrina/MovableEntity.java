package Doctrina;

import java.awt.*;

public abstract class MovableEntity extends StaticEntity {

    private int speed = 1;
    private Direction direction = Direction.UP;
    private Collision collision;

    private int lastX = Integer.MIN_VALUE;
    private int lastY = Integer.MIN_VALUE;
    private boolean moved;

    public void update () {
        moved = false;
    }

    public MovableEntity() {
        collision = new Collision(this);
    }

    public void  move() {
        int allowedSpeed = collision.getAllowedSpeed();
        x += direction.calculateVelocityX(allowedSpeed);
        y += direction.calculateVelovityY(allowedSpeed);

        moved = (x != lastX || y != lastY);
        lastX = x;
        lastY = y;
    }

    public boolean hasMove() {
        return moved;
    }

    public void move(Direction direction) {
        this.direction = direction;
        move();
    }

    public void moveUp() {
        move(Direction.UP);
    }

    public void moveDown() {
        move(Direction.DOWN);
    }

    public void moveLeft() {
        move(Direction.LEFT);
    }

    public void moveRight() {
        move(Direction.RIGHT);
    }

    public Rectangle getHitBox() {
        if (direction == Direction.UP) {
            return getUpperHitBox();
        }
        if (direction == Direction.DOWN) {
            return getLowerHitBox();
        }
        if (direction == Direction.LEFT) {
            return getLeftHitBox();
        }
        if (direction == Direction.RIGHT) {
            return getRightHitBox();
        }
        return getBounds();
    }

    private Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }

    private Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    private Rectangle getLeftHitBox() {
        return new Rectangle(x - speed, y, speed, height);
    }

    private Rectangle getRightHitBox() {
        return new Rectangle(x + width, y, speed, height);
    }

    public boolean hitBoxIntersectWith(StaticEntity other) {
        if (other == null) {
            return false;
        }
        return getHitBox().intersects(other.getBounds());
    }

    public void drawHitBox(Canvas canvas) {
        Rectangle rect = getHitBox();
        canvas.drawRectangle(rect.x, rect.y, rect.width, rect.height, Color.BLUE);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
