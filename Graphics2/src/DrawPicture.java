import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DrawPicture extends JFrame {

    private JPanel myJPanel;
    private JButton drawButton;
    private JButton clearButton;
    private JButton movingButton;
    private JTextPane movingText;
    private JButton scalingButton;
    private JButton compressionButton;
    private JButton reflectionButton;
    private JTextPane scalingText;
    private JButton centerPolygonButton;
    private JTextPane centerPolygonText;
    private JTextPane compressionText;
    private JButton rotationButton;
    private JTextPane rotationText;


    public DrawPicture() {
        add(myJPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 660);
        this.setTitle("drawPicture");
        NullPoint nullPoint = new NullPoint(new int[]{550, 330});
        NullPoint nullPointPolygon = new NullPoint(new int[]{550, 330});
        NullPoint coordinate = new NullPoint(new int[]{0, 0});
        int[][] matrix = {
                {50,-50},
                {50,50},
                {-50,50},
                {-50,-50}
        };

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                CoordinateAxe coordinateAxe = new CoordinateAxe();
                coordinateAxe.paint(getGraphics(), nullPoint);
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        movingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] newCoordinate = Main.toInt(movingText.getText());
                matrix[0][0] = matrix[0][0] + newCoordinate[0];
                matrix[0][1] = matrix[0][1] - newCoordinate[1];
                matrix[1][0] = matrix[1][0] + newCoordinate[0];
                matrix[1][1] = matrix[1][1] - newCoordinate[1];
                matrix[2][0] = matrix[2][0] + newCoordinate[0];
                matrix[2][1] = matrix[2][1] - newCoordinate[1];
                matrix[3][0] = matrix[3][0] + newCoordinate[0];
                matrix[3][1] = matrix[3][1] - newCoordinate[1];
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
        scalingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amendment = Main.toIntOneCount(scalingText.getText());

                matrix[0][0] = matrix[0][0] + amendment;
                matrix[0][1] = matrix[0][1] - amendment;
                matrix[1][0] = matrix[1][0] + amendment;
                matrix[1][1] = matrix[1][1] + amendment;
                matrix[2][0] = matrix[2][0] - amendment;
                matrix[2][1] = matrix[2][1] + amendment;
                matrix[3][0] = matrix[3][0] - amendment;
                matrix[3][1] = matrix[3][1] - amendment;
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
        centerPolygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] newCoordinate = Main.toInt(centerPolygonText.getText());
                newCoordinate[0] = newCoordinate[0] + nullPointPolygon.getCoordinateNullPoint()[0];
                newCoordinate[1] = -newCoordinate[1] + nullPointPolygon.getCoordinateNullPoint()[1];
                nullPointPolygon.setCoordinateNullPoint(newCoordinate);
            }
        });
        reflectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] newCoordinate = nullPointPolygon.getCoordinateNullPoint();
                newCoordinate[0] = newCoordinate[0] * -1;
                newCoordinate[1] = newCoordinate[1] * -1;
                nullPointPolygon.setCoordinateNullPoint(newCoordinate);
            }
        });
        compressionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] amendment = Main.toInt(compressionText.getText());

                matrix[0][0] = matrix[0][0] + amendment[0];
                matrix[0][1] = matrix[0][1] - amendment[1];
                matrix[1][0] = matrix[1][0] + amendment[0];
                matrix[1][1] = matrix[1][1] + amendment[1];
                matrix[2][0] = matrix[2][0] - amendment[0];
                matrix[2][1] = matrix[2][1] + amendment[1];
                matrix[3][0] = matrix[3][0] - amendment[0];
                matrix[3][1] = matrix[3][1] - amendment[1];
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
        rotationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radian = Main.toIntOneCount(rotationText.getText());
                double[][] trigonometricMatrix = new double[2][2];
                trigonometricMatrix[0][0] = Math.cos(Math.toRadians(radian));
                trigonometricMatrix[0][1] = Math.sin(Math.toRadians(radian));
                trigonometricMatrix[1][0] = -Math.sin(Math.toRadians(radian));
                trigonometricMatrix[1][1] = Math.cos(Math.toRadians(radian));
                matrix[0][0] = (int)(trigonometricMatrix[0][0]*matrix[0][0] + trigonometricMatrix[1][0]*matrix[0][1]);
                matrix[0][1] = (int)(trigonometricMatrix[0][1]*matrix[0][0] + trigonometricMatrix[1][1]*matrix[0][1]);
                matrix[1][0] = (int)(trigonometricMatrix[0][0]*matrix[1][0] + trigonometricMatrix[1][0]*matrix[1][1]);
                matrix[1][1] = (int)(trigonometricMatrix[0][1]*matrix[1][0] + trigonometricMatrix[1][1]*matrix[1][1]);
                matrix[2][0] = (int)(trigonometricMatrix[0][0]*matrix[2][0] + trigonometricMatrix[1][0]*matrix[2][1]);
                matrix[2][1] = (int)(trigonometricMatrix[0][1]*matrix[2][0] + trigonometricMatrix[1][1]*matrix[2][1]);
                matrix[3][0] = (int)(trigonometricMatrix[0][0]*matrix[3][0] + trigonometricMatrix[1][0]*matrix[3][1]);
                matrix[3][1] = (int)(trigonometricMatrix[0][1]*matrix[3][0] + trigonometricMatrix[1][1]*matrix[3][1]);
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
    }



}

