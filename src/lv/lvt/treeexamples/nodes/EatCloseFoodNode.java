package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;

import java.util.ArrayList;
import java.util.List;

public class EatCloseFoodNode extends BehaviorNode {
    private Player player;
    private List<Food> food;
    public EatCloseFoodNode(Player player, List<Food> food) {
        this.player = player;
        this.food = food;
    }

    public boolean execute() {
        for (Food value : food) {
            if (player.getPosition().between(value.getPos()) < 30) {
                food.remove(value);
                return true;
            }
        }
        return false;
    }

}

