/**
 * Class for team.
 */
class Team implements Comparable<Team> {
	/**
	 * The variables read are name, wins, losses, and draws.
	 */
	String name;
	int wins;
	int losses;
	int draws;
	/**
	 * Constructs the object.
	 *
	 * @param      name1    The name 1
	 * @param      wins1    The wins 1
	 * @param      losses1  The losses 1
	 * @param      draws1   The draws 1
	 */
	Team (String name1, int wins1, int losses1, int draws1) {
		this.name = name1;
		this.wins = wins1;
		this.losses = losses1;
		this.draws = draws1;
	}

	String getname() {
		return name;
	}

	int getwins() {
		return wins;
	}

	int getlosses() {
		return losses;
	}

	int getdraws() {
		return draws;
	}

	/**
	 * Compare two objects and returns values related to it.
	 * If one is greater than other it return 1 else returns -1
	 * and 0 if both equals.
	 * 
	 * The time complexity is only 1 here only condition is
	 * getting verified and based on the verification the value is
	 * getting returned.
	 *
	 * @param      obj   The object
	 *
	 * @return     { integer value 0 or 1 or -1 }
	 */
	public int compareTo(Team obj) {
		if (this.wins > obj.wins) {
			return 1;
		}

		if (this.wins < obj.wins) {
			return -1;
		}

		if (this.losses < obj.losses) {
			return 1;
		}

		if (this.losses > obj.losses) {
			return -1;
		}

		if (this.draws > obj.draws) {
			return 1;
		}

		if (this.draws < obj.draws) {
			return -1;
		}
		return 0;
	}

	public String toString(){
		return this.name;
	}
}