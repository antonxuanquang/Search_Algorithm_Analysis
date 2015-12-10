package Model;

import Model.CollisionsHandlers.LinearProbing;
import Model.CollisionsHandlers.LinearQuotientProbing;
import Model.CollisionsHandlers.QuadraticProbing;

public class SearchSimulation {
	
	public static int findKeyInHashTable(int key, int initialHashAddress
			, String collisionHandler, int[] hashTable) {
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
