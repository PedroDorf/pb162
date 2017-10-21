/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 *
 * @author pedro
 */

public class Gauger {
    
    /**
     * Prints out Height and Width of object type Measurable.
     * @param object What to measure.
     */
    public static void printMeasurement(Measurable object) {
        System.out.println("Width: " + object.getWidth());
        System.out.println("Height: " + object.getHeight());
    }
    
    /**
     * Prints out Height and Width of object type Triangle.
     * @param triangle What triangle to measure.
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle.toString());
        printMeasurement((Measurable)triangle);
    }
}
