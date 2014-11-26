import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingSquareFrame extends JFrame {
    private MovingSquarePanel panel;

    public MovingSquareFrame () {
        super("MouseDragged Demo");

        panel = new MovingSquarePanel();
        add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main (String[] arg) {
        JFrame frame = new MovingSquareFrame();
    }
}