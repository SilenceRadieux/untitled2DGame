package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class OBJ_Heart extends SuperObject {

    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {
        this.gp = gp;

        name = "Heart";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_full.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_half.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/heart_blank.png")));
            image = uTool.scaleImage(image, GamePanel.tileSize, GamePanel.tileSize);
            image2 = uTool.scaleImage(image2, GamePanel.tileSize, GamePanel.tileSize);
            image3 = uTool.scaleImage(image3, GamePanel.tileSize, GamePanel.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
