/*----------------------------------------------------------------
 *  File:         Subset.java
 *  Author:        Trey Bianchini
 *  Written:       3/02/2014
 *  Last Updated:  3/02/2014
 *
 *
 *----------------------------------------------------------------*/

/**
 * @author trey
 *
 */



public class Subset {


   public static void main(String[] args) {

       //StdOut.println(args.length);

       final String input[]=StdIn.readAllStrings();

       int count=new Integer(args[0]).intValue();
      RandomizedQueue<String> o = new RandomizedQueue<String>();

       for(int i=0;i<input.length;i++ ) {
         o.enqueue(input[i]);
       }
       while (o.iterator().hasNext() &&  --count >= 0) {
           StdOut.println(o.iterator().next());
       }



   }

}


