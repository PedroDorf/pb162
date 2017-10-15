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
 * @param tops Vertexes of the triangle
 * @param tri Smaller triangles inside the triangle
 * @see tops and tri are really BAD and SHAMEFUL names
 * for params... I swear I will never do this again
 * but there is no time to replace those param names in
 * whole code!
 */
public class Triangle {
    private Vertex2D[] tops = new Vertex2D[3];
    private Triangle[] tri;
    
    public Triangle(){};
    public Triangle(Vertex2D point0, Vertex2D point1, Vertex2D point2) {
        tops[0] = point0;
        tops[1] = point1;
        tops[2] = point2;
    }
    
    public boolean isDivided() {
        return !(tri == null);
    }
    /**
     * isOk is AGAIN unfortunate name for method...
     * but it checks if the given index is correct...
     * which means it is 0,1 or 2
     * @param index
     * @return True or False 
     */
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
    /**
     * divide is NextLevel of how to show incompetence
     * in writing java code
     * This awful living example is how not to do it.
     * So what it does...
     * Creates triangle and sets points of these triangles.
     * 
     * @return bool Successful or not
     */
    public boolean divide() {
        if (!isDivided()) {
            tri = new Triangle[3];
            tri[0] = new Triangle();
            tri[1] = new Triangle();
            tri[2] = new Triangle();
            //A
            Vertex2D v00 = tops[0]; 
            //AB
            Vertex2D v01 = new Vertex2D();
            v01.setX((tops[0].getX() + tops[1].getX()) / 2);
            v01.setY((tops[0].getY() + tops[1].getY()) / 2);
            //AC
            Vertex2D v02 = new Vertex2D();
            v02.setX((tops[0].getX() + tops[2].getX()) / 2);
            v02.setY((tops[0].getY() + tops[2].getY()) / 2);
            //B
            Vertex2D v10 = tops[1];
            //BA
            Vertex2D v11 = new Vertex2D();
            v11.setX((tops[0].getX() + tops[1].getX()) / 2);
            v11.setY((tops[0].getY() + tops[1].getY()) / 2);
            //BC
            Vertex2D v12 = new Vertex2D();
            v12.setX((tops[1].getX() + tops[2].getX()) / 2);
            v12.setY((tops[1].getY() + tops[2].getY()) / 2);
            //C
            Vertex2D v20 = tops[2];
            //AC
            Vertex2D v21 = new Vertex2D();
            v21.setX((tops[0].getX() + tops[2].getX()) / 2);
            v21.setY((tops[0].getY() + tops[2].getY()) / 2);
            //BC
            Vertex2D v22 = new Vertex2D();
            v22.setX((tops[1].getX() + tops[2].getX()) / 2);
            v22.setY((tops[1].getY() + tops[2].getY()) / 2);
            //Sets points for those little triangles
            for (int i = 0; i < 3; i++) {
                //I was like it sure can be made with "for" right?
                //WRONG I'm not suure how to create lists so...
                //I can't really make it happend
                //but fingers crossed in later iterations! 
                tri[i].setVertex(0, getVertex(i));
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
    /**
     * @return Skeleton/exmaple/how will it look when it prints: Triangle: vertices=A, B, C
     * A,B,C are [x, y] coordinates of those points.
     */
    public String toString() {
        return "Triangle: vertices=" + getVertex(0) + " " + getVertex(1) + " " + getVertex(2);
    }
    
}
