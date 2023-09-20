package com.zaig100.lab.lab1.primitives;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Line {
    private int x,y,dx,dy;
    private int[] points;

    private Color color;

    public Line(int x, int y, int dx, int dy, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    public void render(ShapeRenderer shape, Camera camera){
        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(color);
        shape.line(x,y,
                x+dx,
                y+dy
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
    public int getDx() {
        return dx;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public int getDy() {
        return dy;
    }
    public void setDy(int dy) {
        this.dy = dy;
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
