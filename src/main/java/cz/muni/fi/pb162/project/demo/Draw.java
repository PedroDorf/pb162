package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Class drawing 2D objects.
 *
 * @author Radek Oslejsek, Marek Sabo
 */
public final class Draw extends JFrame {

    private static final Color TRIANGLE_COLOR = Color.BLUE;
    private static final Color CIRCLE_COLOR = Color.RED;

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 660;
    private static final int HALF_WIDTH = PANEL_WIDTH / 2;
    private static final int HALF_HEIGHT = PANEL_HEIGHT / 2;

    private Graphics graphics;

    private static final int TRIANGLE_DEPTH = 4;
    private static final Triangle DIVIDED_TRIANGLE = createDividedTriangle();
    private static final Circle CIRCLE = new Circle(new Vertex2D(0,0), 290);

    private static Triangle createDividedTriangle() {

        Vertex2D v1 = new Vertex2D(-200, -200);
        Vertex2D v2 = new Vertex2D(0, 200);
        Vertex2D v3 = new Vertex2D(200, -200);

        Triangle triangle = new Triangle(v1, v2, v3);

        triangle.divide(TRIANGLE_DEPTH);

        return triangle;
    }

    /**
     * Draws 2D objects.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Draw demo = new Draw();
        demo.startPainting();
    }

    private Draw() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        setBounds(350, 250, PANEL_WIDTH, PANEL_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw");
        add(panel);
        setVisible(true);
    }

    private void startPainting() {
        paint(this.getGraphics());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphics = g;

        paintCross();
        paintCircle(CIRCLE);
        paintTriangle(DIVIDED_TRIANGLE);
        paintSubTrianglesRecursively(DIVIDED_TRIANGLE);
    }

    private void paintCross() {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawLine(0, HALF_HEIGHT, PANEL_WIDTH, HALF_HEIGHT);
        graphics.drawLine(HALF_WIDTH, 0, HALF_WIDTH, PANEL_HEIGHT);
    }

    private void paintSubTrianglesRecursively(Triangle triangle) {
        for (int i = 0; i < 3; i++) {
            Triangle subTriangle = triangle.getSubTriangle(i);
            paintTriangle(subTriangle);
            if (subTriangle.isDivided()) paintSubTrianglesRecursively(subTriangle);
        }
    }

    private void paintTriangle(Triangle triangle) {

        if (triangle == null) return;

        graphics.setColor(TRIANGLE_COLOR);
        Polygon polygon = new Polygon();

        for (int i = 0; i <= 2; i++) {
            Pair<Integer, Integer> pair = createTriangleLinePoints(triangle, i);
            polygon.addPoint(pair.getLeft(), pair.getRight());
        }

        graphics.drawPolygon(polygon);
    }

    private Pair<Integer, Integer> createTriangleLinePoints(Triangle triangle, int index) {
        int a1 = PANEL_WIDTH - ((int) Math.rint(HALF_WIDTH - triangle.getVertex(index).getX()));
        int a2 = (int) Math.rint(HALF_HEIGHT - triangle.getVertex(index).getY());
        return new Pair<>(a1, a2);
    }

    protected void paintCircle(Circle c) {

        int radius = (int) Math.rint(c.getRadius());
        int x = PANEL_WIDTH - ((int) Math.rint(HALF_WIDTH - c.getCenter().getX()) + radius);
        int y = (int) Math.rint(HALF_HEIGHT - c.getCenter().getY()) - radius;
        int diameter = (int) Math.rint(c.getRadius() * 2.0);

        graphics.setColor(CIRCLE_COLOR);
        graphics.drawOval(x, y, diameter, diameter);
    }

    private class Pair<L, R> {

        private final L left;
        private final R right;

        Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        L getLeft() {
            return left;
        }

        R getRight() {
            return right;
        }
    }
}
