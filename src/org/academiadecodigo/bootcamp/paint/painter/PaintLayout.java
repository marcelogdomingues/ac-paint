package org.academiadecodigo.bootcamp.paint.painter;

import org.academiadecodigo.bootcamp.paint.data.RectangleData;
import org.academiadecodigo.bootcamp.paint.menu.MenuOption;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class PaintLayout {

    private int width;
    private int height;
    private int xMargin;
    private int yMargin;
    private Color backgroundColor;

    private Text title;
    private Text credits;

    private Text[] menuOptions = new Text[MenuOption.values().length];

    private ArrayList<RectangleData> rectangleData = new ArrayList<RectangleData>();

    private int size = 30;
    private int initialX = 40;
    private int initialY = 30;

    private Rectangle mainRectangle;

    public PaintLayout(int width, int height, int xMargin, int yMargin, Color backgroundColor) {

        this.width = width;
        this.height = height;
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.backgroundColor = backgroundColor;

    }

    public void drawBackground() {


        //Draw Column grid -> Column -> 40 Column
        for (int column = 0; column < 40; column++) {

            //Draw Row grid -> Row -> 50 row
            for (int row = 0; row < 50; row++) {

                Rectangle grid = new Rectangle(10 + (size * row), 30 + (size * column), size, size);
                rectangleData.add(new RectangleData(grid));

                RectangleData rectRectangleData = new RectangleData(grid); // Creating a new object
                rectangleData.add(rectRectangleData); // Adding it to the list

                grid.draw();

                System.out.println(rectRectangleData.getRectangle().toString());
            }
        }
    }

    public void drawInitRectangle() {

        //V e V1 -> Rectangle Movement
        mainRectangle = new Rectangle(initialX, initialY, size, size);
        mainRectangle.setColor(Color.BLACK);
        mainRectangle.fill();

    }

    public void drawRectangle(int initialX, int initialY, int size) {

        mainRectangle = new Rectangle(initialX, initialY, size, size);
        mainRectangle.setColor(Color.BLACK);
        mainRectangle.fill();
    }

    public void delete(Rectangle rectangle) {
        rectangle.delete();
    }

    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public ArrayList<RectangleData> getRectangleData() {
        return rectangleData;
    }

    public Rectangle getMainRectangle() {
        return mainRectangle;
    }

    public int getSize() {
        return size;
    }

    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }

    public void setInitialY(int initialY) {
        this.initialY = initialY;
    }

    public void drawTitle(){
        title = new Text(90 + xMargin, 50, "Paint");
        title.draw();
    }

    public void drawStartMenu(){
        title = new Text(90 + xMargin, 50, "Start");
        title.draw();
    }

    public void drawCreditsMenu(){
        title = new Text(90 + xMargin, 50, "Credits");
        title.draw();
    }

    public void drawQuitMenu(){

    }

    public void drawMenuOptions(MenuOption optionName){
        int indexMenuOption = MenuOption.valueOf(optionName.toString()).ordinal();
        int spacing = indexMenuOption * 50;
        menuOptions[indexMenuOption] = new Text(350, 200 + spacing, optionName.toString());
        menuOptions[indexMenuOption].setColor(Color.WHITE);
        menuOptions[indexMenuOption].grow(20, 8);
        menuOptions[indexMenuOption].draw();
    }

    public void drawMenu() {
        mainRectangle = new Rectangle(width, height, xMargin, xMargin);
        mainRectangle.setColor(Color.BLACK);
        mainRectangle.fill();
    }
}
