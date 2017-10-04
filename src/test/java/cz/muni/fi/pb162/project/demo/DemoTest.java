package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.helper.BasicRulesTester;
import cz.muni.fi.pb162.project.helper.OutputTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing print output of Demo class.
 * @author Marek Sabo
 */
public class DemoTest {

    private static final String EXPECTED_OUTPUT = "Triangle: vertices=[-100.0, 0.0] [0.0, 100.0] [100.0, -100.0]";

    @Test
    public void testMainOutput() {
        BasicRulesTester.testRunnableClass(Demo.class);
        assertEquals(EXPECTED_OUTPUT, actualOutput());
    }

    @SuppressWarnings("AccessStaticViaInstance")
    private String actualOutput() {
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        new Demo().main(null);
        ot.releaseOutput();
        return ot.getTrimmedOutput();
    }

}
