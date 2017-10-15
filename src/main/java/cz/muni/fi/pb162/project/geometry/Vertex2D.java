/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Vertex2D is a point...
 * @author xmasari3
 */
public class Vertex2D {
    private final double x;
    private final double y;
    /**
     * Creates default point [0,0]
     */
    public Vertex2D(){
        this(0,0);
    }
    /**
     * Creates point [x,y]
     * @param x 
     * @param y 
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Sums coordinates
     * @return coordinates sum
     */
    public double sumCoordinates(){
        return x + y;
    }
    /**
     * move moves point in direction given by parameter vertex
     * @param vertex how much to move the main point
     * @return new Object moved by those 2 points
     */
    public Vertex2D move(Vertex2D vertex){
        return new Vertex2D(x + vertex.getX(), y + vertex.getY());
    }
    /**
     * Distance between 2 points
     * @param vertex between which point
     * @return how big distance there is
     */
    public double distance(Vertex2D vertex) {
        if (vertex != null) {
            return Math.sqrt(Math.pow(vertex.getX() - x, 2) + Math.pow(vertex.getY() - y, 2));
        }
        return -1.0;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return '[' + x + ", " + y + ']';
    }
}
