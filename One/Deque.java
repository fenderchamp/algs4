import java.util.Iterator;
import java.util.NoSuchElementException;

    /**
     * @author trey
     *
     * @param <Item>
     */

   public class Deque<Item> implements Iterable<Item> {

        private Node first;   //first node  in the list
        private Node last;    //last node in the list 
        private int N;        //count N of items

        /**
         * Node linked list will be composed of Node Objects.
         * @author trey
         *
         * @param <Item>
         *
         */
        private class Node {
            private Item item;
            private Node next;
            private Node prev;
        }

        /**
         * construct new deque.
         */
        public Deque() {
            first = null;
            last = null;
            N = 0;
        }

        /**
         * is the deque empty?
         * @return boolean
         */
        public boolean isEmpty() {
            return (N == 0);
        }

        /** return the number of items on the deque.
         * @return N
         */
        public int size() {
            return N;
        }

        /** insert the item at the front.
         * @param item to add to the Deque
         */
        public void addFirst(Item item) {
            checkAdd(item);
            Node old = null;
            if (first != null) {
               old = first;
            }
            first = new Node();
            first.item = item;
            if (old != null) {
                first.next = old;
                old.prev = first;
            }
            if (N == 0) {
                last = first;
            }
            N++;

        }
        // insert the item at the end
        public void addLast(Item item) {
            checkAdd(item);
            Node old = null;
            if (last != null) {
               old = last;
            }
            last = new Node();
            last.item = item;
            if (old != null) {
                old.next = last;
                last.prev = old;
            }
            if (N == 0) {
                first = last;
            }
            N++;
        }

        /** delete and return the item at the front.
         * @return
         */

        public Item removeFirst() {

          if (isEmpty()) {
                throw new
                   java.util.NoSuchElementException(
                           "can't remove last item of empty queue");
           }
           Item i = first.item;
           N--;
           if (first.next != null) {
              first = first.next;
           }
           return i;
       }

        /** delete and return the item at the end.
         * @return
         */
        public Item removeLast() {
          if (isEmpty()) {
                throw new
                   java.util.NoSuchElementException(
                        "can't remove last item for empty queue");
           }
           Item i = last.item;
           N--;
           if (last.prev != null) {
                last.prev.next = null;
                last = last.prev;
           }
           return i;

        }
        /** 
         * throw if null item provided to an add method
         * @param item
         */
        private void checkAdd(Item item) {
            if ( item == null ) {
                throw  new java.lang.NullPointerException("add value must not null");
            }

        }

      /**
       * Returns an iterator to this stack that iterates through the items in LIFO order.
       * @return an iterator to this stack that iterates through the items in LIFO order.
       */
      public Iterator<Item> iterator()  { return new ListIterator();  }

      // an iterator, doesn't implement remove() since it's optional
      private class ListIterator implements Iterator<Item> {
          private Node current = first;
          public boolean hasNext()  { return current != null;                     }
          public void remove()      { throw new UnsupportedOperationException();  }

          public Item next() {
              if (!hasNext()) throw new NoSuchElementException();
              Item item = current.item;
              current = current.next;
              return item;
          }
      }
      public static void main(String[] args) {
          Deque<String> d = new Deque<String>();
      }

   }

    /*
    hrow a NullPointerException if the client attempts to add a null item; 
    throw a java.util.NoSuchElementException if the client attempts to remove 
    an item from an empty deque; throw an UnsupportedOperationException if the 
    client calls the remove() method in the iterator; 
    throw a java.util.NoSuchElementException if the client calls the next() 
    method in the iterator and there are no more items to return.
    */