package lv.lvt.treeexamples.entities;

import lv.lvt.treeexamples.utils.Position;

public class Food {
    private Position position;

    private int width=16;
    private int height=16;

    public Food(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPos() {
        return position;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
