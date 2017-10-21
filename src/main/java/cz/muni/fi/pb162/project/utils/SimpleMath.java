/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class full of some helpful tools.
 * @author pedro
 */
public class SimpleMath {
    
    /**
     * Which Vertex has the smallest X parameter.
     * @param vertices List of Vertices.
     * @return Vertex with smallest X parameter.
     */
    public static Vertex2D minX(Vertex2D[] vertices) {
        Vertex2D min = vertices[0];
        for (Vertex2D vertex : vertices) {
            if (vertex.getX() < min.getX()) {
                min = vertex;
            }
        }
        return min;
    }
    
    /**
     * Which Vertex has the biggest X parameter.
     * @param vertices List of Vertices.
     * @return Vertex with biggest X parameter.
     */
    public static Vertex2D maxX(Vertex2D[] vertices) {
        Vertex2D max = vertices[0];
        for (Vertex2D vertex : vertices) {
            if (vertex.getX() > max.getX()) {
                max = vertex;
            }
        }
        return max;
    }
    
    /**
     * Which Vertex has the smallest Y parameter.
     * @param vertices List of Vertices.
     * @return Vertex with smallest Y parameter.
     */
    public static Vertex2D minY(Vertex2D[] vertices) {
        Vertex2D min = vertices[0];
        for (Vertex2D vertex : vertices) {
            if (vertex.getY() < min.getY()) {
                min = vertex;
            }
        }
        return min;
    }
    
    /**
     * Which Vertex has the biggest Y parameter.
     * @param vertices List of Vertices.
     * @return Vertex with biggest Y parameter.
     */
    public static Vertex2D maxY(Vertex2D[] vertices) {
        Vertex2D max = vertices[0];
        for (Vertex2D vertex : vertices) {
            if (vertex.getY() > max.getY()) {
                max = vertex;
            }
        }
        return max;
    }
}
