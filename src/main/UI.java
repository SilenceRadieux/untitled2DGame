package main;

import object.OBJ_Heart;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;


public class UI {

    public boolean messageOn = false;
    public String message = "";
    public boolean gameFinished = false;
    public int commandNum = 0;
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage heart_full, heart_half, heart_blank;
    int messageCounter = 0;
    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
    }

    public void drawPlayerLife() {
        int x = GamePanel.tileSize / 2;
        int y = GamePanel.tileSize / 2;
        int i = 0;

        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += GamePanel.tileSize;
        }

        x = GamePanel.tileSize / 2;
        y = GamePanel.tileSize / 2;
        i = 0;

        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += GamePanel.tileSize;
        }
    }

    public void drawTitleScreen() {
        g2.setColor(new Color(70, 70, 70));
        g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
        String text = "LAST DEV ON EARTH";
        int x = getXforCenteredText(text);
        int y = GamePanel.tileSize * 3;

        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);

        g2.setColor(Color.red);
        g2.drawString(text, x, y);

        x = GamePanel.screenWidth / 2 - (GamePanel.tileSize * 2) / 2;
        y += GamePanel.tileSize * 2;
        g2.drawImage(gp.player.down1, x, y, GamePanel.tileSize * 2, GamePanel.tileSize * 2, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += (int) (GamePanel.tileSize * 3.5);
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - GamePanel.tileSize, y);
        }

        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y += GamePanel.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - GamePanel.tileSize, y);
        }

        text = "QUIT GAME";
        x = getXforCenteredText(text);
        y += GamePanel.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawString(">", x - GamePanel.tileSize, y);
        }
    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = GamePanel.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = GamePanel.screenWidth / 2 - length / 2;
        return x;
    }
}

