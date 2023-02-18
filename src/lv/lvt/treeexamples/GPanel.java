package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.ColorUtils;
import lv.lvt.treeexamples.utils.Position;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

public class GPanel extends JPanel {
    private final HashMap<Player, AI> players;
    private final List<Food> food;

    private ImageIcon foodImage;


    GPanel(HashMap<Player, AI> players, List<Food> food) {
        this.players = players;
        this.food = food;


        super.setBackground(new Color(255, 255, 255, 255));
        {
            try {
                File file= new File("./src/lv/lvt/treeexamples/assets/food.png");
                foodImage = new ImageIcon(file.toURI().toURL());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Player player : players.keySet()) {
            Position targetPos = player.getTargetPos();
            Position playerPos = player.getCurrentPos();
            int width = player.getWidth();
            int height = player.getHeight();
            Color color = player.getColor();
            //draw target location
            if (targetPos.getY() != 0 && targetPos.getX() != 0) {
                g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 100));
                g.fillRoundRect(targetPos.getX()+16, targetPos.getY()+16, 16, 16, 90, 90);
            }
            //draws the view cone line by line
            g.setColor(color);
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

        //draw food
        if (food != null) {
            g.setColor(new Color(77, 56, 222));
            for (Food f : food) {
                g.drawImage(foodImage.getImage(), f.getPos().getX()+f.getWidth()/2, f.getPos().getY()+f.getHeight()/2,
                        f.getWidth(), f.getHeight(), null);
                //g.fillRoundRect(f.getPos().getX()+16, f.getPos().getY()+16, f.getWidth(), f.getHeight(), 45, 45);
            }
        }
    }
}
