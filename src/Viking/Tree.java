package Viking;

import Doctrina.Canvas;
import Doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Tree extends StaticEntity {
    private static final String SPRITE_PATH = "images/tree.png";

    private Image image;

    public Tree() {
        load();
        teleprot(300, 300);
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
    }
}
