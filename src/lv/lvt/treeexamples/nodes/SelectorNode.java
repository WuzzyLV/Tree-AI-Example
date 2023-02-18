package lv.lvt.treeexamples.nodes;

import java.util.ArrayList;
import java.util.List;

public class SelectorNode extends BehaviorNode {
    private List<BehaviorNode> children = new ArrayList<>();

    public void addChild(BehaviorNode child) {
        children.add(child);
    }

    public boolean execute() {
        for (BehaviorNode child : children) {
            if (child.execute()) {
                return true;
            }
        }
        return false;
    }
}
