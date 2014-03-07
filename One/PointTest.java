import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PointTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Point p = new Point(4,5);
        Point q = new Point(1,3);
        assertEquals("compareTo", 1, p.compareTo(q));
        assertEquals("slopeTo", new Double(2/3).doubleValue(), p.slopeTo(q),1);

    }

}
