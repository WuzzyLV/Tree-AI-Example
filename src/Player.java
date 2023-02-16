import utils.Position;
import utils.TriangleUtils;

public class Player {
    private int height;
    private int width;
    private Position currentPos;
    private Position targetPos;
    private int rotation;
    private Goals goal=Goals.IDLE;
    int[][] viewPoints;

    public Player(int height, int width,int posX, int posY, int rotation) {
        System.out.println(posX + " " + posY);
        this.height = height;
        this.width = width;
        this.currentPos = new Position(posX, posY);
        this.rotation = rotation;
        calculateView();
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public Position getCurrentPos() {
        return currentPos;
    }
    public int getRotation() {
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public void setTargetPos(Position targetPos) {
        this.targetPos = targetPos;
    }
    public void setGoal(Goals goal) {
        this.goal = goal;
    }
    public Goals getGoal() {
        return goal;
    }

    public int[][] getViewPoints() {
        return viewPoints;
    }
    void calculateView(){
        viewPoints = TriangleUtils.generateAcuteTriangleWithRotation(
                currentPos.getX()+width/2,
                currentPos.getY()+height/2,
                rotation
        );
    }

    void moveStep() {
        rotation =0;
        if (currentPos.getX() == targetPos.getX() && currentPos.getY() == targetPos.getY()) {
            goal = Goals.IDLE;
            return;
        }
        if (currentPos.getX() < targetPos.getX()) {
            currentPos.setX(currentPos.getX() + 1);
            rotation= 90;
        } else if (currentPos.getX() > targetPos.getX()) {
            currentPos.setX(currentPos.getX() - 1);
            rotation= 270;
        }
        if (currentPos.getY() < targetPos.getY()) {
            currentPos.setY(currentPos.getY() + 1);
            if (rotation == 90) {
                rotation = 135;
            } else if (rotation == 270) {
                rotation = 225;
            } else {
                rotation = 180;
            }
        } else if (currentPos.getY() > targetPos.getY()) {
            currentPos.setY(currentPos.getY() - 1);
            if (rotation == 90) {
                rotation = 45;
            } else if (rotation == 270) {
                rotation = 315;
            } else {
                rotation = 0;
            }
        }
        calculateView();
    }
    void eat() {
        setGoal(Goals.EATING);
    }
    void idle() {
        setGoal(Goals.IDLE);
    }

    public void tick() {
        switch (goal) {
            case MOVE:
                moveStep();
                break;
            case EATING:
                eat();
                break;
            case IDLE:
                idle();
                break;
        }
    }

}
