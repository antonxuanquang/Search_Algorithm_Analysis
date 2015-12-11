package Model.HashingFunctions;

public class DivisionHashFunction {
	
	/**
	 * 
	 * the hash address of division method is calculated by:
	 * h = key % table size
	 * 
	 * @param key key to be searched
	 * @param tableSize table size
	 * @return initial hash address
	 */
	public static int divisionHash(String key, int tableSize) {
		return convertToInteger(key) % tableSize;
	}
	
	private static int convertToInteger(String key) {
	   char c1 = key.charAt(0), c2 = key.charAt(1), c3 = key.charAt(2), c4 = key.charAt(3);
	   return (int)((((((int)c1<<8)+(int)c2)<<8)+(int)c3)<<8)+(int)c4;
	}
}
