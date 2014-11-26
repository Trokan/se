import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Triangle {
	private final static int rectWidth = 30;
	private final static int rectHeight = 30;
	private Rectangle boundingRect;
    private Color color;   
    private Point mouseXYOffset;
    private boolean isDragging;

    public Triangle (int centerX, int centerY, Color color) {
    	boundingRect = new Rectangle(centerX - (rectWidth/2), centerY - (rectHeight/2), rectWidth, rectHeight);
    	mouseXYOffset = new Point();
    	this.color = color;
     }

    public void draw(Graphics g) {
        g.setColor(color);
        int [] xPoints = new int[4];
        int [] yPoints = new int[4];
        
        xPoints[0] = xPoints[3] = boundingRect.x;
        yPoints[0] = yPoints[3] = boundingRect.y + boundingRect.height;
        xPoints[1] = boundingRect.x + boundingRect.width;
        yPoints[1] = boundingRect.y + boundingRect.height; 
        xPoints[2] = boundingRect.x + boundingRect.width / 2;
        yPoints[2] = boundingRect.y;
        g.fillPolygon(xPoints, yPoints, 4);
    }

    public void onMousePressed(MouseEvent e) {
    	if (boundingRect.contains(e.getX(), e.getY())) {
            isDragging = true;
            mouseXYOffset.setLocation(e.getX() - boundingRect.x, e.getY() - boundingRect.y);
        }
    }

    public void onMouseReleased(MouseEvent e) {
        isDragging = false;
    }

    public void onMouseDragged(MouseEvent e) {
        if (isDragging) {
        	boundingRect.setLocation(e.getX() - mouseXYOffset.x, e.getY() - mouseXYOffset.y);
        }
    }

}
