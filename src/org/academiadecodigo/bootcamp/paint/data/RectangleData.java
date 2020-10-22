package org.academiadecodigo.bootcamp.paint.data;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RectangleData {

    private boolean filled;
    private Rectangle rectangle;
    private boolean painted;

    public RectangleData(Rectangle rectangle) {

        this.rectangle = rectangle;

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public void setColor(Color color) {
        rectangle.setColor(color);

        if (filled) {

            rectangle.fill();

        } else {

        }

    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isPainted() {
        return painted;
    }

    @Override
    public String toString() {
        return "RectangleData{" +
                "rectangle=" + rectangle +
                "painted=" + painted +
                '}';
    }
}

