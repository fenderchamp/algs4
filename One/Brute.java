import java.util.Arrays;

/**
Brute force. Write a program Brute.java that examines 
4 points at a time and checks whether they all lie 
on the same line segment, printing out any such line 
segments to standard output and drawing them using 
standard drawing. To check whether the 4 points 
p, q, r, and s are collinear, check whether the 
slopes between p and q, between p and r, and between p and s are all equal.
*/

public class Brute {

   private static void drawline( Point p, Point q, Point r,
           Point s) {

      /*StdOut.printf("-(%d,%d)-",p.x,p.y);
      StdOut.printf("-(%d,%d)-",q.x,q.y);
      StdOut.printf("-(%d,%d)-",r.x,r.y);
      StdOut.printf("-(%d,%d)-\n",s.x,s.y);
      */
      Point ar[] = new Point[4]; 
      ar[0] = p;
      ar[1] = q;
      ar[2] = r;
      ar[3] = s;
      Arrays.sort(ar);

      ar[0].draw();
      ar[1].draw();
      ar[2].draw();
      ar[3].draw();
      StdOut.printf("\n");

      ar[0].drawTo(ar[3]);
   }
   private static boolean collinear( Point p, Point q, Point r,
           Point s) {
       double qSlope = p.slopeTo(q);
       double rSlope = p.slopeTo(r);
       double sSlope = p.slopeTo(s);

       if ( qSlope == sSlope && qSlope == rSlope &&
               qSlope == sSlope  ) {
           return true;
       }

       return false;
   }


   public static void main(final String[] args) {

       In input_file = new In(args[0]);      // input file
       int N = input_file.readInt();         // number of points to expect.

       Point p[] = new Point[N];
       int coordinates[] = input_file.readAllInts();
       int count = 0;
       StdDraw.setXscale(0, 32768); 
       StdDraw.setYscale(0, 32768); 
       for (int i = 0; i < (N * 2) ; i+=2) {
           p[count++] = new Point( coordinates[i], coordinates[i+1]);
       }
       for (int i = 0; i < (N - 3); i++) {
           StdOut.println(i);
           for (int j = (i + 1); j < (N - 2); j++) {
               for (int k = (j + 1); k < (N - 1); k++) {
                   for (int l = (k + 1); l < N; l++) {
                      if ( collinear( p[i],p[j],p[k],p[l] ) ) {
           StdOut.printf("%d,%d,%d,%d\n",i,j,k,l);
                         drawline( p[i],p[j],p[k],p[l] );
                      }
                   }
               }
           }
       }

       StdOut.println("Done");

       // turn on animation mode
       //StdDraw.show(0);

       // repeatedly read in sites to open and draw resulting system
       /*
       draw(perc, N);
       StdDraw.show(DELAY);
       while (!in.isEmpty()) {
           int i = in.readInt();
           int j = in.readInt();
           perc.open(i, j);
           draw(perc, N);
           StdDraw.show(DELAY);
       }
       */
   }
}

