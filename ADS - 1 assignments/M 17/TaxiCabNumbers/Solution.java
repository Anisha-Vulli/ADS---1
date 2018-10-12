import java.util.*;
class Taxicab implements Comparable<Taxicab> {
  int i,j;
  long sum;
  public Taxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Taxicab that) {
        if      (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        // else if (this.i < that.i)     return -1;
        // else if (this.i > that.i)     return +1;
        else                          return  0;
    }
    public String toString() {
        return i + "^3 + " + j + "^3";
    }

}
class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
      String[] input = sc.nextLine().split(" ");
      int N = Integer.parseInt(input[0]);
      int M = Integer.parseInt(input[1]);
      int n = 1000;
      MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
            for (int i = 1; i <= n; i++) {
              pq.insert(new Taxicab(i, i));
          }
        int pair = 1;
        Taxicab previous = new Taxicab(0, 0);
        int count = 0;
        while (!pq.isEmpty()) {
            Taxicab current = pq.delMin();
            if (previous.sum == current.sum) {
                pair++;
                if (pair == M){
                  count = count+1;
                }
                if(count == N){
                System.out.println(previous.sum);
                break;
              }
            }
            else {
                pair = 1;
            }
            previous = current;
            if (current.j < n) pq.insert(new Taxicab(current.i, current.j + 1));
        }
    }
  }
  }