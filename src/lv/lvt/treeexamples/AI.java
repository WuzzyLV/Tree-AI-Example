package lv.lvt.treeexamples;

import lv.lvt.treeexamples.entities.Food;
import lv.lvt.treeexamples.entities.Player;
import lv.lvt.treeexamples.nodes.*;

import javax.swing.*;
import java.util.List;

public class AI {
    SelectorNode root;

    AI(Player player, List<Food> food, JPanel panel) {
        root = new SelectorNode();
        //add eat close node
        EatCloseFoodNode eatCloseFoodNode = new EatCloseFoodNode(player, food);
        root.addChild(eatCloseFoodNode);
        //add can see food node
        CanSeeFoodNode canSeeFoodNode = new CanSeeFoodNode(player, food);
        root.addChild(canSeeFoodNode);
        //add go to food node
        GoToFoodNode goToFoodNode = new GoToFoodNode(player);
        canSeeFoodNode.addChild(goToFoodNode);
        //add is idle node
        IsIdleNode isIdleNode = new IsIdleNode(player);
        root.addChild(isIdleNode);
        //add find a new target loc
        FindNewTargetLocationNode findTrgtLocNode = new FindNewTargetLocationNode(player, panel);
        isIdleNode.addChild(findTrgtLocNode);
        TickNode tickNode = new TickNode(player);
        root.addChild(tickNode);
    }
    public void tick() {
        root.execute();
    }
}
