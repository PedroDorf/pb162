package cz.muni.fi.pb162.project.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests 2D square class.
 *
 * @author Marek Sabo
 */
public class SquareTest {

    private static final Vertex2D LEFT_BOTTOM = new Vertex2D(16, 12);
    private static final double EDGE_LEGTH = 10;
    private static final Vertex2D HALF_EDGE = new Vertex2D(EDGE_LEGTH / 2.0, EDGE_LEGTH / 2.0);
    private static final Vertex2D CENTER = LEFT_BOTTOM.move(HALF_EDGE);
    public static final double DELTA = 0.001;

    private final Square square1 = new Square(EDGE_LEGTH, LEFT_BOTTOM);
    private final Square square2 = new Square(CENTER, EDGE_LEGTH);


    @Test
    public void constructor1() {
        testGetterNull(square1);
        testGetters(square1);
    }

    @Test
    public void constructor2() {
        testGetterNull(square2);
        testGetters(square2);
    }

    public void testGetterNull(Square square) {
        assertNull(square.getVertex(-1));
        assertNull(square.getVertex(4));
        assertNull(square.getVertex(20));
    }


    private void testGetters(Square square) {
        leftBottom(square);
        rightBottom(square);
        rightTop(square);
        leftTop(square);
    }

    private void leftBottom(Square square) {
        assertEquals(LEFT_BOTTOM.toString(), square.getVertex(0).toString());
    }

    private void rightBottom(Square square) {
        Vertex2D rightBottom = LEFT_BOTTOM.move(new Vertex2D(EDGE_LEGTH, 0));
        assertEquals(rightBottom.toString(), square.getVertex(1).toString());
    }

    private void rightTop(Square square) {
        Vertex2D rightTop = LEFT_BOTTOM.move(new Vertex2D(EDGE_LEGTH, EDGE_LEGTH));
        assertEquals(rightTop.toString(), square.getVertex(2).toString());
    }

    private void leftTop(Square square) {
        Vertex2D leftTop = LEFT_BOTTOM.move(new Vertex2D(0, EDGE_LEGTH));
        assertEquals(leftTop.toString(), square.getVertex(3).toString());
    }

    @Test
    public void testCenter() {
        assertEquals(CENTER.toString(), square1.getCenter().toString());
        assertEquals(CENTER.toString(), square2.getCenter().toString());
    }


    @Test
    public void testRadius() {
        assertEquals(EDGE_LEGTH / Math.sqrt(2), square1.getRadius(), DELTA);
        assertEquals(EDGE_LEGTH / Math.sqrt(2), square2.getRadius(), DELTA);
    }

    @Test
    public void testGetEdgeLength() {
        assertEquals(EDGE_LEGTH , square1.getEdgeLength(), DELTA);
        assertEquals(EDGE_LEGTH , square2.getEdgeLength(), DELTA);
    }

}
