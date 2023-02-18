package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.nodes.FindNewTargetLocationNode;
import lv.lvt.treeexamples.nodes.IsIdleNode;
import lv.lvt.treeexamples.nodes.SelectorNode;

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
        frame.setVisible(true);

        Player player = new Player(50, 50,frame.getWidth()/2- 50/2, frame.getHeight()/2- 50/2, 0);
        List<Food> food = new ArrayList<>();
        GPanel panel = new GPanel(player, food);
        frame.add(panel);


        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    player.setTargetPos(e.getX(), e.getY());
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    food.clear();
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    food.add(new Food(e.getX(), e.getY()));
                }
            }
        });

        SelectorNode root = new SelectorNode();
        IsIdleNode isIdleNode = new IsIdleNode(player);
        root.addChild(isIdleNode);
        FindNewTargetLocationNode findTrgtLocNode = new FindNewTargetLocationNode(player, panel);
        isIdleNode.addChild(findTrgtLocNode);


        Timer timer = new Timer(30, e -> {
            root.execute();
            player.tick();

/*            for (int i = 0; i < food.size(); i++) {
                if (TriangleUtils.isInTriangle(player.getViewPoints(), food.get(0).getPos())) {
                    food.remove(i);
                    i--;
                }
            }*/

            panel.repaint();
        });
        timer.start();
    }
}
//TODO LIST
// - Implement targets
// - Implement eating
// - Implement Tree AI