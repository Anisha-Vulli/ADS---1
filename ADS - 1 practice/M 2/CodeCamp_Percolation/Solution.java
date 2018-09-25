import java.util.Scanner;
/**
 * Class for percolation.
 */
 class Percolation {
/**
 * grid matrix.
 */
    private int[][] grid;
    /**
     * top variable.
     */
    private int count;
    /**
     * size variable.
     */
    private int size;
    /**
     * variable for weighted quick union.
     */
    private WeightedQuickUnionUF qf;

    /**
     * constructor for percolation class.
     * @param n integer variable.
     */
     Percolation(final int n) {
        size = n;
        count = 0;
        qf = new WeightedQuickUnionUF(size * size + 2);
        grid = new int[size][size];
    }

    /**
     * @param i integer variable.
     * @param j integer variable.
     * open method for percolation class.
     */
    public void open(final int row, final int col) {
        grid[row][col] = 1;
        if (row == 0) {
            qf.union(0, component(row, col));
        }
        if (row == size - 1) {
            qf.union((size * size) + 1, component(row, col));
        }

        if (row + 1 < size && grid[row][col] == 1) {
            qf.union(component(row + 1, col), component(row, col));
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                qf.union(
                    component(row - 1, col), component(row, col));
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                qf.union(component(row, col - 1), component(row, col));
        }
        if (col + 1 < size && grid[row][col + 1] == 1) {
                qf.union(
                    component(row, col + 1), component(row, col));
        }
    }

    /**
     * checks if the given block is open or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is open.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i][j] == 1;
    }

    /**
     * checks if block is full or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is full.
     */
    public boolean isFull(final int i, final int j) {
         return grid[i][j] == 0;   
    }

    /**
     * to get the number of open sites.
     *
     * @return     integer is returned.
     */
    int numberofopensites() {
        return count;
    }

    /**
     * checks for percolation.
     * @return returns true if percolation is possible.
     */
    public boolean percolates() {
        return qf.connected(0, (size * size) + 1);
    }
    /**
     * method to find the component at given indices.
     *
     * @param      i  integer variable.
     * @param      j  integer variable.
     *
     * @return returns the component value.
     */
    private int component(final int i, final int j) {
        return (i) * size + j;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * constructor for solution class.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        while (sc.hasNext()) {
            p.open(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        System.out.println(p.percolates());
    }
}
