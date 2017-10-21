package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Circumcircle;
import cz.muni.fi.pb162.project.geometry.Snowman;
import cz.muni.fi.pb162.project.geometry.Square;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;

/**
 * Class drawing 2D objects.
 *
 * @author Radek Oslejsek, Marek Sabo
 */
public final class Draw extends JFrame {

    private static final Color SQUARE_COLOR = Color.GREEN;
    private static final Color CIRCLE_COLOR = Color.RED;

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 660;
    private static final int HALF_WIDTH = PANEL_WIDTH / 2;
    private static final int HALF_HEIGHT = PANEL_HEIGHT / 2;

    private Graphics graphics;

    private static final Square SQUARE = new Square(160, new Vertex2D(-80,-250));
    private static final Circle BOTTOM_BALL = new Circle(SQUARE.getCenter(), SQUARE.getRadius());
    private static final Snowman SNOWMAN = new Snowman(BOTTOM_BALL, 0.7);

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
        paintSquare(SQUARE);
        System.out.println(Arrays.toString(SNOWMAN.getBalls()));
        paintSnowman(SNOWMAN);
    }

    private void paintCross() {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawLine(0, HALF_HEIGHT, PANEL_WIDTH, HALF_HEIGHT);
        graphics.drawLine(HALF_WIDTH, 0, HALF_WIDTH, PANEL_HEIGHT);
    }

    private void paintSquare(Square square) {

        if (square == null) return;

        graphics.setColor(SQUARE_COLOR);
        Polygon polygon = new Polygon();

        for (int i = 0; i <= 3; i++) {
            Pair<Integer, Integer> pair = createLinePoints(square, i);
            polygon.addPoint(pair.getLeft(), pair.getRight());
        }

        graphics.drawPolygon(polygon);
    }

    private Pair<Integer, Integer> createLinePoints(Square square, int index) {
        int a1 = PANEL_WIDTH - ((int) Math.rint(HALF_WIDTH - square.getVertex(index).getX()));
        int a2 = (int) Math.rint(HALF_HEIGHT - square.getVertex(index).getY());
        return new Pair<>(a1, a2);
    }

    private void paintSnowman(Snowman snowman) {
        for(Circumcircle c : snowman.getBalls()) {
            paintCircumcircle(c);
        }
    }

    private void paintCircumcircle(Circumcircle c) {

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
