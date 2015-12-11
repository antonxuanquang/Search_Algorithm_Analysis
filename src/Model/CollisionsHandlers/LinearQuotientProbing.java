package Model.CollisionsHandlers;

import Model.Counter;

public class LinearQuotientProbing extends Counter{
	public static int findLinearQuotientProbingIndex (String key, String [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int quotient = convertToInteger(key) / data.length;
		if (quotient == 0) {
			quotient = 1;
		}
		int i = 0;
		while ((data[j] != null) && !(data[j].equals(key))) {
			incrementComparison();
			i++;
			j = (initialHashAddress + i*quotient) % data.length;
			if (i == (data.length - 1)) {
				return -1;
			}
		}
		incrementComparison();
		return j;
	}
	
	private static int convertToInteger(String key) {
	   char c1 = key.charAt(0), c2 = key.charAt(1), c3 = key.charAt(2), c4 = key.charAt(3);
	   return (int)((((((int)c1<<8)+(int)c2)<<8)+(int)c3)<<8)+(int)c4;
	}
}
