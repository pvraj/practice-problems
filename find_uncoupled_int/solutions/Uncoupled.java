import java.util.*;

public class Uncoupled {

	public static void main(String[] args) throws Exception {
		int[] array = {2, 3, 4, 3, 2, 5, 5};
		System.out.println(uncoupled(array));
		System.out.println(uncoupledXOR(array));
	}


	// O(n) time and O(n) space
	public static int uncoupled(int[] array) throws Exception {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			if (set.contains(i)) {
				set.remove(i);
			}
			else {
				set.add(i);
			}
		}
		for (int element : set) {
			return element;
		}
		throw new Exception("Invalid list size");
		
	}

	// now try with O(n) time and O(1) space
	public static int uncoupledXOR(int[] array) {
		int result = 0;
		for (int i: array) {
			result ^= i;
		}
		return result;
	}
}