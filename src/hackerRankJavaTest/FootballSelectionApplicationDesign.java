/**
 * 
 */
package hackerRankJavaTest;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author onkesh.bansal
 * 	
 * Problem: https://siddarthkanted.wordpress.com/2020/07/12/football-selection-application-design-arcesium/
 *
 */
public class FootballSelectionApplicationDesign {

	/*
	 * Complete the 'getSelectionStatus' function below.
	 *
	 * The function is expected to return a 2D_STRING_ARRAY. The function accepts
	 * 2D_STRING_ARRAY applications as parameter.
	 */

	enum PlayerType {
		DEFENDER, STRIKER, BOTH, NA
	};

	static class Player {

		int MAX_BMI = 23, MIN_GOALS = 50, MIN_DEFENDS = 30;
		double MIN_HEIGHT = 5.8;

		public String name;
		public double height;
		public double bmi;
		public int scores;
		public int defends;
		public PlayerType type;

		Player(List<String> list) {
			this.name = list.get(0);
			this.height = Double.parseDouble(list.get(1));
			this.bmi = Double.parseDouble(list.get(2));
			this.scores = Integer.parseInt(list.get(3));
			this.defends = Integer.parseInt(list.get(4));
			this.type = this.getType();
		}

		PlayerType getType() {
			if (this.height < MIN_HEIGHT && this.bmi > MAX_BMI)
				return PlayerType.NA;
			if (this.scores >= MIN_GOALS && this.defends >= MIN_DEFENDS)
				return PlayerType.BOTH;
			if (this.scores >= MIN_GOALS)
				return PlayerType.STRIKER;
			if (this.defends >= MIN_DEFENDS)
				return PlayerType.DEFENDER;

			return PlayerType.NA;
		}
	}

	static Set<String> getNames(List<Player> players, int length) {
		Set<String> result = new HashSet<>();
		int i = 0;
		for (Player p : players) {
			if (i < length) {
				result.add(p.name);
				i++;
			}
		}
		return result;
	}

	public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
		List<Player> players = new ArrayList<>();
		List<Player> defenders = new ArrayList<>();
		List<Player> strikers = new ArrayList<>();
		List<Player> both = new ArrayList<>();

		// convert list of strings to list of Player object
		for (List<String> l : applications) {
			players.add(new Player(l));
		}

		// sort by name
		Collections.sort(players, (o1, o2) -> o1.name.compareTo(o2.name));

		// create lists for all types of players - strikers, defenders and both category
		for (Player p : players) {
			if (p.type == PlayerType.DEFENDER)
				defenders.add(p);
			if (p.type == PlayerType.STRIKER)
				strikers.add(p);
			if (p.type == PlayerType.BOTH)
				both.add(p);
		}

		/*
		 * move players from both list to defenders size mismatch with strikers as we
		 * have players that can be both strikers and defenders and target of the
		 * following methods is to move maximum players from both to defenders and
		 * strikers respectively.
		 */
		while (defenders.size() < strikers.size() && both.size() > 0) {
			Player p_def = both.remove(0);
			defenders.add(p_def);
		}

		while (strikers.size() < defenders.size() && both.size() > 0) {
			Player p_def = both.remove(0);
			strikers.add(p_def);
		}

		// sorting defenders and strikers on basis of goals and defends respectively
		Collections.sort(defenders, (o1, o2) -> o1.defends - o2.defends);
		// sort result from largest to smallest
		Collections.reverse(defenders);

		// sorting defenders and strikers on basis of goals and defends respectively
		Collections.sort(strikers, (o1, o2) -> o1.scores - o2.scores);
		// sort result from largest to smallest
		Collections.reverse(strikers);

		// Get count of minimum number of results to be picked on condition
		// Equal number of players required in output
		int minimum = Math.min(defenders.size(), strikers.size());
		Set<String> defNames = getNames(defenders, minimum);
		Set<String> strkrNames = getNames(strikers, minimum);

		// traversing the list of names and checking where the player is categorized.
		List<List<String>> res = new ArrayList<>();
		for (Player p : players) {
			List<String> out = new ArrayList<>();
			out.add(p.name);
			if (defNames.contains(p.name)) {
				out.add("SELECT");
				out.add("DEFENDER");
			} else if (strkrNames.contains(p.name)) {
				out.add("SELECT");
				out.add("STRIKER");
			} else {
				out.add("REJECT");
				out.add("NA");
			}
			res.add(out);
		}

		return res;
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception, RuntimeException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
//		int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> applications = new ArrayList<>();

		IntStream.range(0, applicationsRows).forEach(i -> {
			try {
				applications
						.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<List<String>> result = FootballSelectionApplicationDesign.getSelectionStatus(applications);

		result.stream().map(r -> r.stream().collect(Collectors.joining(" "))).map(r -> r + "\n").collect(Collectors.toList()).forEach(e -> {
			System.out.print(e);
		});

		bufferedReader.close();
	}

}
