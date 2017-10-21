/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Triangle given by 3 Vertices.
 * @author xmasari3
 */
public class Triangle implements Measurable{
    public static final double MIN_COMPARABLE = 0.001;
    private final Vertex2D[] tops;
    private final Triangle[] triangles = new Triangle[3];
    
    @Override
    public double getWidth() {
        Vertex2D widthmin = SimpleMath.minX(tops);
        Vertex2D widthmax = SimpleMath.maxX(tops);
        return widthmax.getX() - widthmin.getX();
    }
    
    @Override
    public double getHeight() {
        Vertex2D heightmin = SimpleMath.minY(tops);
        Vertex2D heightmax = SimpleMath.maxY(tops);
        return heightmax.getY() - heightmin.getY();  
    }
    
    /**
     * Creates triangle object from given points
     * @param point0 Bottom left Vertex  - A
     * @param point1 Bottom right Vertex - B
     * @param point2 Top Vertex          - C
     */
    public Triangle(Vertex2D point0, Vertex2D point1, Vertex2D point2) {
        tops = new Vertex2D [] {point0, point1, point2};
    }
    /**
     * Is triangle equilateral
     * @return True or False
     */
    public boolean isEquilateral() {
        return (Math.abs(tops[0].distance(tops[1])) - Math.abs(tops[0].distance(tops[2])) < MIN_COMPARABLE) &&
                (Math.abs(tops[0].distance(tops[1])) - Math.abs(tops[1].distance(tops[2])) < MIN_COMPARABLE) &&
                (Math.abs(tops[0].distance(tops[2])) - Math.abs(tops[1].distance(tops[2])) < MIN_COMPARABLE);
    }  
    
    /**
     * Is triangle already divided?
     * @return True or False.
     */
    public boolean isDivided() {
        return triangles[0] != null;
    }
    /**
     * Is given index is valid?
     * @param index Index to validate.
     * @return Valid(True) or Invalid(False).
     */
    public boolean isCorrect(int index) {
        return (index <= 2 && index >= 0);
    }
    /**
     * Returns index-th mini triangle.
     * @param index Which mini triangle to return.
     * @return index-th Triangle or null.
     */
    public Triangle getSubTriangle(int index) {
        if (isCorrect(index) && isDivided()) {
            return triangles[index];
        }
        return null;
    }
    /**
     * Creates triangle and sets points of these triangles.
     * 
     * @return bool Successful or not
     */
    public boolean divide() {
        if (!isDivided()) {
            Vertex2D vertex01 = new Vertex2D(
                                        (tops[0].getX() + tops[1].getX()) / 2
                                      , (tops[0].getY() + tops[1].getY()) / 2);
            Vertex2D vertex02 = new Vertex2D(
                                        (tops[0].getX() + tops[2].getX()) / 2
                                      , (tops[0].getY() + tops[2].getY()) / 2);
            Vertex2D vertex12 = new Vertex2D(
                                        (tops[1].getX() + tops[2].getX()) / 2
                                      , (tops[1].getY() + tops[2].getY()) / 2);
            triangles[0] = new Triangle(tops[0], vertex01, vertex02);
            triangles[1] = new Triangle(tops[1], vertex01, vertex12);
            triangles[2] = new Triangle(tops[2], vertex02, vertex12);
            return true;
        }
        return false;
    }
    /**
     * Creates n times triangles inside of triangles
     * @param depth How many times does it create triangles.
     * @return stop recursion true(no) or false(yes sthaaap plzz) 
     */
    public boolean divide(int depth) {
        if (depth > 0) {
            divide();
            triangles[0].divide(depth - 1);
            triangles[1].divide(depth - 1);
            triangles[2].divide(depth - 1);
            return true;
        }
        return false;
    }
    
    /**
     * Return index-th Vertex from tops.
     * @param index Which Vertex to return.
     * @return Index-th Vertex.
     */
    public Vertex2D getVertex(int index) {
        if (isCorrect(index)) {
            return tops[index];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Triangle: vertices=" + tops[0] + " " + tops[1] + " " + tops[2];
    }
    
}
