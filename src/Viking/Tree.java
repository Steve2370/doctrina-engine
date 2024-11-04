package Viking;

import Doctrina.Canvas;
import Doctrina.Game;
import Doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Tree extends StaticEntity {
    private static final String SPRITE_PATH = "images/tree.png";

    private Image image;
    private Blockade blockade;

    public Tree(int x, int y) {
        load();
        teleprot(x, y);
        blockade = new Blockade();
        blockade.setDimension(30, 16);
        blockadeFromBottom();
    }

    public void blockadeFromBottom() {
        blockade.teleprot(x + 16, y + 48);
    }

    public void blockadeFromTop() {
        blockade.teleprot(x + 16, y + 64);
    }

    private void load() {
        try {
            image = ImageIO.read(
                    this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(image, x, y);

        if (GameConfig.isIsDebugEnabled()) {
            blockade.draw(canvas);
        }
    }
}
