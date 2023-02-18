```java
public abstract class BehaviorNode {
  public abstract boolean execute();
}

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

public class SequenceNode extends BehaviorNode {
  private List<BehaviorNode> children = new ArrayList<>();

  public void addChild(BehaviorNode child) {
    children.add(child);
  }

  public boolean execute() {
    for (BehaviorNode child : children) {
      if (!child.execute()) {
        return false;
      }
    }
    return true;
  }
}

public class ActionNode extends BehaviorNode {
  private String actionName;

  public ActionNode(String actionName) {
    this.actionName = actionName;
  }

  public boolean execute() {
    // perform the action
    return true;
  }
}

public class ConditionNode extends BehaviorNode {
  private String conditionName;

  public ConditionNode(String conditionName) {
    this.conditionName = conditionName;
  }

  public boolean execute() {
    // check the condition
    return true;
  }
}
```

