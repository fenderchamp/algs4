public class PercolationStats {

    int count;
    int [] runs;

    public PercolationStats(int gridSize, int repetitions) 
            throws java.lang.IllegalArgumentException {

        if (gridSize <= 0 || repetitions <= 0) {
            throw new java.lang.IllegalArgumentException("gridsize or repitions count is less than 0");
        }
        count = gridSize * 2;
        runs = new int[repetitions];
        for (int i = 0; i< repetitions; i++) {
StdOut.print(i);
            boolean [][] open = initializeGrid(gridSize);
            Percolation oPercolation = new Percolation(gridSize);   
            int opened = 0;
            while (!oPercolation.percolates())  {
                int row =    StdRandom.uniform(1,gridSize);
                int column = StdRandom.uniform(1,gridSize);
                if (!open[row][column]) {
                    open[row][column]=true;
                    oPercolation.open(row, column);   
                    opened++;
                   StdOut.print(row + "," + column);
                } else {      
                   StdOut.print("skipped:" + row + "," + column);
                }
            }
            runs[i]=opened;
        }
    };   // perform T independent computational experiments on an N-by-N grid

    public double mean() { 
        double mean=1; 
        return mean; 
                };
    // sample standard deviation of percolation threshold
    public double stddev()        { 
        double mean=1; 
        return(mean); 
                };
    // returns lower bound of the 95% confidence interval
    public double confidenceLo()             { 
        double mean=1; return mean; 
                };
    // returns upper bound of the 95% confidence interval
    public double confidenceHi()         { 
        double mean=1; return mean; 
                };
    /*
     */
    public static void main(String[] args) {

        int gridSize = new Integer(args[0]).intValue();
        int repetitions = new Integer(args[1]).intValue();
StdOut.print("here");


        PercolationStats op=new PercolationStats(gridSize,repetitions);
        double m = op.mean();
int joe=1;
    }

    private boolean[][] initializeGrid(int gridSize) {
        int arraySize = gridSize + 1; // ignore the zeros so pad 
        boolean[][] grid = new boolean[arraySize][arraySize]; 
        for (int row = 0; row < arraySize; row++) {
            for (int column = 0; column < arraySize; column++) {
                grid[row][column] = false;
            }
        }
        return grid;
    }
}
