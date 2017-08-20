import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ToggleMain {
	private static int lengthString;

	public static void main(String[] args) {
		String s1 = "4938532894754";
		Set<Set<String>> all = new HashSet<>();
		Set<String> small = new LinkedHashSet<>();

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
			if (length == lengthString && smallAll.size() == 7) {
				allSet.add(smallAll);
			}
			return;
		}
		if (allNumbers.length() == 0) {
			return;
		}

		Set<String> smallAllFin = new LinkedHashSet<>();
		if (smallAll.size() > 0) {
			smallAllFin.addAll(smallAll);
		}
		int compareNo = Integer.valueOf(allNumbers.substring(0, 1));
		if (compareNo >= 1 && compareNo <= 59) {
			smallAllFin.add(allNumbers.substring(0, 1));
		}
		// System.out.println(smallAllFin);
		// System.out.println(allSet);
		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()), smallAllFin, allSet);

		if (allNumbers.length() > 1) {
			Set<String> smallAllFin2 = new LinkedHashSet<>();

			if (smallAll.size() > 0) {
				smallAllFin2.addAll(smallAll);
			}
			int compareNo2 = Integer.valueOf(allNumbers.substring(0, 2));

			if (compareNo2 >= 1 && compareNo2 <= 59) {
				smallAllFin2.add(allNumbers.substring(0, 2));
			}

			// System.out.println(smallAllFin2);
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()), smallAllFin2, allSet);
		}

	}
}
