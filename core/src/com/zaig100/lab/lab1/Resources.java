package com.zaig100.lab.lab1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Resources {

    static FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("lab1/fonts/dongle.ttf"));
    static FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    static Texture menu = new Texture("lab1/textures/frame.png");
    static Texture frame = new Texture("lab1/textures/frame.png");

    public static Sprite menu_s = new Sprite(menu,16,16);
    static BitmapFont dongle12;

    static{
        parameter.size = 32;
        dongle12 = generator.generateFont(parameter);
    }

}
