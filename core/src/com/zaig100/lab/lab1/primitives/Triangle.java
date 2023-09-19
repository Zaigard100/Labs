package com.zaig100.lab.lab1.primitives;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle {

    private long id;
    private int x,y,dx,dy,dx1,dy1,dx2,dy2;
    private boolean filled;
    private Color color;

    public Triangle(int x, int y,int dx, int dy, int dx1, int dy1, int dx2, int dy2, boolean filled, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.dx1 = dx1;
        this.dy1 = dy1;
        this.dx2 = dx2;
        this.dy2 = dy2;
        this.filled = filled;
        this.color = color;
    }

    public Triangle(int x) {
    }

    public void render(ShapeRenderer shape, Camera camera) {
        shape.setProjectionMatrix(camera.combined);
        if (filled) {
            shape.begin(ShapeRenderer.ShapeType.Filled);
        }else{
            shape.begin(ShapeRenderer.ShapeType.Line);
        }
            shape.setColor(color);
            shape.triangle(
                    x+dx, y+dy,
                    x+dx1,y+dy1,
                    x+dx2,y+dy2
            );

        shape.end();
    }

    public void move(int dx, int dy){
        x+=dx;
        y+=dy;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
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
    public int getDx1() {
        return dx1;
    }
    public void setDx1(int dx1) {
        this.dx1 = dx1;
    }
    public int getDy1() {
        return dy1;
    }
    public void setDy1(int dy1) {
        this.dy1 = dy1;
    }
    public int getDx2() {
        return dx2;
    }
    public void setDx2(int dx2) {
        this.dx2 = dx2;
    }
    public int getDy2() {
        return dy2;
    }
    public void setDy2(int dy2) {
        this.dy2 = dy2;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
