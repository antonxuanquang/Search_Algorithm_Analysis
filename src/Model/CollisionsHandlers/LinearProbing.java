package Model.CollisionsHandlers;

import Model.Counter;

public class LinearProbing extends Counter{
	
	/**
	 * Search the table data using linear probing.  If data[j] is empty
	 * then the new key is not in the table and it can be safely inserted.
	 * Otherwise, data[j] = key which is already in the table.
	 * 
	 * @param key key to be inserted or search
	 * @param data table to search
	 * @param initialHashAddress the initial hash address after applying 
				a hash function
	 * @return the address of the key (if already in the table), or the
				Position that key can be inserted, or –1 if the table is full. 
	 */
	
	public static int findLinearProbingIndex(int key, int [] data, int initialHashAddress) {
		int j = initialHashAddress;
		
		while ((data[j] != key) && (data[j] != 0)) {
			incrementComparison();
			j = (j + 1) % data.length;
			if (j == initialHashAddress) {
				return -1;
			}
		}
		return j;
	}
}
