package com.cellCalcular.classes;

public abstract class Line {
    protected float x;
    protected float y;
    protected float length;
    protected  float topMargin;
    protected  float leftMargin; //mozhno eto i ubrat, weserawnno tMargin i lMArgin ni gde ne ispolziyutsya

    public Line(float x, float y, float length, float leftMargin, float topMargin) throws  IllegalArgumentException{
        this.x = x;
        this.y = y;
        this.length = length;
        this.topMargin = topMargin;
        this.leftMargin = leftMargin;
        if (length <= 0)
            throw  new IllegalArgumentException("Line cannot have length < 0");
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

    @Override
    public String toString() {
        return "Line{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + length +
                '}';
    }
}
