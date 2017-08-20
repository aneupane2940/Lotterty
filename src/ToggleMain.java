import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToggleMain {
	public static void main(String[] args) {
		String s1 = "1234";
		Set<Set<String>> all = new HashSet<>();
		List<Set<String>> smallAll = new ArrayList<>();

		all.add(new HashSet<>());
		getlotteryNumbers(s1, smallAll);
		for (Set<String> s : smallAll) {
			// if (s.size() == 2) {
			System.out.println(s);
			// }
		}
	}

	private static void getlotteryNumbers(String allNumbers, List<Set<String>> smallAll) {

		if (allNumbers.length() == 0) {
			return;
		}
		List<Set<String>> smallAllFin = new ArrayList<>();

		for (Set<String> s : smallAll) {
			Set<String> delta = new HashSet<>();
			delta.addAll(s);
			smallAllFin.add(delta);
		}

		Set<String> small = new HashSet<>();
		if (smallAll.size() > 0) {
			small.addAll(smallAll.get(smallAll.size() - 1));
		}
		small.add(allNumbers.substring(0, 1));
		smallAllFin.add(small);
		
		System.out.println(smallAllFin);

		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()), smallAllFin);

		if (allNumbers.length() > 1) {
			
			List<Set<String>> smallAllFin2 = new ArrayList<>();


			for (Set<String> s : smallAll) {
				Set<String> delta = new HashSet<>();
				delta.addAll(s);
				smallAllFin2.add(delta);
			}

			Set<String> small2 = new HashSet<>();
			if (smallAll.size() > 0) {
				small2.addAll(smallAll.get(smallAll.size() - 1));
			}
			small2.add(allNumbers.substring(0, 2));
			smallAllFin2.add(small2);
			
			System.out.println(smallAllFin2);
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()), smallAllFin2);
		}
	}
}
