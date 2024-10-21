package Tank;

import Doctrina.Canvas;
import Doctrina.CollidableRepository;
import Doctrina.Game;
import Doctrina.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {

    private GamePad gamePad;
    private Tank tank;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    protected void intialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();

        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(300, 110));
        bricks.add(new Brick(280, 120));
        bricks.add(new Brick(304, 170));
        bricks.add(new Brick(440, 140));
        bricks.add(new Brick(430, 130));
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
        tank.update();

        ArrayList<StaticEntity> killedEntities = new ArrayList<>();
        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectWith(brick)) {
                    killedEntities.add(missile);
                    killedEntities.add(brick);
                }
            }
        }

        for (StaticEntity killedEntity : killedEntities) {
            if (killedEntity instanceof Brick) {
                bricks.remove(killedEntity);
            }
            if (killedEntity instanceof Missile) {
                missiles.remove(killedEntity);
            }
        }
        CollidableRepository.getInstance().unRegisterEntities(killedEntities);
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
        for (Missile missile : missiles) {
            missile.draw(canvas);
        }
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }
}
