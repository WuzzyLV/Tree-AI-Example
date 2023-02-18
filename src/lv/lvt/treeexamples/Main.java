package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.nodes.*;
import lv.lvt.treeexamples.utils.TriangleUtils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        Player player = new Player(50, 50,frame.getWidth()/2- 50/2, frame.getHeight()/2- 50/2, 0);
        List<Food> food = new ArrayList<>();

        GPanel panel = new GPanel(player, food);
        frame.add(panel);
        frame.setVisible(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    player.setTargetPos(e.getX()-player.getWidth()/2, e.getY()-player.getHeight()/2);
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    food.clear();
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    food.add(new Food(e.getX()-16, e.getY()-16));
                }
            }
        });

        AI ai = new AI(player, food, panel);

        Timer timer = new Timer(30, e -> {
            System.out.println(player.getGoal());
            ai.tick();
            panel.repaint();
        });
        timer.start();
    }
}
//TODO LIST
// - Implement targets
// - Implement eating
// - Implement Tree AI
