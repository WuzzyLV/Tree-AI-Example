package lv.lvt.treeexamples.utils;

import java.awt.*;

public class ColorUtils {
    public static Color random(){
        return new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }
}
