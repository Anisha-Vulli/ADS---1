import java.util.Arrays;
class Sort{
	public Team[] teamarray = new Team[10];
	int teamcount;
 	Sort() {
 		teamcount = 0;
	}

	void addTeam(Team teamgiven) {
		try {
			teamarray[teamcount++] = teamgiven;
			return;
		} catch (Exception e) {
			resize();
		}
		teamarray[teamcount++] = teamgiven;
	}

	void resize() {
		teamarray = Arrays.copyOf(teamarray, 2 * teamcount);
	}

	void exchange(Team[] teams, int i, int j) {
		Team t = teams[j];
		teams[j] = teams[i];
		teams[i] = t;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i< teamcount; i++) {
			str += teamarray[i].name + ",";
		}
		return str.substring(0, str.length() - 1);
	}
	void Selectionsort() {
		
		for (int i = 0; i < teamcount-1; i++) {
			int min = i;
			for (int j = i + 1; j < teamcount; j++) {
				if (less(teamarray, j, min)) {
					min = j;
				}
			}
			exchange(teamarray, i, min);
		}
		//System.out.println(toString());
	}

	boolean less(Team arr[], int i , int j){

		return arr[i].compareTo(arr[j]) > 0;
	}
}