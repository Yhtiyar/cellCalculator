package com.cellCalcular.classes;

public class Cell extends RectangleObject {
    public Cell(float x, float y, float length, float height) {
        super(x, y, length, height);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
