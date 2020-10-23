package org.academiadecodigo.bootcamp.paint.movement;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseMovement implements MouseHandler {

    private Mouse mouse = new Mouse(this);

    private double x;

    private double y;

    private boolean click;

    public MouseMovement() {
        this.mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public double mouseX() {
        return this.x;
    }

    public double mouseY() {
        return this.y;
    }

    public boolean getClick() {
        return this.click;
    }

    public void resetPos() {
        this.x = 0.0D;
        this.y = 0.0D;
    }

    public void setClick(boolean paramBoolean) {
        this.click = paramBoolean;
    }

    public void mouseClicked(MouseEvent paramMouseEvent) {
        this.x = paramMouseEvent.getX();
        this.y = paramMouseEvent.getY();
        this.click = true;
    }

    public void mouseMoved(MouseEvent paramMouseEvent) {}
}
