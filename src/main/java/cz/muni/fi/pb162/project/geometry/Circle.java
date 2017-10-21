/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Circle It is a circle object
 * @author pedro
 */
public class Circle implements Circumcircle, Measurable {
    private final Vertex2D center;
    private final double radius;
    /**
     * Creates default circle
     */
    public Circle() {
        this(new Vertex2D(), 1);
    }
    /**
     * Creates circle with given  parameters
     * @param center Vertex2D object middle of circle
     * @param radius radius of circle
     */
    public Circle(Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    
    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }
    
    @Override
    public double getWidth() {
        return radius * 2;
    }
    
    @Override
    public double getRadius() {
        return radius;
    }
    
    @Override
    public String toString() {
        return "Circle: center=" + center + ", radius=" + radius;
    }
}
