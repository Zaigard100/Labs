package com.zaig100.lab.lab1.primitives;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Line {
    private int x,y,x1,y1;
    private int[] points;

    private Color color;

    public Line(int x, int y, int x1, int y1, Color color) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    public void render(ShapeRenderer shape, Camera camera){
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(color);
        shape.line( x,y,
                    x+x1,y+y1
        );

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
    public int getX1() {
        return x1;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getY1() {
        return y1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int[] getPoints() {
        return points;
    }
    public void setPoints(int[] points) {
        this.points = points;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
