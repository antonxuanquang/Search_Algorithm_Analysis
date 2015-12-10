package Model.CollisionsHandlers;

public class LinearQuotientProbing {
	public static int findLinearQuotientProbingIndex (int key, int [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int quotient = key / data.length;
		if (quotient == 0) {
			quotient = 1;
		}
		int i = 0;
		while ((data[j]!= key) && (data[j] != 0)) {
			i++;
			j = (initialHashAddress + i*quotient) % data.length;
			if (i == (data.length - 1)) {
				return -1;
			}
		}
		return j;
	}
}