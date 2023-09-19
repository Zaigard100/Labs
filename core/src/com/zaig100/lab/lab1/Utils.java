package com.zaig100.lab.lab1;

import com.badlogic.gdx.graphics.Color;
import com.zaig100.lab.lab1.primitives.Circle;
import com.zaig100.lab.lab1.primitives.Line;
import com.zaig100.lab.lab1.primitives.Triangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {

    private ArrayList<Triangle> triangles;
    private ArrayList<Line> lines;
    private ArrayList<Circle> circles;

    String line ="";

    public Utils(){
        triangles = new ArrayList<>();
        lines = new ArrayList<>();
        circles = new ArrayList<>();
    }

    public  void load(){
        try(FileReader reader = new FileReader("/home/zaigard/Projects/Labs/assets/list.txt"))
        {

            int c;
            while((c=reader.read())!=-1){

                if(c=='\n'){
                    parse_line(line);
                    line = "";
                    continue;
                }
                line += (char)c;

            }
            parse_line(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void parse_line(String line){
        String[] words = line.split(",");
        if(words[0].equals("t")){
            triangles.add(new Triangle(
                    Integer.parseInt(words[1]),
                    Integer.parseInt(words[2]),
                    Integer.parseInt(words[3]),
                    Integer.parseInt(words[4]),
                    Integer.parseInt(words[5]),
                    Integer.parseInt(words[6]),
                    Integer.parseInt(words[7]),
                    Integer.parseInt(words[8]),
                    Boolean.parseBoolean(words[9]),
                    color(words[10])
            ));
        }else if(words[0].equals("l")){
            lines.add(new Line(
                    Integer.parseInt(words[1]),
                    Integer.parseInt(words[2]),
                    Integer.parseInt(words[3]),
                    Integer.parseInt(words[4]),
                    color(words[5])
            ));
        }else if(words[0].equals("c")){
            circles.add(new Circle(
                    Integer.parseInt(words[1]),
                    Integer.parseInt(words[2]),
                    Integer.parseInt(words[3]),
                    Boolean.parseBoolean(words[4]),
                    color(words[5])
            ));
        }
    }

    public void dispose(){
        triangles.clear();
        lines.clear();
        circles.clear();
    }

    private Color color(String word){
        if(word.equals("white")){
            return Color.WHITE;
        }else if(word.equals("light_grey")){
            return Color.LIGHT_GRAY;
        }else if(word.equals("grey")){
            return Color.GRAY;
        }else if(word.equals("dark_grey")){
            return Color.DARK_GRAY;
        }else if(word.equals("black")){
            return Color.BLACK;
        }else if(word.equals("clear")){
            return Color.CLEAR;
        }else if(word.equals("blue")){
            return Color.BLUE;
        }else if(word.equals("navy")){
            return Color.NAVY;
        }else if(word.equals("royal")){
            return Color.ROYAL;
        }else if(word.equals("slate")){
            return Color.SLATE;
        }else if(word.equals("sky")){
            return Color.SKY;
        }else if(word.equals("cyan")){
            return Color.CYAN;
        }else if(word.equals("teal")){
            return Color.TEAL;
        }else if(word.equals("green")){
            return Color.GREEN;
        }else if(word.equals("chartreuse")){
            return Color.CHARTREUSE;
        }else if(word.equals("lime")){
            return Color.LIME;
        }else if(word.equals("forest")){
            return Color.FOREST;
        }else if(word.equals("olive")){
            return Color.OLIVE;
        }else if(word.equals("yellow")){
            return Color.YELLOW;
        }else if(word.equals("gold")){
            return Color.GOLD;
        }else if(word.equals("goldenrod")){
            return Color.GOLDENROD;
        }else if(word.equals("orange")){
            return Color.ORANGE;
        }else if(word.equals("brown")){
            return Color.BROWN;
        }else if(word.equals("tan")){
            return Color.TAN;
        }else if(word.equals("firebrick")){
            return Color.FIREBRICK;
        }else if(word.equals("red")){
            return Color.RED;
        }else if(word.equals("scarlet")){
            return Color.CLEAR;
        }else if(word.equals("coral")){
            return Color.CORAL;
        }else if(word.equals("salmon")){
            return Color.SALMON;
        }else if(word.equals("pink")){
            return Color.PINK;
        }else if(word.equals("magenta")){
            return Color.MAGENTA;
        }else if(word.equals("purple")){
            return Color.PURPLE;
        }else if(word.equals("violet")){
            return Color.VIOLET;
        }else if(word.equals("maroon")){
            return Color.MAROON;
        }else{
            return Color.CLEAR;
        }
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }
}
