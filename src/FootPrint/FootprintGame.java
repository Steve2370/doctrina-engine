package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;

public class FootprintGame extends Game {
    private GamePad gamepad;
    private Player player;

    @Override
    protected void intialize() {
        gamepad = new GamePad();
        player = new Player(gamepad);
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        canvas.drawRectangle(0, 0, 800,600, Color.BLUE);
        player.draw(canvas);
    }
}
