import java.util.Scanner;


class Solution {
    
    public static Team createTeam(final String[] array) {
        String name = array[0];
        //System.out.println(name);
        int wins = Integer.parseInt(array[1]);
        int losses = Integer.parseInt(array[2]);
        int draws = Integer.parseInt(array[2 + 1]);
        return new Team(name, wins, losses, draws);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            s.addTeam(createTeam(input));

        }
        //System.out.println(s);
        s.Selectionsort();
        System.out.println(s);
    }
}
