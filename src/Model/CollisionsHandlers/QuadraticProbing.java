package Model.CollisionsHandlers;

import Model.Counter;

public class QuadraticProbing extends Counter {
	public static int findQuadraticProbingIndex (String key, String [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int i = 0;
		while (!(data[j].equals(key)) && !(data[j].equals(null))) {
			incrementComparison();
			i++;
			j = (initialHashAddress + i*i) % data.length;
			if (i > (data.length-1) / 2) {
				return -1;
			}
		}
		incrementComparison();
		return j;
	}
}
