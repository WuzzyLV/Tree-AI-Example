package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GPanel extends JPanel {
    private final Player player;
    private final List<Food> food;

    private final int width;
    private final int height;
    private final Position playerPos;
    private Position targetPos;

    GPanel(Player player, List<Food> food) {
        this.player = player;
        this.food = food;
        this.width = player.getWidth();
        this.height = player.getHeight();
        this.playerPos = player.getCurrentPos();
        this.targetPos = player.getTargetPos();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw target location
        if (targetPos.getY() != 0 && targetPos.getX() != 0) {
            g.setColor(new Color(82, 141, 229));
            g.fillRoundRect(targetPos.getX()+16, targetPos.getY()+16, 16, 16, 45, 45);
        }
        //draw food
        if (food != null) {
            g.setColor(new Color(112, 36, 234));
            for (Food f : food) {
                g.fillRoundRect(f.getPos().getX()-f.getWidth()/2, f.getPos().getY()-f.getHeight()/2,
                        f.getWidth(), f.getHeight(), 45, 45);
            }
        }
        //draws the view cone line by line
        g.setColor(new Color(53, 102, 24));
        int[][] points = player.getViewPoints();
        for (int i = 0; i < points.length; i++) {
            if (i == points.length - 1) {
                g.drawLine(points[i][0], points[i][1], points[0][0], points[0][1]);
            } else {
                g.drawLine(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
            }
        }
        //draw player
        g.fillRoundRect(playerPos.getX(), playerPos.getY(), width, height, 80, 80);
    }
}
