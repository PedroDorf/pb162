/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Square object defined by 4 points and a length of a side.
 * @author pedro
 */
public class Square implements Circumcircle {
    private double length;
    private Vertex2D vertex;
    private Vertex2D pointB;
    private Vertex2D pointC;
    private Vertex2D pointD;
    
    /**
     * Creates square given bottom left Vertex and side length.
     * @param length Length of a side.
     * @param bottomLeft Initial point in square which is bottom left.
     */
    public Square(double length, Vertex2D bottomLeft) {
        this.length = length;
        this.vertex = bottomLeft;
        pointB = vertex.move(new Vertex2D(length, 0));
        pointC = vertex.move(new Vertex2D(length, length));
        pointD = vertex.move(new Vertex2D(0, length));
    }
    
    /**
     * Creates square given by Center of the square and side lenegth.
     * @param center Center of the square
     * @param radius Length of a side.
     */
    public Square(Vertex2D center, double radius) {
        this.vertex = center.move(new Vertex2D(radius * (-1.0) / 2, radius * (-1.0) / 2));
        this.length = radius;
        pointB = vertex.move(new Vertex2D(radius, 0));
        pointC = vertex.move(new Vertex2D(radius, radius));
        pointD = vertex.move(new Vertex2D(0, radius));
    }
    
    /**
     * Return index-th Vertex in square.
     * @param index Which Vertex to return.
     * @return Index-th Vertex.
     */
    public Vertex2D getVertex(int index) {
        switch(index) {
            case 0:
                return vertex;
            case 1:
                return pointB;
            case 2:
                return pointC;
            case 3:
                return pointD;
            default:
                return null;
        }
    }
    
    @Override
    public Vertex2D getCenter() {
        return vertex.move(new Vertex2D(length / 2, length / 2));
    }
    
    public double getEdgeLength() {
        return length;
    }
    
    @Override
    public double getRadius() {
        return (Math.sqrt(2)/2)*length;
    }

    @Override
    public String toString() {
        return "Square: vertices=" + vertex + " " + pointB + " " + pointC + " " + pointD;
    }
    
}
