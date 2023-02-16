import utils.Position;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        Player player = new Player(50, 50,frame.getWidth()/2- 50/2, frame.getHeight()/2- 50/2, 0);
        GPanel panel = new GPanel(player);
        frame.add(panel);


        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    player.setTargetPos(new Position(e.getX(), e.getY()));
                    player.setGoal(Goals.MOVE);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right click");
                    //TODO Spawn target
                }
            }
        });


        Timer timer = new Timer(30, e -> {
            player.tick();
            panel.repaint();
        });
        timer.start();
    }
}
//TODO LIST
// - Impliment targets
// - Impliment eating
// - Impliment Tree AI