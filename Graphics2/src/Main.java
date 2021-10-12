import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        new DrawPicture().setVisible(true);
    }

    public static int[]toInt(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int[] coordinate = new int[2];
        int start = 0;
        int i = 0;
        while (matcher.find(start)) {
            String value = text.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            coordinate[i] = result;
            start = matcher.end();
            i++;
        }
        return coordinate;
    }

    public static int toIntOneCount(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int[] coordinate = new int[2];
        int start = 0;
        int i = 0;
        while (matcher.find(start)) {
            String value = text.substring(matcher.start(), matcher.end());
            int result = Integer.parseInt(value);
            coordinate[i] = result;
            start = matcher.end();
            i++;
        }
        return coordinate[0];
    }
}
