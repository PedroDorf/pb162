/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;
/**
 * Snowman object. YAY!
 * @author pedro
 */
public class Snowman {
    public static final int DEFAULT_NUM_OF_CIRCLES = 4;
    public static final double DEFAULT_SMALL_RATIO = 0.8;
    private Circumcircle[] circles;
    private double smallRatio;
    /**
     * Creates snowman with default number of circles.
     * @param mainCircle The bottom circle.
     * @param smallRatio Ratio of how much smaller should other circles be.
     */
    public Snowman(Circumcircle mainCircle, double smallRatio) {
        this(mainCircle, smallRatio, DEFAULT_NUM_OF_CIRCLES);
    }
    
    /**
     * Creates snowman
     * @param mainCircle The bottom circle.
     * @param smallRatio Ratio of how much smaller other circles be should.
     * @param numOfCircles Number of all circles.
     */
    public Snowman(Circumcircle mainCircle, double smallRatio, int numOfCircles) {
        if (smallRatio <= 0 || smallRatio > 1) {
            smallRatio = DEFAULT_SMALL_RATIO;
        }
        this.smallRatio = smallRatio;
        
        circles = new Circumcircle[numOfCircles];
        circles[0] = mainCircle;
        for (int i = 1; i < numOfCircles; i++) {
            circles[i] = calculateCurrentCircle(circles[i - 1], this.smallRatio);
        }
    }
    
    /**
     * Calculates where should the next circle of the snowman be
     * @param previousCircle Circle before the calculated circle.
     * @param ratio Ratio of how much smaller other circle be should.
     * @return The calculated circle.
     */
    private Circumcircle calculateCurrentCircle(Circumcircle previousCircle, double ratio) {
        Vertex2D previousCenter = previousCircle.getCenter();
        double previousRadius = previousCircle.getRadius();
        double currenntRadius = previousRadius * ratio;
        
        Vertex2D moveVertex = new Vertex2D(0 ,previousRadius + currenntRadius);
        Vertex2D currentCenter = previousCenter.move(moveVertex);
        
        Circumcircle currentCircle = new Circle(currentCenter, currenntRadius);
        return currentCircle;
    }
    
    public Circumcircle[] getBalls() {
        return circles;
    }
}
