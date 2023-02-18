package lv.lvt.treeexamples.nodes;

import lv.lvt.treeexamples.entities.Player;

public class TickNode extends BehaviorNode {
    private Player player;
    public TickNode(Player player) {
        this.player = player;
    }

    public boolean execute() {
        System.out.println("Tick");
        player.tick();
        return true;
    }
}
