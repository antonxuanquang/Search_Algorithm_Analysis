package Model.HashingFunctions;

public class DivisionHashFunction {
	public static int divisionHash(int key, int tableSize) {
		return key % tableSize;		
	}
}
