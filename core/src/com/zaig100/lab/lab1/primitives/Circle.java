package com.zaig100.lab.lab1.primitives;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Circle {
    private int x,y;
    private int radius;
    private boolean filled;
    private Color color;


    public Circle(int x, int y, int radius, boolean filled, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.filled = filled;
        this.color = color;
    }

    public void render(ShapeRenderer shape, Camera camera){
        shape.setProjectionMatrix(camera.combined);
        if (filled) {
            shape.begin(ShapeRenderer.ShapeType.Filled);
        }else{
            shape.begin(ShapeRenderer.ShapeType.Line);
        }

        shape.setColor(color);
            shape.circle(x,y,radius);
        shape.end();
    }

    public void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
