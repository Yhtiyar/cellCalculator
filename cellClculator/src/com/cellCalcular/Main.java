package com.cellCalcular;

import com.cellCalcular.classes.Cell;
import com.cellCalcular.classes.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0,0,2200, 1500);


        rectangle.addHorizontalLine(0, 500, 1100); //h1
        rectangle.addHorizontalLine(1500, 0, 700); //h2
        rectangle.addHorizontalLine(0, 500, 1100); //h3
        rectangle.addHorizontalLine(1500, 0, 700); //h4

        rectangle.addVerticalLine(700, 1000, 500); //v1
        rectangle.addVerticalLine(0, 0, 500);     //v2
        rectangle.addVerticalLine(400, 0, 1500);   //v3
        rectangle.addVerticalLine(400, 0, 1500);   //v4

        List<Cell> cells= rectangle.getCells();
        System.out.println("found " + cells.size());
        for (Cell c : cells){
            System.out.println(c);
        }
    }
}
