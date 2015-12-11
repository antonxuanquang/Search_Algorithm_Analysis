package Model;

public class Counter {
	private static int comparison = 0;
	
	public int getComparisons() {
		return comparison;
	}
	
	public static void incrementComparison() {
		comparison++;
	}
	
	public void setComparison(int number) {
		comparison = number;
	}
}
