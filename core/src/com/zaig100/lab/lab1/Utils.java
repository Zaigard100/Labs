package com.zaig100.lab.lab1;

import com.badlogic.gdx.graphics.Color;
import com.zaig100.lab.lab1.primitives.Circle;
import com.zaig100.lab.lab1.primitives.Line;
import com.zaig100.lab.lab1.primitives.Triangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {

    private ArrayList<Triangle> triangles;
    private ArrayList<Line> lines;
    private ArrayList<Circle> circles;

    private String line ="";
    private ArrayList<String> scripts;

    private int iter = 0;

    public Utils(){
        triangles = new ArrayList<>();
        lines = new ArrayList<>();
        circles = new ArrayList<>();

        scripts = new ArrayList<>();
    }

    public  void load(String file){
        line = "";
        try(FileReader reader = new FileReader(file))
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

    public void script(String file){
        line = "";
        try(FileReader reader = new FileReader(file))
        {

            int c;
            while((c=reader.read())!=-1){

                if(c=='\n'){
                    scripts.add(line);
                    line = "";
                    continue;
                }
                line += (char)c;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scripts.add(line);
    }

    public void next(){
        if(scripts.size()==iter) return;
        String[] words = scripts.get(iter).split(",");

        if(words[0].charAt(0)=='t'){
            System.out.println(words[0].charAt(0)+" "+words[0].replace("t", "")+" "+words[1]+" "+words[2]);
            if(words[1].equals("move")) {
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).move(Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            }else if(words[1].equals("x")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setX(Integer.parseInt(words[2]));
            }else if(words[1].equals("y")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setY(Integer.parseInt(words[2]));
            }else if(words[1].equals("dx")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDx(Integer.parseInt(words[2]));
            }else if(words[1].equals("dy")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDy(Integer.parseInt(words[2]));
            }else if(words[1].equals("dx1")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDx1(Integer.parseInt(words[2]));
            }else if(words[1].equals("dy1")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDy1(Integer.parseInt(words[2]));
            }else if(words[1].equals("dx2")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDx2(Integer.parseInt(words[2]));
            }else if(words[1].equals("dy2")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setDy2(Integer.parseInt(words[2]));
            }else if(words[1].equals("filled")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setFilled(Boolean.parseBoolean(words[2]));
            }else if(words[1].equals("color")){
                triangles.get(Integer.parseInt(words[0].replace("t", ""))).setColor(color(words[2]));
            }else{
                System.out.println(words[0]+" incorrect command");
            }
        }else if(words[0].charAt(0)=='l'){
            System.out.println(words[0].charAt(0)+" "+words[0].replace("l", "")+" "+words[1]+" "+words[2]);
            if(words[1].equals("move")) {
                lines.get(Integer.parseInt(words[0].replace("l", ""))).move(Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            }else if(words[1].equals("x")){
                lines.get(Integer.parseInt(words[0].replace("l", ""))).setX(Integer.parseInt(words[2]));
            }else if(words[1].equals("y")){
                lines.get(Integer.parseInt(words[0].replace("l", ""))).setY(Integer.parseInt(words[2]));
            }else if(words[1].equals("dx")){
                lines.get(Integer.parseInt(words[0].replace("l", ""))).setDx(Integer.parseInt(words[2]));
                System.out.println(lines.get(Integer.parseInt(words[0].replace("l", ""))).getDx());
            }else if(words[1].equals("dy")){
                lines.get(Integer.parseInt(words[0].replace("l", ""))).setDy(Integer.parseInt(words[2]));
                System.out.println(lines.get(Integer.parseInt(words[0].replace("l", ""))).getDy());
            }else if(words[1].equals("color")){
                lines.get(Integer.parseInt(words[0].replace("l", ""))).setColor(color(words[2]));
            }else{
                System.out.println(words[0]+" incorrect command");
            }
        }else if(words[0].charAt(0)=='c'){
            System.out.println(words[0].charAt(0)+" "+words[0].replace("c", "")+" "+words[1]+" "+words[2]);
            if(words[1].equals("move")) {
                circles.get(Integer.parseInt(words[0].replace("c", ""))).move(Integer.parseInt(words[2]),Integer.parseInt(words[3]));
            }else if(words[1].equals("x")){
                circles.get(Integer.parseInt(words[0].replace("c", ""))).setX(Integer.parseInt(words[2]));
            }else if(words[1].equals("y")){
                circles.get(Integer.parseInt(words[0].replace("c", ""))).setY(Integer.parseInt(words[2]));
            }else if(words[1].equals("radius")){
                circles.get(Integer.parseInt(words[0].replace("c", ""))).setRadius(Integer.parseInt(words[2]));
            }else if(words[1].equals("filled")){
                circles.get(Integer.parseInt(words[0].replace("c", ""))).setFilled(Boolean.parseBoolean(words[2]));
            }else if(words[1].equals("color")){
                circles.get(Integer.parseInt(words[0].replace("c", ""))).setColor(color(words[2]));
            }else{
                System.out.println(words[0]+" incorrect command");
            }
        }
        iter++;
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
