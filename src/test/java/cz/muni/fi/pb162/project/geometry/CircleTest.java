package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.helper.BasicRulesTester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests Circle class.
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
        BasicRulesTester.attributes2AndFinal(Circle.class);
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

    private void assertCircle(Circle expected, Circle actual) {
        assertTrue(expected.getRadius()        == actual.getRadius());
        assertTrue(expected.getCenter().getX() == actual.getCenter().getX());
        assertTrue(expected.getCenter().getY() == actual.getCenter().getY());
    }

    @Test
    public void toStringMessage() {
        assertEquals( "Circle: center=" + circle.getCenter() + ", radius=" + circle.getRadius(), circle.toString());
    }
}
