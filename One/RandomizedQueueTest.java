import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RandomizedQueueTest {

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

      int[] deck = new int[10];
      RandomizedQueue<Integer> o = new RandomizedQueue<Integer>();
      for (int i = 0; i < 10; i++ )  {
          o.enqueue(i);
      }
      int c = 0;
      while ( o.iterator().hasNext() ) {
           int i = o.iterator().next();
           deck[c++] = i;
      }
    }

}
