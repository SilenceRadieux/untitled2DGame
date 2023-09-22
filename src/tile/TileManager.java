package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[GamePanel.maxWorldCol][GamePanel.maxWorldRow];
        getTileImages();
        loadMap("/maps/worldmap.txt");
    }

    public void getTileImages() {

        setup(0, "grass00", false);
        setup(1, "wall", true);
        setup(2, "water01", true);
        setup(3, "earth", false);
        setup(4, "tree", true);
        setup(5, "road00", false);

    }

    public void setup(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream
                    ("/tiles/" + imageName + ".png"))));
            tile[index].image = uTool.scaleImage(tile[index].image, GamePanel.tileSize, GamePanel.tileSize);
            tile[index].collision = collision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < GamePanel.maxWorldCol && row < GamePanel.maxWorldRow) {
                String line = br.readLine();
                while (col < GamePanel.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == GamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < GamePanel.maxWorldCol && worldRow < GamePanel.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * GamePanel.tileSize;
            int worldY = worldRow * GamePanel.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + GamePanel.tileSize > gp.player.worldX - gp.player.screenX
                    && worldX - GamePanel.tileSize < gp.player.worldX + gp.player.screenX
                    && worldY + GamePanel.tileSize > gp.player.worldY - gp.player.screenY
                    && worldY - GamePanel.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;

            if (worldCol == GamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
