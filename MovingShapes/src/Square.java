import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Square {
	private final static int rectWidth = 30;
	private final static int rectHeight = 30;
	private Rectangle boundingRect;
    private Color color;   
    private Point mouseXYOffset;
    private boolean isDragging;

    public Square (int centerX, int centerY, Color color) {
    	boundingRect = new Rectangle(centerX - (rectWidth/2), centerY - (rectHeight/2), rectWidth, rectHeight);
    	mouseXYOffset = new Point();
    	this.color = color;
     }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(boundingRect.x, boundingRect.y, boundingRect.width, boundingRect.height); 
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
