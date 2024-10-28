package Doctrina;

import java.awt.event.KeyListener;

public abstract class Game {


    private boolean playing = true;
    private final RenderingEngine renderingEngine;
    protected abstract void intialize();
    protected abstract void update();
    protected abstract void draw(Canvas canvas);

    protected Game() {
        renderingEngine = RenderingEngine.getInstance();
    }

    public final void start() {
        intialize();
        run();
    }

    public final void stop() {
        playing = false;
    }

    private void run() {
        renderingEngine.start();
        GameTime gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawOnScreen();
           gameTime.synchronize();
        }
        renderingEngine.stop();
    }
}
