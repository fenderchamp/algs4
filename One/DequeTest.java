import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DequeTest {

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
        Deque<String> d=makeObject();
        testThrows(d);
        addRemoveFirst();
        addRemoveLast();
        addRemoveOne();
    }
    private void addRemoveLast() {
        Deque<String> d=makeObject();
        int s=d.size();
        d.addLast("a");
        assertEquals("objectInceremented",(s + 1),d.size());
        String i = d.removeLast();
        assertEquals("string popped",s,d.size());
        assertEquals("string a",i,"a");
        assertEquals("empty a",true,d.isEmpty());
        assertEquals("0 a",0,d.size());
        d.addLast("a");
        d.addLast("a");
        d.addLast("a");
        assertEquals("empty false",false,d.isEmpty());
        assertEquals("3 a",3,d.size());
        i = d.removeLast();
        i = d.removeLast();
        i = d.removeLast();
        assertEquals("empty a",true,d.isEmpty());
        assertEquals("0 a",0,d.size());



    } 

    private void addRemoveOne() {

        Deque<String> d=makeObject();
        int s=d.size();
        d.addFirst("a");
        d.addFirst("b");
        d.addFirst("c");
        d.addFirst("d");
        d.addFirst("e");

        assertEquals("objectInceremented",5,d.size());
        String i = (String)d.removeLast();
        assertEquals("string popped",4,d.size());
        assertEquals("string a","a",i);
        i = (String)d.removeFirst();
        assertEquals("string e","e",i);
        assertEquals("string popped",3,d.size());
    }
    private void addRemoveFirst() {
        Deque<String> d=makeObject();
        int s=d.size();
        d.addFirst("a");
        assertEquals("objectInceremented",(s + 1),d.size());
        String i = d.removeFirst();
        assertEquals("string popped",s,d.size());
        assertEquals("string a",i,"a");

        d.addFirst("a");
        d.addFirst("b");
        assertEquals("objectInceremented",2,d.size());
        i = d.removeFirst();
        assertEquals("string popped",1,d.size());
        assertEquals("string b","b",i);
        i = d.removeFirst();
        assertEquals("string popped",0,d.size());
        assertEquals("string b","a",i);

        d.addFirst("a");
        d.addFirst("b");
        assertEquals("objectInceremented",2,d.size());
        i = d.removeFirst();
        assertEquals("string popped",1,d.size());
        assertEquals("string b","b",i);
        i = d.removeFirst();
        assertEquals("string popped",0,d.size());
        assertEquals("string b","a",i);
         
     }
    private Deque makeObject() {
        Deque<String> d=new Deque<String>();
        String v=d.toString();
        assertNotNull("d object created",d);
        assertEquals("no size", 0,d.size());
        return(d);
    }

    private void testThrows(Deque<String> d) {
        try {
            d.addFirst(null);
            fail( "My method didn't throw when I expected it to" );
        } catch (java.lang.NullPointerException expectedException) {
            assertNotNull("addFirst threw exception", expectedException);
        }

        try {
            d.addLast(null);
            fail( "My method didn't throw when I expected it to" );
        } catch (java.lang.NullPointerException expectedException) {
            assertNotNull("addFirst threw exception", expectedException);
        }

        try {
            String b = d.removeFirst();
            fail( "My method didn't throw when I expected it to" );
        } catch (java.util.NoSuchElementException expectedException) {
            assertNotNull("removeFirst threw exception", expectedException);
        }

        try {
            String b = d.removeLast();
            fail( "My method didn't throw when I expected it to" ); } catch (java.util.NoSuchElementException expectedException) {
            assertNotNull("removeFirst threw exception", expectedException);
        }
 

    }

}
