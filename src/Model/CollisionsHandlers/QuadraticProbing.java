package Model.CollisionsHandlers;

import Model.Counter;

public class QuadraticProbing extends Counter {
	
	/**
	 * Search the table data using quadratic probing.  Use any quadratic 
	 * 		equation (ho + b*i + c*i^2) so that the linearity of linear 
	 * 		probe can be eliminated. If data[j] is empty then the new key 
	 * 		is not in the table and it can be safely inserted. Otherwise, 
	 * 		data[j] = key which is already in the table. If tableSize is a 
	 * 		power of 2, the period of the search is too small to be effective.  
	 * 		Choosing a prime table size allows the algorithm to searche 1/2 the 
	 * 		table before addresses begin to repeat. There is a way to generate 
	 * 		the other 1/2 table locations.
	 * @param key key to be inserted or searched
	 * @param data the hash table to search 
	 * @param initialHashAddress initialHashAddress initial hash address after applied hashing function
	 * @return the address of the key (if already in the table), or 
	 * 			Position that key can be inserted, or –1 if the table is full.

	 */
	
	public static int findQuadraticProbingIndex (String key, String [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int i = 0;
		while ((data[j] != null) && !(data[j].equals(key))) {
			incrementCollisions();
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
