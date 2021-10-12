import java.awt.*;

public class DrawPolygon {
    public void paint(Graphics g, int[][] matrix, NullPoint nullPoint) {
        g.setColor(Color.green);
        int[] x = new int[matrix.length];
        int[] y = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            x[i] = matrix[i][0] + nullPoint.coordinateNullPoint[0];
            y[i] = matrix[i][1] + nullPoint.coordinateNullPoint[1];
        }
        g.drawPolygon(x, y, matrix.length);
    }
}
