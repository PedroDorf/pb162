package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.helper.BasicRulesTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests Circle class.
 *
 * @author Marek Sabo
 */
public class CircleTest {

    private static final Vertex2D CENTER = new Vertex2D(2, 1);
    private static final double RADIUS = 2.5;
    private Circle circle;

    @Before
    public void setUp() {
        circle = new Circle(CENTER, RADIUS);
    }

    @Test
    public void attributes2AndFinal() {
        BasicRulesTester.attributesFinal(Circle.class);
    }

    @Test
    public void getters() {
        assertTrue(circle.getRadius() == RADIUS);
        assertTrue(circle.getCenter().getX() == CENTER.getX());
        assertTrue(circle.getCenter().getY() == CENTER.getY());
    }

    @Test
    public void constructorWithoutParameters() {
        assertCircle(new Circle(), new Circle(new Vertex2D(0, 0), 1));
    }

    public static void assertCircle(Circumcircle expected, Circumcircle actual) {
        double DELTA = 0.001;
        assertEquals(expected.getRadius(), actual.getRadius(), DELTA);
        assertEquals(expected.getCenter().getX(), actual.getCenter().getX(), DELTA);
        assertEquals(expected.getCenter().getY(), actual.getCenter().getY(), DELTA);
    }

    @Test
    public void toStringMessage() {
        assertEquals("Circle: center=" + circle.getCenter() + ", radius=" + circle.getRadius(), circle.toString());
    }

    @Test
    public void testWidthAndHeight() {
        assertEquals(circle.getWidth(), 2 * RADIUS, 0);
        assertEquals(circle.getHeight(), 2 * RADIUS, 0);
    }
}
