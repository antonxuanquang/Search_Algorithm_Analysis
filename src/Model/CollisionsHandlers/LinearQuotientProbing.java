package Model.CollisionsHandlers;

import Model.Counter;

public class LinearQuotientProbing extends Counter{
	
	/**
	 * Search the table, data, using Linear Quotient probing. Secondary clustering can be 
	 * 		eliminated by choosing a secondary hashing function f that is a function of 
	 * 		both the key and the probe number.  That is: hi = (h0 + f(i,key)) mod tableSize.
	 * @param key key to be inserted or search
	 * @param data the hash table (a prime number size) to search
	 * @param initialHashAddress initial hash address after applied hashing function
	 * @return the address of the key (if already in the table), or the
				Position that key can be inserted, or –1 if the table is full.

	 */
	public static int findLinearQuotientProbingIndex (String key, String [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int quotient = convertToInteger(key) / data.length;
		if (quotient == 0) {
			quotient = 1;
		}
		int i = 0;
		while ((data[j] != null) && !(data[j].equals(key))) {
			incrementCollisions();
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
