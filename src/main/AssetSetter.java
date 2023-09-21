package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 23 * GamePanel.tileSize;
        gp.obj[0].worldY = 7 * GamePanel.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 23 * GamePanel.tileSize;
        gp.obj[1].worldY = 40 * GamePanel.tileSize;

        gp.obj[2] = new OBJ_Key();
        gp.obj[2].worldX = 38 * GamePanel.tileSize;
        gp.obj[2].worldY = 8 * GamePanel.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 10 * GamePanel.tileSize;
        gp.obj[3].worldY = 11 * GamePanel.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 8 * GamePanel.tileSize;
        gp.obj[4].worldY = 28 * GamePanel.tileSize;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 12 * GamePanel.tileSize;
        gp.obj[5].worldY = 22 * GamePanel.tileSize;

        gp.obj[6] = new OBJ_Chest();
        gp.obj[6].worldX = 10 * GamePanel.tileSize;
        gp.obj[6].worldY = 7 * GamePanel.tileSize;
    }

}
