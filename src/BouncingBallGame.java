import java.awt.*;

public final class BouncingBallGame extends Game {

    private int score;
    private Ball ball;

    @Override
    protected void intialize() {
        ball = new Ball(25);
    }

    @Override
    protected void update() {
        ball.upate();
        if (ball.hasTouche()) {
            score += 10;
        }
    }

    @Override
    protected void draw(Canvas canvas) {
       ball.draw(canvas);
       canvas.drawString("Score: " + score, 10, 20, Color.WHITE);
    }
}