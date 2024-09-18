package Doctrina;

import java.awt.event.KeyListener;

public abstract class Game {


    private boolean playing = true;
    private GameTime gameTime;
    private RenderingEngine renderingEngine;
    protected abstract void intialize();
    protected abstract void update();
    protected abstract void draw(Canvas canvas);

    protected Game() {
        renderingEngine = new RenderingEngine();
    }

    public void addKeyListener(KeyListener keyListener) {
        renderingEngine.addKeyListener(keyListener);
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
        gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();
           gameTime.synchronize();
        }
        renderingEngine.stop();
    }
}
