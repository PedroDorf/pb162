/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

import sun.security.provider.certpath.Vertex;

/**
 * 
 * @author xmasari3
 * @param tops Vertexes of the triangle
 * @param tri Smaller triangles
 */
public class Triangle {
    private Vertex2D[] tops;
    private Triangle[] tri;
    
    public boolean isDivided() {
        return !(tri == null);
    }
    
    public boolean isOk(int index) {
        if (index <= 2 && index >= 0) {
            return true;
        }
        return false;
    }
    
    public Triangle getSubTriangle(int index) {
        if (isOk(index) && isDivided()) {
            return tri[index];
        }
        return null;
    }
    
    public boolean divide() {
        if (!isDivided()) {
            tri[0] = new Triangle();
            tri[1] = new Triangle();
            tri[2] = new Triangle();
            Vertex2D v00 = tops[0];
            Vertex2D v01 = new Vertex2D();
            v01.setX((tops[0].getX() + tops[1].getX()) / 2);
            v01.setY((tops[0].getY() + tops[1].getY()) / 2);
            Vertex2D v02 = new Vertex2D();
            v02.setX((tops[0].getX() + tops[2].getX()) / 2);
            v02.setY((tops[0].getY() + tops[2].getY()) / 2);
            Vertex2D v10 = tops[1];
            Vertex2D v11 = new Vertex2D();
            v01.setX((tops[0].getX() + tops[1].getX()) / 2);
            v01.setY((tops[0].getY() + tops[1].getY()) / 2);
            Vertex2D v12 = new Vertex2D();
            v02.setX((tops[1].getX() + tops[2].getX()) / 2);
            v02.setY((tops[1].getY() + tops[2].getY()) / 2);
            Vertex2D v20 = tops[2];
            Vertex2D v21 = new Vertex2D();
            v01.setX((tops[1].getX() + tops[2].getX()) / 2);
            v01.setY((tops[1].getY() + tops[2].getY()) / 2);
            Vertex2D v22 = new Vertex2D();
            v02.setX((tops[0].getX() + tops[2].getX()) / 2);
            v02.setY((tops[0].getY() + tops[2].getY()) / 2);
            for (int i = 0; i < 2; i++) {
                tri[i].setVertex(0, tops[i]);
            }
            tri[0].setVertex(1, v01);
            tri[0].setVertex(2, v02);
            tri[1].setVertex(1, v11);
            tri[1].setVertex(2, v12);
            tri[2].setVertex(1, v21);
            tri[2].setVertex(2, v22);
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
