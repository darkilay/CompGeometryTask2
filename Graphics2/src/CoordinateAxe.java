import java.awt.*;

public class CoordinateAxe {
    public void paint(Graphics g, NullPoint nullPoint) {
        g.setColor(Color.red);
        g.drawLine(0, nullPoint.coordinateNullPoint[1], 1100, nullPoint.coordinateNullPoint[1]);
        g.drawLine(nullPoint.coordinateNullPoint[0], 0, nullPoint.coordinateNullPoint[0], 660);
    }
}
