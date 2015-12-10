package Model;

public class DivisionHashFunction {
	public static int divisionHash(int key, int tableSize) {
		return key % tableSize;		
	}
}
