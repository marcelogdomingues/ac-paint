package org.academiadecodigo.bootcamp.paint.painter;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;

public class Paint {

    private PaintLayout paintLayout;

    private int KEY_LEFT = 37;
    private int KEY_RIGHT = 39;
    private int KEY_UP = 38;
    private int KEY_DOWN = 40;
    private int KEY_SPACE = 32;
    private int KEY_ENTER = '\n';

    private int KEY_S = 83;
    private int KEY_L = 76;

    private static int initialX;
    private static int initialY;

    private int x;
    private int y;

    private int grid = 40 * 50;

    private int minX = 40;
    private int maxX = 1450;
    private int minY = 60;
    private int maxY = 1170;

    //private static ArrayList<RectangleData> saveData = new ArrayList<>();

    private static int savedNumber = 0;

    //save data to txt file
    private File savedData;


    public Paint(PaintLayout paintLayout) throws IOException {

        this.paintLayout = paintLayout;

    }

    public void movement(int keyboardEvent) {

        initialX = paintLayout.getInitialX();
        initialY = paintLayout.getInitialY();

        System.out.println(initialX + " " + initialY);

        if (keyboardEvent == KEY_LEFT) {

            if (initialX < minX) {


            } else {

                x = initialX - 30;
                initialX = x;
                paintLayout.setInitialX(x);
                paintLayout.delete(paintLayout.getMainRectangle());
                paintLayout.drawRectangle(x, initialY, paintLayout.getSize());

            }

        } else if (keyboardEvent == KEY_RIGHT) {

            if (initialX > maxX) {


            } else {

                x = initialX + 30;
                initialX = x;
                paintLayout.setInitialX(x);
                paintLayout.delete(paintLayout.getMainRectangle());
                paintLayout.drawRectangle(x, initialY, paintLayout.getSize());

            }

        } else if (keyboardEvent == KEY_DOWN) {

            if (initialY > maxY) {


            } else {

                y = initialY + 30;
                initialY = y;
                paintLayout.setInitialY(y);
                paintLayout.delete(paintLayout.getMainRectangle());
                paintLayout.drawRectangle(initialX, y, paintLayout.getSize());
            }

        } else if (keyboardEvent == KEY_UP) {

            if (initialY < minY) {


            } else {

                y = initialY - 30;
                initialY = y;
                paintLayout.setInitialY(y);
                paintLayout.delete(paintLayout.getMainRectangle());
                paintLayout.drawRectangle(initialX, y, paintLayout.getSize());

            }
        }
    }

    public void draw(int KeyboardEvent) {

        if (KeyboardEvent == KEY_SPACE) {

            System.out.println(initialX + " " + initialY);

            for (int i = 0; i <= grid; i++) {

                if (paintLayout.getRectangleData().get(i).getX() == initialX && paintLayout.getRectangleData().get(i).getY() == initialY) {

                    paintLayout.getRectangleData().get(i).setPainted(true);
                    paintLayout.getRectangleData().get(i).setFilled(true);
                    paintLayout.getRectangleData().get(i).setColor(Color.BLACK);

                }

            }

        } else {


        }


    }

    public void deleteDraw(int KeyboardEvent) {

        if (KeyboardEvent == KEY_ENTER) {

            System.out.println(initialX + " " + initialY);

            for (int i = 0; i <= grid; i++) {

                if (paintLayout.getRectangleData().get(i).getX() == initialX && paintLayout.getRectangleData().get(i).getY() == initialY) {

                    paintLayout.getRectangleData().get(i).setFilled(false);
                    paintLayout.getRectangleData().get(i).getRectangle().draw();

                }
            }
        }
    }

    public void loadDrawing(int KeyboardEvent) {

        try {

            if (KeyboardEvent == KEY_L) {

                System.out.println("===================== LOADING DATA =====================");

                BufferedReader reader;
                reader = new BufferedReader(new FileReader("src/org/academiadecodigo/bootcamp/paint/filedata/filedata_" + savedNumber + ".txt"));
                String read;


                for (int i = 0; i <= grid; i++) {

                    System.out.println(paintLayout.getRectangleData().get(i));

                    read = reader.readLine();

                    if (read.contains("true")) {

                        System.out.println(read);
                        paintLayout.getRectangleData().get(i).setColor(Color.BLACK);
                        paintLayout.getRectangleData().get(i).getRectangle().fill();


                    }

                }

                reader.close();

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.err.println("->Cannot Load. No draw saved!");

        }

    }

    public void saveDrawing(int KeyboardEvent) throws IOException {

        if (KeyboardEvent == KEY_S) {


           savedData = new File("src/org/academiadecodigo/bootcamp/paint/filedata/filedata_" + savedNumber + ".txt");

           FileWriter writeData;

            writeData = new FileWriter("src/org/academiadecodigo/bootcamp/paint/filedata/filedata_" + savedNumber + ".txt");


            for (int i = 0; i <= grid; i++) {

                //saveData.add();
                //System.out.println(saveData.get(i));

                //Save only Black Rectangles
                //  if(paintLayout.getRectangleData().get(i).isPainted()) {

                writeData.write((paintLayout.getRectangleData().get(i).toString()));
                writeData.write("\n");

                // }

            }

            savedNumber++;

            System.out.println("===================== DATA SAVED =====================");
            writeData.close();

        }

    }

}