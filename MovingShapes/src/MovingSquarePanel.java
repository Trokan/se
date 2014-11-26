import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class MovingSquarePanel extends JPanel {
	private Square square;
	private Triangle triangle;
	private Circle circle;

    public MovingSquarePanel () {
    	square = new Square(200, 200, Color.BLUE);
        triangle = new Triangle(100, 100, Color.RED);
        circle = new Circle(100, 300, Color.GREEN);
        
        MouseHandler mouseAdapter = new MouseHandler();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        square.draw(g);
       	triangle.draw(g);
       	circle.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    private class MouseHandler extends MouseAdapter {
         @Override
        public void mousePressed(MouseEvent e) {
        		square.onMousePressed(e);
        		triangle.onMousePressed(e);
        		circle.onMousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        	square.onMouseReleased(e);
        	triangle.onMouseReleased(e);
        	circle.onMouseReleased(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        	square.onMouseDragged(e);
        	triangle.onMouseDragged(e);
        	circle.onMouseDragged(e);
           	repaint();
        }
    }
}
