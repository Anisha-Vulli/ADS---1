class Team implements Comparable<Team> {
	String name;
	int wins;
	int losses;
	int draws;
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