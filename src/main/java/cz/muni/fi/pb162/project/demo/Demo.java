/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
/**
 * Demo creates 3 points and a triangle with these points
 * as its tops.
 * @param ver0
 * @param ver1
 * @param ver2 Those 3 points.
 * @author pedro
 */
public class Demo {
    public static void main(String[]args) {
        
        Vertex2D ver0 = new Vertex2D(-100,0);
        Vertex2D ver1 = new Vertex2D(0,100);
        Vertex2D ver2 = new Vertex2D(100,-100);
        
        Triangle triangle = new Triangle(ver0, ver1, ver2);
        System.out.println(triangle);
     }
}
