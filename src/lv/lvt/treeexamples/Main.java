package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.ColorUtils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        HashMap<Player, AI> players = new HashMap<>();
        List<Food> food = new ArrayList<>();

        GPanel panel = new GPanel(players, food);
        frame.add(panel);
        frame.setVisible(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Player player = new Player(50, 50,e.getX(), e.getY(), 0, ColorUtils.random());
                    AI ai = new AI(player, food, panel);
                    players.put(player, ai);
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    food.clear();
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    food.add(new Food(e.getX()-24, e.getY()-24));
                }
            }
        });

        Player player = new Player(50, 50,frame.getWidth()/2- 50/2, frame.getHeight()/2- 50/2, 0, ColorUtils.random());
        AI PlayerAI = new AI(player, food, panel);
        players.put(player, PlayerAI);

        AtomicInteger foodCounter = new AtomicInteger();
        Timer timer = new Timer(30, e -> {

            for (AI ai : players.values()) {
                ai.tick();
            }

            if (foodCounter.getAndIncrement() > 100) {
                foodCounter.set(0);
                food.add(new Food(random.nextInt(frame.getWidth()), random.nextInt(frame.getHeight())));
            }

            panel.repaint();
        });
        timer.start();
    }
}
//TODO LIST
// - make the issue of clipping food properly not jank

