package com.zaig100.lab.lab1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.zaig100.lab.Main;
import com.zaig100.lab.lab1.primitives.Circle;
import com.zaig100.lab.lab1.primitives.Line;
import com.zaig100.lab.lab1.primitives.Triangle;

import java.security.Key;
import java.util.ArrayList;

public class Lab1Screen implements Screen {

    Main main;
    private ShapeRenderer shape;
    private FitViewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Utils utils;

    public Lab1Screen(Main main){
        this.main = main;
    }

    @Override
    public void show() {
        shape = new ShapeRenderer();
        camera = new OrthographicCamera();
        viewport = new FitViewport(main.WIDTH, main.HEIGHT, camera);
        batch = new SpriteBatch();
        utils = new Utils();
        utils.load("/home/zaigard/Projects/Labs/assets/list.txt");
        utils.script("/home/zaigard/Projects/Labs/assets/script.txt");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
            for(Triangle t: utils.getTriangles()){
                t.render(shape,camera);
            }
            for(Line l:utils.getLines()){
                l.render(shape,camera);
            }
            for(Circle c:utils.getCircles()){
                c.render(shape,camera);
            }
        batch.end();

            if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
                utils.next();
            }
    }

    @Override
    public void resize(int width, int height) {
        main.WIDTH = width;
        main.HEIGHT = height;
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shape.dispose();
        utils.dispose();
        utils = null;
    }

    public Main getMain() {
        return main;
    }

}
