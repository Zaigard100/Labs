package com.zaig100.lab.lab1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Resources {

    static public FreeTypeFontGenerator generator ;
    static public FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    static public Texture menu,frame,arrow_up,arrow_down;

    static  BitmapFont dongle12;

    static{
        generator = new FreeTypeFontGenerator(Gdx.files.internal("lab1/fonts/dongle.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 32;
        dongle12 = generator.generateFont(parameter);

        frame = new Texture(Gdx.files.internal("lab1/textures/frame.png"));
        menu = new Texture(Gdx.files.internal("lab1/textures/menu.png"));
        arrow_up = new Texture(Gdx.files.internal("lab1/textures/arrow_up.png"));
        arrow_down = new Texture(Gdx.files.internal("lab1/textures/arrow_down.png"));
    }

}
