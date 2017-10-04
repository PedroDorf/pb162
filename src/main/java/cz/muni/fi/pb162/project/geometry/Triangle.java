/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author xmasari3
 */
public class Triangle {
    private Vertex2D[] tops;
    private Triangle[] tri;
    
    public boolean isDivided() {
        return true;
    }
    
    public boolean isOk(int index) {
        if (index <= 2 && index >= 0) {
            return true;
        }
        return false;
    }
    
    public Triangle getSubTriangle(int index) {
        if (isOk(index)) {
            return tri[index];
        }
        return null;
    }
    
    public boolean divide() {
        if (!isDivided()) {
            tri[0] = new Triangle();
            tri[1] = new Triangle();
            tri[2] = new Triangle();
            setVertex(0, (tops[0].getX() + tops[1].getX()) / 2);
        }
    }

    public Vertex2D getVertex(int index) {
        if (isOk(index)) {
            return tops[index];
        }
        return null;
    }
    
    public void setVertex(int index, Vertex2D vertex) {
        if (isOk(index)) {
            tops[index] = vertex;
        }
        return;
    }

    @Override
    public String toString() {
        return "Triangle: vertices=" + tops[0].toString()+ " " + tops[1].toString() + " " + tops[2].toString();
    }
    
}
