package utils;

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
        double xp1 = centerX;
        double yp1 = centerY;
        double xp2 = (x2 - centerX) * Math.cos(angle) - (y2 - centerY) * Math.sin(angle) + centerX;
        double yp2 = (x2 - centerX) * Math.sin(angle) + (y2 - centerY) * Math.cos(angle) + centerY;
        double xp3 = (x3 - centerX) * Math.cos(angle) - (y3 - centerY) * Math.sin(angle) + centerX;
        double yp3 = (x3 - centerX) * Math.sin(angle) + (y3 - centerY) * Math.cos(angle) + centerY;

        // Store the coordinates in a 2D array and return it
        int[][] coords = new int[3][2];
        coords[0][0] = (int) xp1;
        coords[0][1] = (int) yp1;
        coords[1][0] = (int) xp2;
        coords[1][1] = (int) yp2;
        coords[2][0] = (int) xp3;
        coords[2][1] = (int) yp3;
        return coords;
    }
}
