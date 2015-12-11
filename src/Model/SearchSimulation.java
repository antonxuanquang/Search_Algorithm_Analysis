package Model;

import Model.CollisionsHandlers.LinearProbing;
import Model.CollisionsHandlers.LinearQuotientProbing;
import Model.CollisionsHandlers.QuadraticProbing;

public class SearchSimulation {
	/**
	 * 
	 * This method determine the collision handling method and perform search base on that.
	 * 
	 * @param key key to search
	 * @param initialHashAddress the initial hashing address after applied hashing function
	 * @param collisionHandler collision handling method
	 * @param hashTable hash table where keys are stored
	 * @return index of key (whether it be the correct index to put new key in or index of 
	 * 			existing key) return -1 if key doesn't exist
	 */
	public static int findKeyInHashTable(String key, int initialHashAddress
			, String collisionHandler, String[] hashTable) {
		switch (collisionHandler) {
			case "Linear Probing": {
				return LinearProbing.findLinearProbingIndex(key, hashTable, initialHashAddress);
			}
			case "Quadratic Probing": {
				return QuadraticProbing.findQuadraticProbingIndex(key, hashTable, initialHashAddress);
			}
			case "Linear Quotient Probing": {
				return LinearQuotientProbing.findLinearQuotientProbingIndex(key, hashTable, initialHashAddress);
			}
		}
		return -1;
	}
}
