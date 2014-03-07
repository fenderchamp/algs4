/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *


 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER;
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    /** create the point (x, y).
     * @param x coordinate of this point
     * @param y coordinate  of this point
     */
    public Point(int x, int y) {

        this.SLOPE_ORDER =
                new Comparator<Point>() {
            public int compare(final Point one, final Point two) {
                double sOne = slopeTo(one);
                double sTwo = slopeTo(two);
                if (sOne == sTwo) {
                    return 0;
                } else if (sOne < sTwo) {
                    return -1;
                }
                return 1;
            }
        };

        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * plot this point to standard drawing.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdOut.printf("-(%d,%d)-",this.x,this.y);
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
        The slopeTo() method should return the slope between the
        invoking point (x0, y0) and the argument point (x1, y1).
        which is given by the formula (y1 - y0) / (x1 - x0).
        Treat the slope of a horizontal line segment as positive zero.
        treat the slope of a vertical line segment as positive infinity.
        treat the slope of a degenerate line segment
        (between a point and itself) as negative infinity.
     * @param that a Point
     * @return double the slope
     */
    public double slopeTo(Point that) {

        if (0 == this.compareTo(that)) {
            return Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return new Double(0.0).doubleValue();
        }  else {

            double slope=new Double((new Double(that.y) - new Double(this.y)) / (new Double(that.x) - new Double(this.x))).doubleValue();
            //StdOut.println(slope);
            return slope;
        }

    }

    /* 
     * is this point lexicographically smaller than that one?
     * comparing y-coordinates and breaking ties by x-coordinates.
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Point that) {
        if (this.y == that.y) {
            if (this.x == that.x) {
                return 0;
            } else if  (this.x < that.x) {
                return -1;
            }
        } else if (this.y < that.y) {
            return -1;
        }
        return 1;


    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }




    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
