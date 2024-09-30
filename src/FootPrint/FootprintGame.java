package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootprintGame extends Game {
    private GamePad gamepad;
    private Player player;
    private ArrayList<Footprint> footprints;

    @Override
    protected void intialize() {
        gamepad = new GamePad();
        player = new Player(gamepad);
        footprints = new ArrayList<>();
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (gamepad.isMoving()) {
            footprints.add(player.layFootprint());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0, 0, 800,600, Color.BLUE);
        for (Footprint footprint : footprints) {
            footprint.draw(canvas);
        }
        player.draw(canvas);
    }
}
