import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinkedStackTest {

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
        fail("Not yet implemented");
        LinkedStack b = makeObject();
        
    }
    private LinkedStack makeObject() {
        LinkedStack<String> d=new LinkedStack<String>();
        String v=d.toString();
        assertNotNull("d object created",d);
        assertEquals("no size", 0,d.size());
        return(d);
    }

}
