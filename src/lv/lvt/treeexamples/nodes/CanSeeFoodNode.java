package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.Goals;
import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.utils.TriangleUtils;

import java.util.ArrayList;
import java.util.List;

public class CanSeeFoodNode extends BehaviorNode {
    private List<BehaviorNode> children = new ArrayList<>();

    private Player player;
    private List<Food> food;
    public CanSeeFoodNode(Player player, List<Food> food){
        this.player = player;
        this.food = food;
    }
    public void addChild(BehaviorNode child) {
        children.add(child);
    }

    public boolean execute() {
        for (Food f : food) {
            if (!TriangleUtils.isInTriangle(player.getViewPoints(), f.getPos())) {
                continue;
            }

            for (BehaviorNode child : children) {
                if (child instanceof GoToFoodNode ) {
                	GoToFoodNode goToFoodNode=(GoToFoodNode) child;
                    if (goToFoodNode.execute(f.getPos())) {
                        return true;
                    }
                }
                if (child.execute()) {
                    return true;
                }
            }

        }
        return false;
    }
}

