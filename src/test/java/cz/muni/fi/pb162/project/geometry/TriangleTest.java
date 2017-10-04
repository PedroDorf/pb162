package cz.muni.fi.pb162.project.geometry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Class testing Triangle implementation.
 *
 * @author Marek Sabo
 */
public class TriangleTest {

    private Triangle triangle;

    private final Vertex2D vertex1 = Vertex2DTest.createVertex(-100, -100);
    private final Vertex2D vertex2 = Vertex2DTest.createVertex(100, 100);
    private final Vertex2D vertex3 = Vertex2DTest.createVertex(0, 0);

    @Before
    public void setUp() {
        triangle = createTriangle(vertex1, vertex2, vertex3);
    }

    private Triangle createTriangle(Vertex2D v1, Vertex2D v2, Vertex2D v3) {
        Triangle t = new Triangle();
        t.setVertex(0, v1);
        t.setVertex(1, v2);
        t.setVertex(2, v3);
        return t;
    }

    @Test
    public void gettersInRange() {
        assertTriangle(triangle, createTriangle(vertex1, vertex2, vertex3));
    }

    @Test
    public void gettersOutOfRange() {
        assertNull(triangle.getVertex(3));
        assertNull(triangle.getVertex(4));
        assertNull(triangle.getVertex(-1));
    }

    @Test
    public void settersOutOfRange() {
        triangle.setVertex(3, null);
        triangle.setVertex(-1, null);
        assertNotNull(triangle.getVertex(0));
        assertNotNull(triangle.getVertex(1));
        assertNotNull(triangle.getVertex(2));
    }

    @Test
    public void toStringMessage() {
        assertEquals("Triangle: vertices=[-100.0, -100.0] [100.0, 100.0] [0.0, 0.0]", triangle.toString());

        Triangle t = createTriangle(
                Vertex2DTest.createVertex(-1.2, 0.0),
                Vertex2DTest.createVertex(1.2, 0.0),
                Vertex2DTest.createVertex(0.0, 2.07846097)
        );
        assertEquals("Triangle: vertices=[-1.2, 0.0] [1.2, 0.0] [0.0, 2.07846097]", t.toString());
    }


    @Test
    public void checkIfDivided() {
        assertFalse(triangle.isDivided());
        assertTrue(triangle.divide());
        assertTrue(triangle.isDivided());
        assertFalse(triangle.divide());
    }

    @Test
    public void subTriangleGettersNull() {
        assertNull(triangle.getSubTriangle(-1));
        assertNull(triangle.getSubTriangle(0));
        assertNull(triangle.getSubTriangle(1));
        assertNull(triangle.getSubTriangle(2));
        assertNull(triangle.getSubTriangle(3));
    }

    @Test
    public void subTriangleGettersInRangeNotNull() {
        triangle.divide();
        assertNotNull(triangle.getSubTriangle(0));
        assertNotNull(triangle.getSubTriangle(1));
        assertNotNull(triangle.getSubTriangle(2));
    }

    @Test
    public void subTriangleGettersOutOfRangeNull() {
        triangle.divide();
        assertNull(triangle.getSubTriangle(-1));
    }

    @Test
    public void division() {
        triangle.divide();

        assertTriangle(triangle.getSubTriangle(0),
                createTriangle(
                        Vertex2DTest.createVertex(-100.0, -100.0),
                        Vertex2DTest.createVertex(0.0, 0.0),
                        Vertex2DTest.createVertex(-50.0, -50.0)
                )
        );
        assertTriangle(triangle.getSubTriangle(1),
                createTriangle(
                        Vertex2DTest.createVertex(100.0, 100.0),
                        Vertex2DTest.createVertex(0.0, 0.0),
                        Vertex2DTest.createVertex(50.0, 50.0)
                )
        );
        assertTriangle(triangle.getSubTriangle(2),
                createTriangle(
                        Vertex2DTest.createVertex(0.0, 0.0),
                        Vertex2DTest.createVertex(-50.0, -50.0),
                        Vertex2DTest.createVertex(50.0, 50.0)
                        )
        );
    }

    private void assertTriangle(Triangle expected, Triangle actual) {
        verticesAreSame(expected.getVertex(0), actual.getVertex(0));
        verticesAreSame(expected.getVertex(1), actual.getVertex(1));
        verticesAreSame(expected.getVertex(2), actual.getVertex(2));
    }

    private void verticesAreSame(Vertex2D expected, Vertex2D actual) {
        assertTrue(expected.getX() == actual.getX());
        assertTrue(expected.getY() == actual.getY());
    }


}
