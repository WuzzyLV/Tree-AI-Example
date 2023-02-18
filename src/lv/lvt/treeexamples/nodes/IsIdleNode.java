package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.Goals;
import lv.lvt.treeexamples.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class IsIdleNode extends BehaviorNode {
    private List<BehaviorNode> children = new ArrayList<>();

    private Player player;
    public IsIdleNode(Player player){
        this.player = player;
    }
    public void addChild(BehaviorNode child) {
        children.add(child);
    }

    public boolean execute() {
        if (player.getGoal()==Goals.IDLE){
            for (BehaviorNode child : children) {
                if (child.execute()) {
                    return true;
                }
            }
        }
        return false;
    }
}

