import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

	private static void printAnagrams(String arr[]) {
		HashMap<String, List<String>> map = new HashMap<>();

		// loop over all words
		for (int i = 0; i < arr.length; i++) {

			// convert to char array, sort and
			// then re-convert to string
			String word = arr[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);

			// after sorting
			if (map.containsKey(newWord)) {

				map.get(newWord).add(word);
			} else {

				// This is the first time 
				// adding a word for a specific
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(newWord, words);
			}
		}

		// print all the values where size is > 1
		// If we want to print non-anagrams,
		// just print the values having size = 1
		for (String s : map.keySet()) {
			List<String> values = map.get(s);
			if (values.size() > 1) {
				System.out.print(values);
			}
		}
	}

	public static void main(String[] args) {

		String wordArr[] = { "CAT", "DOG", "TAC", "MAD", "DAM" ,"AMD","GOD","SET"};
		printAnagrams(wordArr);
	}
}