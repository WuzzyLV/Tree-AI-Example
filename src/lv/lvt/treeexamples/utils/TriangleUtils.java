package lv.lvt.treeexamples.utils;

public class TriangleUtils {
    public static int[][] generateAcuteTriangleWithRotation(double centerX, double centerY, double angleDegrees) {
        //length of the triangle sides
        double s=150;

        // Convert the angle from degrees to radians
        double angle = Math.toRadians(angleDegrees);

        // Calculate the coordinates of the other two vertices of the triangle
        double x2 = centerX - s/2;
        double y2 = centerY - s/2;
        double x3 = centerX + s/2;
        double y3 = centerY - s/2;

        // Apply the rotation to each vertex of the triangle
        double xp2 = (x2 - centerX) * Math.cos(angle) - (y2 - centerY) * Math.sin(angle) + centerX;
        double yp2 = (x2 - centerX) * Math.sin(angle) + (y2 - centerY) * Math.cos(angle) + centerY;
        double xp3 = (x3 - centerX) * Math.cos(angle) - (y3 - centerY) * Math.sin(angle) + centerX;
        double yp3 = (x3 - centerX) * Math.sin(angle) + (y3 - centerY) * Math.cos(angle) + centerY;

        // Store the coordinates in a 2D array and return it
        int[][] coords = new int[3][2];
        coords[0][0] = (int) centerX;
        coords[0][1] = (int) centerY;
        coords[1][0] = (int) xp2;
        coords[1][1] = (int) yp2;
        coords[2][0] = (int) xp3;
        coords[2][1] = (int) yp3;
        return coords;
    }

    public static boolean isInTriangle(int[][] trianglePoints, Position pos) {
        int x1 = trianglePoints[0][0];
        int y1 = trianglePoints[0][1];
        int x2 = trianglePoints[1][0];
        int y2 = trianglePoints[1][1];
        int x3 = trianglePoints[2][0];
        int y3 = trianglePoints[2][1];
        int a = (x1 - pos.getX()) * (y2 - y1) - (x2 - x1) * (y1 - pos.getY());
        int b = (x2 - pos.getX()) * (y3 - y2) - (x3 - x2) * (y2 - pos.getY());
        int c = (x3 - pos.getX()) * (y1 - y3) - (x1 - x3) * (y3 - pos.getY());
        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0);
    }
}
