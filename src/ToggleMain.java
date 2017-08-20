import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToggleMain {
	private static int lengthString;

	public static void main(String[] args) {
		String s1 = "4938532894754";
		Set<Set<String>> all = new HashSet<>();
		Set<String> small = new HashSet<>();

		lengthString = s1.length();

		getlotteryNumbers(s1, small, all);
		System.out.println("final ");

		for (Set<String> s : all) {
			System.out.println(s);
		}
	}

	private static void getlotteryNumbers(String allNumbers, Set<String> smallAll, Set<Set<String>> allSet) {

		if (allNumbers.length() == 0) {
			int length = 0;
			for (String s : smallAll) {
				length += s.length();
			}
			if (length == lengthString) {
				allSet.add(smallAll);
				return;
			}
		}
		if (allNumbers.length() == 0) {
			return;
		}

		Set<String> smallAllFin = new HashSet<>();
		if (smallAll.size() > 0) {
			smallAllFin.addAll(smallAll);
		}
		smallAllFin.add(allNumbers.substring(0, 1));
		System.out.println(smallAllFin);
		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()), smallAllFin, allSet);

		if (allNumbers.length() > 1) {
			Set<String> smallAllFin2 = new HashSet<>();

			if (smallAll.size() > 0) {
				smallAllFin2.addAll(smallAll);
			}
			smallAllFin2.add(allNumbers.substring(0, 2));

			System.out.println(smallAllFin2);
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()), smallAllFin2, allSet);
		}

	}
}
