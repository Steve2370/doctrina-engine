package Tank;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovementController;

import java.awt.*;

// resources
// - images
// - audios

public class Tank extends ControllableEntity {

    private int cooldown = 0;


    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleprot(300, 300);
    }

    public Missile fire() {
        cooldown = 40;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
        cooldown--;
        if (cooldown < 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);

        // float alpha - (cooldown / 40f)
        int coolDownWidth = (cooldown * width) / 40;
        canvas.drawRectangle(x, y - 5, coolDownWidth, 2, Color.RED);

        if (hasMove()) {
            drawHitBox(canvas);
        }
    }
}
