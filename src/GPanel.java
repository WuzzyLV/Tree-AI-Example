import utils.Position;
import utils.TriangleUtils;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {
    private Player player;

    private int width;
    private int height;
    private Position playerPos;

    GPanel(Player player) {
        this.player = player;
        this.width = player.getWidth();
        this.height = player.getHeight();
        this.playerPos = player.getCurrentPos();
    }

    public Position getPlayerPos() {
        return playerPos;
    }
    public void setPlayerPos(Position playerPos) {
        this.playerPos = playerPos;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draws the view cone line by line
        int[][] points = player.getViewPoints();
        for (int i = 0; i < points.length; i++) {
            if (i == points.length - 1) {
                g.drawLine(points[i][0], points[i][1], points[0][0], points[0][1]);
            } else {
                g.drawLine(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
            }
        }
        g.fillRoundRect(playerPos.getX(), playerPos.getY(), width, height, 80, 80);
    }
}
