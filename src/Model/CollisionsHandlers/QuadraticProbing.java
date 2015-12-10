package Model.CollisionsHandlers;

public class QuadraticProbing {
	public static int findQuadraticProbingIndex (int key, int [] data, int initialHashAddress) {
		int j = initialHashAddress;
		int i = 0;
		while ((data[j]!= key) && (data[j] != 0)) {
			i++;
			j = (initialHashAddress + i*i) % data.length;
			if (i > (data.length-1) / 2) {
				return -1;
			}
		}
		return j;
	}
}
