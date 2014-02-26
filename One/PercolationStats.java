
/*----------------------------------------------------------------
 *  File:         PercolationStats.java
 *  Author:        Trey Bianchini
 *  Written:       2/24/2014
 *  Last Updated:  2/24/2014
 *
 *  Implements the PrecolationStats API for class
 *
 *
 */

/**
 * @author trey
 *
 */
public class PercolationStats {

    private static final int ARRAY_PAD = 1; 
    //pad for to account for extra space in arrays
    private static final double POS = 1.96; //point of significance
    private int count;                      //number of sites in the grid
    private double [] runs;                 //threshold of each trial

    /**
     * fills in the a grid and opens random connections.
     * @param gridSize size of grid
     * @param repetitions times to run
     * runs trials until it grid percolates stores how many times it takes.
     */
    public PercolationStats(final int gridSize, final int repetitions) {

        if (gridSize <= 0 || repetitions <= 0) {
            throw new java.lang.IllegalArgumentException(
                "gridsize or repitions count is less than 0");
        }
        count = gridSize * gridSize;
        runs = new double[repetitions];
        for (int i = 0; i < repetitions; i++) {
            //StdOut.print(i+"\n");
            final boolean [][] open = initializeGrid(gridSize);
            final Percolation oPercolation = new Percolation(gridSize);
            int opened = 0;
            while (!oPercolation.percolates()) {
                final int row =    StdRandom.uniform(1, gridSize + ARRAY_PAD);
                final int column = StdRandom.uniform(1, gridSize + ARRAY_PAD);
                if (!open[row][column]) {
                    open[row][column] = true;
                    oPercolation.open(row, column);
                    opened++;
                }
            }
            runs[i] = (double) opened / count;
        }
    };

    /**
     * @return mean average of percolation threshold
     */
    public final double mean() {
        return StdStats.mean(runs);
    };
    /**
    * @return sample standard deviation of percolation threshold
    */
    public final double stddev() {
        return StdStats.stddev(runs);
    };
    /**
     * @return returns lower bound of the 95% confidence interval
    */
    public final double confidenceLo() {
        return mean() - ((POS * stddev()) / (Math.sqrt(runs.length)));
    };
    /**
     * @return upper bound of the 95% confidence interval
     */
    public final double confidenceHi() {
        return mean() + ((POS * stddev()) / (Math.sqrt(runs.length)));
    };
    /**
     * @param gridSize size of grid
     * @return initializes grid
     */
    private boolean[][] initializeGrid(final int gridSize) {
        final int arraySize = gridSize + ARRAY_PAD; // ignore the zeros so pad
        final boolean[][] grid = new boolean[arraySize][arraySize];
        for (int row = 0; row < arraySize; row++) {
            for (int column = 0; column < arraySize; column++) {
                grid[row][column] = false;
            }
        }
        return grid;
    }
    /**
     * @param args
     * accepts two integer arguments gridSize to try and
     * number of repetitions to perform.
     *
    */
    public static void main(final String[] args) {

        final int gridSize = new Integer(args[0]).intValue();
        final int repetitions = new Integer(args[1]).intValue();
        final double displayNumber = 95;

        final PercolationStats op = new PercolationStats(gridSize, repetitions);
        StdOut.printf("mean                    = %f\n" ,    op.mean());
        StdOut.printf("stddev                  = %f\n" ,    op.stddev());
        StdOut.printf("%.0f%% confidence interval = %f, %f\n" ,
                displayNumber,
                op.confidenceLo(),
                op.confidenceHi());
    }
}
