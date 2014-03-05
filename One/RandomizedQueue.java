import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author trey
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    /** array of items.
     *
     */
    private Item[] a;

    /** number of elements on stack
     *
     */
    private int N;

    /** construct an empty randomized queue.
     * 
     */
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
    }

    /** is the queue empty?
     * @return
     */
    public boolean isEmpty() {                 
       return ( N == 0 );
    }

    /** return the number of items on the queue.
     * @return
     */
    public int size()    { 
       return N; 
    }
 // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**add the item.
     * @param item
     */
    public void enqueue(Item item)  {
        if (N == a.length) resize(2 * a.length);    // double size of array if necessary
        a[N++] = item;                            // add item
    }

    /** delete and return a random item.
     * @param item
     */
    public Item dequeue() {                    
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack underflow");
        int position = -1;
        position=StdRandom.uniform(0,N);
        Item item = a[position];
        a[position]=a[N - 1];
        a[N - 1] = null;                              // to avoid loitering
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }


    // return (but do not delete) a random item
    public Item sample() {                     
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack underflow");
        int position = -1;
        position=StdRandom.uniform(0, N);
        Item item = a[position];
        return item;
    }


    /*
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {        

    }
    */
    public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        public boolean hasNext()  { return ! isEmpty(); };
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return dequeue();
        }
    }


    // unit testing
    public static void main(String[] args) {
    }
}

/*
 Throw a NullPointerException if the client attempts to add a null item; 
 throw a java.util.NoSuchElementException if the client attempts to sample or 
 dequeue an item from an empty randomized queue; throw an UnsupportedOperationException 
 if the client calls the remove() method in the iterator; 
 throw a java.util.NoSuchElementException if the client calls the 
 next() method in the iterator and there are no more items to return.

 Your randomized queue implementation must support each randomized queue 
 operation (besides creating an iterator) in constant amortized time and use 
 space proportional to the number of items currently in the queue. That is, 
 any sequence of M randomized queue operations (starting from an empty queue) 
 should take at most cM steps in the worst case, for some constant c. Additionally, 
 your iterator implementation must support construction in time linear in the number 
 of items and it must support the operations next() and hasNext() in 
 constant worst-case time; you may use a linear amount of extra memory per iterator. 
 The order of two or more iterators to the same randomized queue should be mutually independent;
  each iterator must maintain its own random order.
*/


