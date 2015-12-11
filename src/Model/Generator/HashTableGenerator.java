package Model.Generator;

import java.util.ArrayList;

import Model.SearchSimulation;
import Model.HashingFunctions.DivisionHashFunction;

public class HashTableGenerator {
	public static int[] createHashTable(String hashFunction, String collisionHandler, 
			int tableSize, ArrayList<Integer> dataTable) {
		int[] hashTable = new int[tableSize];
		switch (hashFunction) {
			case "Division": {
				for (int key: dataTable) {
					int initialHashAddress = DivisionHashFunction.divisionHash(key, tableSize);
					int index = SearchSimulation.findKeyInHashTable(key, initialHashAddress, collisionHandler, hashTable);
					if (index > 0) {
						hashTable[index] = key;
					}
				}
				break;
			}
		}
		return hashTable;
	}

	
}
