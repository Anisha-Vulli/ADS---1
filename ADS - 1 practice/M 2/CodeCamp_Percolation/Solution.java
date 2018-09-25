// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem

import java.util.Scanner;
import java.util.Arrays;

class Percolation {
    int[][] gridarr;
    int size;
    int count;
    WeightedQuickUnionUF wqu;
    Percolation(int n) {
        gridarr = new int[n][n];
        size = n;
        count = 0;
        wqu = new WeightedQuickUnionUF((size * size) + 2);
    }

    public void open(int row, int col) {
        int rowgiven = row - 1;
        int colgiven = col - 1;
        gridarr[rowgiven][colgiven] = 1;
        count++;
        //union(int rowgiven, int colgiven);
        if (row == 0) {
            wqu.union(0, component(row, col));
        }

        if (row == size - 1) {
            wqu.union((size * size) + 1, component(row, col));
        }

        if (row > 0) {
            if (gridarr[row + 1][col] == 1) {
                wqu.union(component(row,col), component(row + 1, col));
            }
        }

        if (row < size - 1) {
            if (gridarr[row - 1][col] == 1) {
                wqu.union(component(row,col), component(row - 1, col));
            }
        }

        if (col > 0) {
            if (gridarr[row][col + 1] == 1) {
                wqu.union(component(row,col), component(row, col + 1));
            }
        }

        if (col < size - 1) {
            if (gridarr[row][col - 1] == 1) {
                wqu.union(component(row,col), component(row, col - 1));
            }
        }
        //isOpen(rowgiven, colgiven);
    }

    public int component(int row, int col) {
        return ((row * size) + col) + 1;
    }
    public boolean isOpen(int row, int col) {
        return gridarr[row - 1][col - 1] == 1;
    }

    public boolean isFull(int row, int col) {
        return gridarr[row-1][col-1] == 0;
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        return wqu.connected(0, (size * size) + 1);
    }
    public String toString() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(gridarr[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Percolation p = new Percolation(input);
        while(sc.hasNext()) {
            //String[] token = sc.nextLine().split(" ");
            p.open(sc.nextInt(), sc.nextInt());
        }
       System.out.println(p.percolates()); 
    }
}