import java.awt.*;

public abstract class Game {


    private boolean playing = true;
    private GameTime gameTime;
    private RenderingEngine renderingEngine;
    protected abstract void intialize();
    protected abstract void update();
    protected abstract void draw(Canvas canvas);

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start() {
        intialize();
        run();
    }

    private void run() {
        renderingEngine.start();
        gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();
           gameTime.sleep();
        }
    }
}
