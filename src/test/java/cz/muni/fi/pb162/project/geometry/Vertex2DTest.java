package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.helper.BasicRulesTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Simple Vertex2D tests.
 *
 * @author Marek Sabo
 */
public class Vertex2DTest {

    private Vertex2D vertex2D;

    private static final double X = -1.2;
    private static final double Y = 2.4;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        vertex2D = new Vertex2D(X, Y);
    }

    @Test
    public void attributes2AndFinal() {
        BasicRulesTester.attributes2AndFinal(Vertex2D.class);
    }

    @Test
    public void testDistancePositiveInput() {
        double distance = new Vertex2D(-1.2, 1.2).distance(new Vertex2D(1.3, 1.3));
        assertTrue(distance > 2.5 && distance < 2.503);
    }

    @Test
    public void testDistanceNegativeInput() {
        try {
            assertTrue(vertex2D.distance(null) == -1.0);
        } catch (Exception e) {
            fail("Should return -1 as indicator of wrong input");
        }
    }

        @Test
    public void testSumCoordinates() {
        assertEquals(X + Y, vertex2D.sumCoordinates(), DELTA);
    }

    @Test
    public void testMoveVertex() {
        final double XX = -3.3;
        final double YY = -5.5;
        Vertex2D negativeVertex = new Vertex2D(XX, YY);

        Vertex2D resultVertex = vertex2D.move(negativeVertex);

        assertEquals(XX + X, resultVertex.getX(), DELTA);
        assertEquals(YY + Y, resultVertex.getY(), DELTA);

        assertEquals(XX, negativeVertex.getX(), DELTA);
        assertEquals(YY, negativeVertex.getY(), DELTA);
    }

    @Test
    public void toStringMessage() {
        assertEquals("[" + X + ", " + Y + "]", vertex2D.toString());
    }

    @Test
    public void testGetters() {
        Vertex2D v = new Vertex2D(-1.234, 1.234);
        assertTrue(v.getX() == -1.234);
        assertTrue(v.getY() == 1.234);
    }

}
