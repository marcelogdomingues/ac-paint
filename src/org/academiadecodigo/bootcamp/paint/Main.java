package org.academiadecodigo.bootcamp.paint;

import org.academiadecodigo.bootcamp.paint.painter.PaintManager;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Main {

    public static void main(String[] args) {

        PaintManager paintManager = new PaintManager();
        paintManager.start(1000,1000,10,10, Color.WHITE);

    }

}
