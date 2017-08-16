import java.util.HashSet;
import java.util.Set;

public class LotteryNumbers {

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
			start.add("");
			startFirst.add(start);
		}
		for (Set<String> s : startFirst) {
			s.add(allNumbers.substring(0, 1));
		}
		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()), startFirst);
		if (allNumbers.length() > 1) {
			Set<Set<String>> secondSet = new HashSet<>();
			secondSet.addAll(all);
			for (Set<String> s : secondSet) {
				s.add(allNumbers.substring(0, 2));
			}
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()), secondSet);
		}
	}
}
