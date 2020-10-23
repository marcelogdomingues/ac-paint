package org.academiadecodigo.bootcamp.paint.painter;

import org.academiadecodigo.bootcamp.paint.movement.KeyboardMovement;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class PaintManager {

    private PaintLayout paintLayout;

    public void start(int width, int height, int xMargin, int yMargin, Color backgroundColor) {

        KeyboardMovement keyboardMovement = new KeyboardMovement();

        paintLayout = new PaintLayout(width, height, xMargin, yMargin, backgroundColor);
        paintLayout.drawBackground();
        paintLayout.drawInitRectangle();

        if(true) {

            keyboardMovement.keyboardOptions(paintLayout);

        }else {



        }

    }

}
