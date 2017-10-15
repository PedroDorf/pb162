/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import sun.security.provider.certpath.Vertex;

/**
 * Triangle IT IS A TRAINGLE
 * @author xmasari3
 */
public class Triangle {
    private final Vertex2D[] tops;
    private final Triangle[] triangles;
    /**
     * Creates triangle object from given points
     * @param point0
     * @param point1
     * @param point2 
     */
    public Triangle(Vertex2D point0, Vertex2D point1, Vertex2D point2) {
        tops = new Vertex2D [] {point0, point1, point2};
        triangles = new Triangle[] {null, null, null};
    }
    /**
     * Is triangle equilateral
     * @return true or false
     */
    public boolean isEquilateral() {
        return (Math.abs(tops[0].distance(tops[1])) - Math.abs(tops[0].distance(tops[2])) < 0.001) &&
                (Math.abs(tops[0].distance(tops[1])) - Math.abs(tops[1].distance(tops[2])) < 0.001) &&
                (Math.abs(tops[0].distance(tops[2])) - Math.abs(tops[1].distance(tops[2])) < 0.001);
    }  
    
    /**
     * Is triangle already divided
     * @return true or false
     */
    public boolean isDivided() {
        return triangles[0] != null;
    }
    /**
     * isOk is AGAIN unfortunate name for method...
     * but it checks if the given index is correct...
     * which means it is 0,1 or 2
     * @param index
     * @return True or False 
     */
    public boolean isOk(int index) {
        return (index <= 2 && index >= 0);
    }
    /**
     * Returns n-th mini triangle
     * @param index
     * @return Triangle or null
     */
    public Triangle getSubTriangle(int index) {
        if (isOk(index) && isDivided()) {
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
            Vertex2D vertex01 = new Vertex2D((tops[0].getX() + tops[1].getX()) / 2, (tops[0].getY() + tops[1].getY()) / 2);
            Vertex2D vertex02 = new Vertex2D((tops[0].getX() + tops[2].getX()) / 2, (tops[0].getY() + tops[2].getY()) / 2);
            Vertex2D vertex12 = new Vertex2D((tops[1].getX() + tops[2].getX()) / 2, (tops[1].getY() + tops[2].getY()) / 2);
            triangles[0] = new Triangle(tops[0], vertex01, vertex02);
            triangles[1] = new Triangle(tops[1], vertex01, vertex12);
            triangles[2] = new Triangle(tops[2], vertex02, vertex12);
            return true;
        }
        return false;
    }
    /**
     * Creates n times triangles inside of triangles
     * @param depth how many times does it create triangles
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

    public Vertex2D getVertex(int index) {
        if (isOk(index)) {
            return tops[index];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Triangle: vertices=" + tops[0] + " " + tops[1] + " " + tops[2];
    }
    
}
