/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Vertex2D is a point...
 * @param x X coordinates of the point
 * @param y Y coordinates of the point
 * @author xmasari3
 */
public class Vertex2D {
    private double x;
    private double y;

    double sumCoordinates(){
        return x + y;
    }
    /**
     * move moves point in direction given by param vertex
     * @param vertex 
     */
    public void move(Vertex2D vertex){
        x += vertex.x;
        y += vertex.y;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }
    
    public Vertex2D(){};
    
    public Vertex2D (double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
}
