package lv.lvt.treeexamples.utils;

public class PositionUtils {
    public static Position randomInBounds(int width, int height) {
        return new Position((int) (Math.random() * width-50)+25, (int) (Math.random() * height-50)+25);
    }
}
