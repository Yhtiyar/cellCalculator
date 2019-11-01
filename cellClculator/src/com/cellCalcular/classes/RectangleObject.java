package com.cellCalcular.classes;

public abstract class RectangleObject {
    protected float x, y;
    protected float length, height;

    public RectangleObject(float x, float y, float length, float height) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }
}
