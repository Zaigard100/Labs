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
    private boolean isMenuOpen = false;
    private boolean isTriangle = false;
    private boolean isCircle = false;
    private boolean isLine = false;

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
        utils.load("/home/zaigard/Projects/Labs/assets/lab1/list.txt");
        utils.script("/home/zaigard/Projects/Labs/assets/lab1/script.txt");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        camera.update();
        batch.begin();
        batch.enableBlending();
            if(isMenuOpen){

                Resources.dongle12.draw(batch,"Line", (float) -main.WIDTH /2+75, (float) -main.HEIGHT /2+95+65);
                Resources.dongle12.draw(batch,"Triangle", (float) -main.WIDTH /2+75, (float) -main.HEIGHT /2+95+65+65);
                batch.draw(Resources.frame, (float) -main.WIDTH /2, (float) -main.HEIGHT /2+64,64,64);
                batch.draw(Resources.frame, (float) -main.WIDTH /2, (float) -main.HEIGHT /2+64*2,64,64);
                batch.draw(Resources.frame, (float) -main.WIDTH /2, (float) -main.HEIGHT /2+64*3,64,64);
                if(isCircle){

                    batch.draw(Resources.arrow_up, (float) -main.WIDTH /2+64*2, (float) -main.HEIGHT /2+64*2,64,64);
                    batch.draw(Resources.arrow_up, (float) -main.WIDTH /2+64*3, (float) -main.HEIGHT /2+64*2,64,64);
                    batch.draw(Resources.arrow_up, (float) -main.WIDTH /2+64*4, (float) -main.HEIGHT /2+64*2,64,64);
                    batch.draw(Resources.arrow_up, (float) -main.WIDTH /2+64*5, (float) -main.HEIGHT /2+64*2,64,64);
                    batch.draw(Resources.arrow_up, (float) -main.WIDTH /2+64*6, (float) -main.HEIGHT /2+64*2,64,64);

                    batch.draw(Resources.frame, (float) -main.WIDTH /2+64*2, (float) -main.HEIGHT /2+64,64,64);
                    batch.draw(Resources.frame, (float) -main.WIDTH /2+64*3, (float) -main.HEIGHT /2+64,64,64);
                    batch.draw(Resources.frame, (float) -main.WIDTH /2+64*4, (float) -main.HEIGHT /2+64,64,64);
                    batch.draw(Resources.frame, (float) -main.WIDTH /2+64*5, (float) -main.HEIGHT /2+64,64,64);
                    batch.draw(Resources.frame, (float) -main.WIDTH /2+64*6, (float) -main.HEIGHT /2+64,64,64);

                    batch.draw(Resources.arrow_down, (float) -main.WIDTH /2+64*2, (float) -main.HEIGHT /2,64,64);
                    batch.draw(Resources.arrow_down, (float) -main.WIDTH /2+64*3, (float) -main.HEIGHT /2,64,64);
                    batch.draw(Resources.arrow_down, (float) -main.WIDTH /2+64*4, (float) -main.HEIGHT /2,64,64);
                    batch.draw(Resources.arrow_down, (float) -main.WIDTH /2+64*5, (float) -main.HEIGHT /2,64,64);
                    batch.draw(Resources.arrow_down, (float) -main.WIDTH /2+64*6, (float) -main.HEIGHT /2,64,64);

                }else {
                    Resources.dongle12.draw(batch,"Circle", (float) -main.WIDTH /2+75, (float) -main.HEIGHT /2+95);
                }
            }
                batch.draw(Resources.menu, (float) -main.WIDTH /2, (float) -main.HEIGHT /2,64,64);

            batch.disableBlending();
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

            if(Gdx.input.justTouched()){
                //utils.next();
                int getY = Gdx.graphics.getHeight() - Gdx.input.getY();
                if(Gdx.input.getX()<=64){
                    if(getY<=64){
                        if(isMenuOpen){
                            isMenuOpen = false;
                        }else {
                            isMenuOpen = true;
                        }
                    }
                }

                if(isMenuOpen){
                    if(Gdx.input.getX()<=64){

                        if(getY>=64&&getY<=64*2){
                            if(isCircle){
                                isCircle = false;
                            }else {
                                isCircle = true;
                            }
                        }
                        if(getY>=64*2&&getY<=64*3){
                            if(isLine){
                                isLine = false;
                            }else {
                                isLine = true;
                            }
                        }
                        if(getY>=64*3&&getY<=64*4){
                            if(isTriangle){
                                isTriangle = false;
                            }else {
                                isTriangle = true;
                            }
                        }
                    }else {
                        isCircle = false;
                        isLine = false;
                        isTriangle = false;
                    }


                }
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
