package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.Position;

import javax.swing.*;

public class FindNewTargetLocationNode extends BehaviorNode {
    private Player player;
    private JPanel panel;
    public FindNewTargetLocationNode(Player player, JPanel panel) {
        this.player = player;
        this.panel = panel;
    }

    public boolean execute() {
        int y;
        int x;
        Position pos = player.getCurrentPos();
        do {
            x = (int) (Math.random() * 250)-125 + pos.getX();
            y = (int) (Math.random() * 250)-125 + pos.getY();
        } while (x < 0 || x > panel.getWidth()- player.getWidth()
                || y < 0 || y > panel.getHeight()- player.getHeight());
        player.setTargetPos(x, y);
        return true;
    }
}


