package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.Position;

import javax.swing.*;

public class GoToFoodNode extends BehaviorNode {
    private Player player;
    public GoToFoodNode(Player player) {
        this.player = player;
    }

    public boolean execute(){
        return false;
    }

    public boolean execute(Position targetPos) {
        player.setTargetPos(targetPos.getX(), targetPos.getY());
        player.tick();
        return true;
    }
}


