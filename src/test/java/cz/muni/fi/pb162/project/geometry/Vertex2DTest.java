package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.helper.BasicRulesTester;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Simple Vertex2D tests.
 * @author Marek Sabo
 */
public class Vertex2DTest {

    private Vertex2D vertex2D;

    private static final double X = -1.2;
    private static final double Y = 2.4;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        vertex2D = createVertex(X, Y);
    }

    static Vertex2D createVertex(double x, double y) {
        Vertex2D v = new Vertex2D();
        v.setX(x);
        v.setY(y);
        return v;
    }

    @Test
    public void testNumberAndAttributeTypes() {
        Field[] attributes = BasicRulesTester.getFields(Vertex2D.class);
        assertEquals("Different number of attributes than expected", 2, attributes.length);
        for (Field field : attributes) {
            assertEquals("Attribute type is not double", Double.TYPE, field.getType());
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
        Vertex2D negativeVertex = createVertex(XX, YY);

        vertex2D.move(negativeVertex);

        assertEquals(XX + X, vertex2D.getX(), DELTA);
        assertEquals(YY + Y, vertex2D.getY(), DELTA);

        assertEquals(XX, negativeVertex.getX(), DELTA);
        assertEquals(YY, negativeVertex.getY(), DELTA);
    }

    @Test
    public void toStringMessage() {
        assertEquals("[" + X + ", " + Y + "]", vertex2D.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Vertex2D v = new Vertex2D();
        v.setX(-1.234);
        v.setY(1.234);
        assertTrue(v.getX() == -1.234);
        assertTrue(v.getY() == 1.234);
    }

}
