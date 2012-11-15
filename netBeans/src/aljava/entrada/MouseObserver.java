package aljava.entrada;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Classe responsável por gerenciar questões do mouse.
 */
class MouseObserver implements MouseMotionListener, MouseListener
{
    private Point mousePos;
    private boolean leftButtonPressed;
    private boolean middleButtonPressed;
    private boolean rightButtonPressed;

    public MouseObserver()
    {
        mousePos = new Point(0, 0);
        leftButtonPressed = false;
        middleButtonPressed = false;
        rightButtonPressed = false;
    }

    public Point getMousePos(){
        return mousePos;
    }

    public boolean isLeftButtonPressed() {
        return leftButtonPressed;
    }

    public boolean isMiddleButtonPressed(){
        return middleButtonPressed;
    }

    public boolean isRightButtonPressed(){
        return rightButtonPressed;
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e)
    {
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                leftButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0);
                break;
            case MouseEvent.BUTTON2:
                middleButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON2_DOWN_MASK) != 0);
                break;
            case MouseEvent.BUTTON3:
                rightButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0);
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                leftButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0);
                break;
            case MouseEvent.BUTTON2:
                middleButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON2_DOWN_MASK) != 0);
                break;
            case MouseEvent.BUTTON3:
                rightButtonPressed = ((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0);
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e){
        mouseClicked(e);
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e){
        mousePos = e.getPoint();
    }

}