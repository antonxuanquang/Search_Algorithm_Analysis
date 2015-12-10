package Model;

import java.util.ArrayList;

import Model.CollisionsHandlers.LinearProbing;
import Model.CollisionsHandlers.LinearQuotientProbing;
import Model.CollisionsHandlers.QuadraticProbing;
import Model.HashingFunctions.DivisionHashFunction;

public class HashTableGenerator {
	public static int[] createHashTable(String hashFunction, String collisionHandler, 
			int tableSize, ArrayList<Integer> dataTable) {
		int[] hashTable = new int[tableSize];
		switch (hashFunction) {
			case "Division Method": {
				for (int key: dataTable) {
					int initialHashAddress = DivisionHashFunction.divisionHash(key, tableSize);
					putKeyIntoHashTable(key, initialHashAddress, collisionHandler, hashTable);
				}
				break;
			}
		}
		return hashTable;
	}

	private static void putKeyIntoHashTable(int key, int initialHashAddress
			, String collisionHandler, int[] hashTable) {
		switch (collisionHandler) {
			case "Linear Probing": {
				int index = LinearProbing.findLinearProbingIndex(key, hashTable, initialHashAddress);
				if (index > 0) {
					hashTable[index] = key;
				}
				break;
			}
			case "Quadratic Probing": {
				int index = QuadraticProbing.findQuadraticProbingIndex(key, hashTable, initialHashAddress);
				if (index > 0) {
					hashTable[index] = key;
				}
				break;
			}
			case "Linear Quotient Probing": {
				int index = LinearQuotientProbing.findLinearQuotientProbingIndex(key, hashTable, initialHashAddress);
				if (index > 0) {
					hashTable[index] = key;
				}
				break;
			}
		}
		
	}
}
