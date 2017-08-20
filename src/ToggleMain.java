import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ToggleMain {
	public static void main(String[] args) {
		String s1 = "1234";
		Set<Set<String>> all = new HashSet<>();
		Set<Set<String>> smallAll = new HashSet<>();

		all.add(new HashSet<>());
		getlotteryNumbers(s1,smallAll, all);
		for (Set<String> s : smallAll) {
			if(s.size() ==2){
				System.out.println(s);
			}
		}
	}

	private static void getlotteryNumbers(String allNumbers,
			Set<Set<String>> smallAll,	Set<Set<String>> all) {

		if(!all.isEmpty()){
			smallAll.addAll(all);
		}else{ 
			Set<String> start = new HashSet<>();
			start.add(allNumbers.substring(0, 1));
			all.add(start);
		}
		Set<Set<String>> allnew = new HashSet<>();
		for (Set<String> s : all) {
			if (s.size() == 2) {
				allnew.add(s);
			}
		}
		if (allNumbers.length() == 0) {
			return;
		}
		Set<Set<String>> startFirst = new HashSet<>();
		startFirst.addAll(all);

		for (Set<String> s : all) {
			Set<String> small = new HashSet<>();
			small.addAll(s);
			small.add(allNumbers.substring(0, 1));
			startFirst.add(small);
		}
		getlotteryNumbers(allNumbers.substring(1, allNumbers.length()),smallAll, startFirst);
		Set<Set<String>> secondSet = new HashSet<>();
		if (allNumbers.length() > 1) {
			for (Set<String> s : all) {
				Set<String> small = new HashSet<>();
				small.addAll(s);
				small.add(allNumbers.substring(0, 2));
				secondSet.add(small);
			}
			getlotteryNumbers(allNumbers.substring(2, allNumbers.length()),smallAll, secondSet);
		}
	}
}
