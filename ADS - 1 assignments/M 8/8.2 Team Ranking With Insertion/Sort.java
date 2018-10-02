import java.util.Arrays;
/**
 * Class for sort.
 */
class Sort{
	/**
	 * Teamarray with team objects.
	 */
	public Team[] teamarray = new Team[10];
	/**
	 * Teamcount for increasing count in array.
	 */
	int teamcount;
	/**
	 * Constructs the object.
	 */
 	Sort() {
 		teamcount = 0;
	}
	/**
	 * Adds a team.
	 * Time complexity N. It depends on the number of values added into array.
	 *
	 * @param      teamgiven  The teamgiven
	 */
	void addTeam(Team teamgiven) {
		try {
			teamarray[teamcount++] = teamgiven;
			return;
		} catch (Exception e) {
			resize();
		}
		teamarray[teamcount++] = teamgiven;
	}
	/**
	 * Resizes the array and makes a copy of the array.
	 */
	void resize() {
		teamarray = Arrays.copyOf(teamarray, 2 * teamcount);
	}

	/**
	 * Swaps the values and places the smaller one in the beginning.
	 * Time complexity is 1 only assigning of values.
	 *
	 * @param      teams  The teams
	 * @param      i      { Index value. }
	 * @param      j      { Index value. }
	 */
	void exchange(Team[] teams, int i, int j) {
		Team t = teams[j];
		teams[j] = teams[i];
		teams[i] = t;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i< teamcount; i++) {
			str += teamarray[i].name + ",";
		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * Insertion sort.
	 * 
	 * The time complexity of this technique is N^2.
	 * The exchanges and comparisons are having N^2 complexity.
	 * For each and every comparision there is an exchange based on the position
	 * of value.
	 * The worst case caluculation is when the array is reverse sorted type.
	 * In this case the last value should take N iterations all the way to the beginning.
	 * 
	 */
	void insertionSort() {
		
		for (int i = 0; i < teamcount-1; i++) {
			//int min = i;
			for (int j = i + 1; j > 0; j--) {
				if (less(teamarray, j, j - 1)) {
				    exchange(teamarray, j, j - 1);		
				}
			}
		}
		//System.out.println(toString());
	}

	/**
	 * Less comparision.
	 *
	 * @param      arr   The arr
	 * @param      i     { Index value. }
	 * @param      j     { Index value. }
	 *
	 * @return     { Boolean value based on the comparision }
	 */
	boolean less(Team[] arr, int i , int j){

		return arr[i].compareTo(arr[j]) > 0;
	}
}