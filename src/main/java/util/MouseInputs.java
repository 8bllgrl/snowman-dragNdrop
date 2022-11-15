package util;

import main.GamePainter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseMotionListener, MouseListener {

    private GamePainter gamePainter;

    public MouseInputs(GamePainter gamePainter){
        this.gamePainter = gamePainter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gamePainter.getGame().getPlayx().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gamePainter.getGame().getPlayx().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        gamePainter.getGame().getPlayx().mouseMoved(e);


    }

}
