/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
/**
 *
 * @author pedro
 */
public class Demo {
    public static void main(String[]args) {
        Triangle triangle = new Triangle();
        Vertex2D ver0 = new Vertex2D();
        Vertex2D ver1 = new Vertex2D();
        Vertex2D ver2 = new Vertex2D();
        ver0.setX(-100);
        ver0.setY(0);
        ver1.setX(0);
        ver1.setY(100.0);
        ver2.setX(100.0);
        ver2.setY(-100.0);
        triangle.setVertex(0, ver0);
        triangle.setVertex(1, ver1);
        triangle.setVertex(2, ver2);
        triangle.toString();
    }
    
}
