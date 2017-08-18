import java.util.HashSet;
import java.util.Set;

public class ToggleMain {
	public static void main(String[] args) {
		String s1 = "4938";
		Set<Set<String>> all = new HashSet<>();
		getlotteryNumbers(s1, all);
		for (Set<String> s : all) {
			System.out.println(s);
		}
	}

	private static void getlotteryNumbers(String allNumbers, Set<Set<String>> all) {
		if (allNumbers.length() == 0) {
			return;
		}
		Set<Set<String>> startFirst = new HashSet<>();
		startFirst.addAll(all);

		if (all.isEmpty()) {
			Set<String> start = new HashSet<>();
			start.add(allNumbers.substring(0, 1));
			all.add(start);
		}
		for (Set<String> s : all) {
			Set<String> small = new HashSet<>();
			small.addAll(s);
			small.add(allNumbers.substring(0, 1));
			startFirst.add(small);
		}
		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()), startFirst);
		Set<Set<String>> secondSet = new HashSet<>();
		if (allNumbers.length() > 1) {
			for (Set<String> s : all) {
				Set<String> small = new HashSet<>();
				small.addAll(s);
				small.add(allNumbers.substring(0, 2));
				secondSet.add(small);
			}
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()), secondSet);
		}
	}
}
