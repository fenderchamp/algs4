/*----------------------------------------------------------------
 *  File:         Percolation.java
 *  Author:        Trey Bianchini
 *  Written:       2/24/2014
 *  Last Updated:  2/24/2014
 *
 *  Implements the Precolation API for class
 *
 *
 *----------------------------------------------------------------*/

/**
 * @author trey
 *
 */
public class Percolation {
    private static final int EXTRA_CELLS = 1; // constant for extra cell on
                                             // arrays for 1 based indexing
    private static final int VIRTUAL_CAP_SIZE = 2; // constant for virtual
                                                  // top/bottom space on th
    private WeightedQuickUnionUF objUnion; // union object with virtual top and
                                           // bottom
    private WeightedQuickUnionUF isFullUnion; // union object with virtual top
                                              // and bottom
    private boolean[][] grid; // array to track open and closed sites
    private int count; // number of sites in N * N square grid
    private int side; // number of sites on the edge of the square
    private int virtualTop; // integer value of the virtual top
    private int virtualBottom; // integer value of the virtual bottom;


    /**
     * @param n
     *            // constructor; // create N-by-N grid, with all sites blocked
     *            // and the union objects for processing connections // and
     *            define virtual top and bottom
     */
    public Percolation(int n) {
        count = n * n;
        side = n;
        virtualTop = 0;
        virtualBottom = count + 1;
        objUnion =    new WeightedQuickUnionUF(count + VIRTUAL_CAP_SIZE);
        isFullUnion = new WeightedQuickUnionUF(count + VIRTUAL_CAP_SIZE);
        grid = initializeGrid();
    }

    /**
     * @return array
     */
    private boolean[][] initializeGrid() {
        int  arraySize = side + EXTRA_CELLS; // ignore the zeros so pad
                                             // with extra space
        grid = new boolean[arraySize] [arraySize];
        for (int row = 0; row < arraySize; row++) {
            for (int column = 0; column < arraySize; column++) {
                grid[row][column] = false;
            }
        }
        return grid;
    }

    /**
     * open site (row , column ) if it is not already open.
     * @param row
     * @param column
     */
    public void  open(int row, int column) {
        checkInput(row);
        checkInput(column);

        grid[row][column] = true;

        connectNeighbor(row, column, new String("upper"));
        connectNeighbor(row, column, new String("lower"));
        connectNeighbor(row, column, new String("left"));
        connectNeighbor(row, column, new String("right"));

    }

    /**
     * @param row row to check
     * @param column column to check
     * @return boolean
     * is site (row i, column j) open.
    */
    public boolean isOpen(int row, int column) {
        checkInput(row);
        checkInput(column);
        return grid[row][column];

    }

    /**
     * @param row row to checxk
     * @param column column to check
     * @return // is site (row i, column j) full connected to the top row?
     */
    public boolean isFull(int row, int column) {
        checkInput(row);
        checkInput(column);
        int requestedSite = twoDSubscript(row, column);
        return isFullUnion.connected(requestedSite, virtualTop);
    }

    /**
     * does the system percolate.
     * @return boolean
     */
    public boolean percolates() {
        return objUnion.connected(virtualBottom, virtualTop);
    }

    /**
     * connect the the site to upper lower left or right neighbor
     * site if it's open.
     * @param row row to check
     * @param column column to check
     * @param pos position of neighbor upper,lower,left or right
     */
    private void connectNeighbor(
            final int row, final int column, final String pos) {
        int nextRow = 0;
        int nextColumn = 0;
        int adjacentSite = -1;
        boolean skipFull = false;

        if (pos.matches("upper")) {
            if (row == 1) {
                adjacentSite = virtualTop;
            } else {
                nextRow = row - 1;
                nextColumn = column;
            }
        } else if (pos.matches("lower")) {
            if (row == side) {
                adjacentSite = virtualBottom;
                skipFull = true;
            } else {
                nextRow = row + 1;
                nextColumn = column;
            }
        } else if (pos.matches("left")) {
            if (column > 1) {
                nextColumn = column - 1;
                nextRow = row;
            }
        } else if (pos.matches("right")) {
            if (column < side) {
                nextColumn = column + 1;
                nextRow = row;
            }
        }

        if (nextRow > 0 && nextColumn > 0 && isOpen(nextRow, nextColumn)) {
            adjacentSite = twoDSubscript(nextRow, nextColumn);
        }

        if (adjacentSite > -1) {
            int requestedSite = twoDSubscript(row, column);
            objUnion.union(requestedSite, adjacentSite);
            if (!skipFull) {
                isFullUnion.union(requestedSite, adjacentSite);
            }
            objUnion.union(requestedSite, adjacentSite);
        }

    }

    /**
     * convert row/column site to the subscript used by the 1 dim union objects.
     * @param row row to convert
     * @param column to convert
     * @return int
     */
    private int twoDSubscript(final int row, final int column) {

        int u; // new subscript
        u = ((row - 1) * side);
        u += column;
        return (u);
    }
    /**
     * @param i integer to validate
     */
    private void checkInput(final int i) {
        if (i < 1 || i > side) {
            throw new IndexOutOfBoundsException("row index i out of bounds:"
                    + i);
        }
    }
}
