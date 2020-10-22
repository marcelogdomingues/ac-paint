package org.academiadecodigo.bootcamp.paint.movement;

import org.academiadecodigo.bootcamp.paint.painter.Paint;
import org.academiadecodigo.bootcamp.paint.painter.PaintLayout;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.KeyEvent;

public class KeyboardMovement implements KeyboardHandler {

    private Keyboard keyboard;
    private PaintLayout paintLayout;

    public void keyboardOptions(PaintLayout paintLayout) {

        this.paintLayout = paintLayout;

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyLeft = new KeyboardEvent();
            keyLeft.setKey(KeyboardEvent.KEY_LEFT);
            keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyLeft);
        } //Listening to Arrow Key Left

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyRight = new KeyboardEvent();
            keyRight.setKey(KeyboardEvent.KEY_RIGHT);
            keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyRight);
        } //Listening to Arrow Key Right

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyUp = new KeyboardEvent();
            keyUp.setKey(KeyboardEvent.KEY_UP);
            keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyUp);
        } //Listening to Arrow Key Up

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyDown = new KeyboardEvent();
            keyDown.setKey(KeyboardEvent.KEY_DOWN);
            keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyDown);
        } //Listening to Arrow Key Down

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyS = new KeyboardEvent();
            keyS.setKey(KeyboardEvent.KEY_S);
            keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyS);
        } //Listening to S key

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyL = new KeyboardEvent();
            keyL.setKey(KeyboardEvent.KEY_L);
            keyL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyL);
        } //Listening to L key

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keySpace = new KeyboardEvent();
            keySpace.setKey(KeyboardEvent.KEY_SPACE);
            keySpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keySpace);
        } //Listening to ESPACE key

        {
            keyboard = new Keyboard(this);
            KeyboardEvent keyEnter = new KeyboardEvent();
            keyEnter.setKey(KeyEvent.VK_ENTER);
            keyEnter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyEnter);
        } //Listening to ENTER key

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        try {

            Paint paint = new Paint(paintLayout);

            switch (keyboardEvent.getKey()) {

                case (KeyboardEvent.KEY_LEFT):
                    System.out.println("LEFT");
                    paint.movement(KeyboardEvent.KEY_LEFT);

                    break;

                case (KeyboardEvent.KEY_RIGHT):
                    System.out.println("RIGHT");
                    paint.movement(KeyboardEvent.KEY_RIGHT);
                    break;

                case (KeyboardEvent.KEY_UP):
                    System.out.println("UP");
                    paint.movement(KeyboardEvent.KEY_UP);
                    break;

                case (KeyboardEvent.KEY_DOWN):
                    System.out.println("DOWN");
                    paint.movement(KeyboardEvent.KEY_DOWN);
                    break;

                case (KeyboardEvent.KEY_S):
                    System.out.println("S");
                    try {
                        paint.saveDrawing(KeyboardEvent.KEY_S);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case (KeyboardEvent.KEY_L):
                    System.out.println("L");
                    paint.loadDrawing(KeyboardEvent.KEY_L);
                    break;

                case (KeyboardEvent.KEY_SPACE):
                    System.out.println("SPACE");
                    paint.draw(KeyboardEvent.KEY_SPACE);
                    break;

                case (KeyEvent.VK_ENTER):
                    System.out.println("Enter");
                    paint.deleteDraw(KeyEvent.VK_ENTER);
                    break;
            }

        } catch (Exception e) {

            System.out.println("->" + e.getMessage());

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
