import java.util.ArrayList;
import java.util.List;

/**
 * Some utility methods for Strings.
 */
public class StringUtil {
	/**
	 * Find the index of a String (arg) in an array of Strings.
	 * @param arg is the string to search for
	 * @param array is an array of Strings to examine
	 * @return the index of first occurence of arg, or -1 if it is not in the array.
	 */
	public static int indexOf(String arg, String[] array) {
		int index = -1;
		for(int k=0; k<array.length; k++) {
			if (array[k].equals(arg)) return k;
		}
		return -1;
	}
}
