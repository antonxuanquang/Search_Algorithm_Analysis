package Model.Generator;

import java.util.ArrayList;

import Model.SearchSimulation;
import Model.HashingFunctions.DivisionHashFunction;

public class HashTableGenerator {
	public static String[] createHashTable(String hashFunction, String collisionHandler, 
			int tableSize, ArrayList<String> dataTable) {
		String[] hashTable = new String[tableSize];
		switch (hashFunction) {
			case "Division": {
				for (String key: dataTable) {
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
