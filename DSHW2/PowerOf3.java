public class PowerOf3 {
	private static void powerOf3Helper(char[] arr, int start, int end, int l, int row) {
		int interval = l/3;
		if(interval == 0 || row <= 0) {
			return;
		}
		for(int i = start + interval; i < end - interval + 1; i++) {
			arr[i] = ' ';
		}
		powerOf3Helper(arr, start, start + interval-1, interval, row-1);
		powerOf3Helper(arr, start + 2*interval, end, interval, row-1);
	}
	public static void powerOf3(String str) {
		if(1162261467 % str.length() != 0) {
			/* The maximum power of 3 value that  
           integer can hold is 1162261467 ( 3^19 ) .*/
           System.out.println("The length should be a power of 3");
           return;
		}
		int length = str.length();
		int k = (int)(Math.log(length)/Math.log(3));

		char[] theSet = new char[length];
		for(int i = 0; i < k+1; i++) {
			powerOf3Helper(theSet, 0, length - 1, length, i);
			for(int j = 0; j < theSet.length; j++) {
				if(theSet[j] == ' '){
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {

		powerOf3("*");
		powerOf3("***");
		powerOf3("******");
		powerOf3("*********");
		powerOf3("***************************");
		powerOf3("*********************************************************************************");
		//my screen is too small for 81 :'(
		powerOf3("*****************************************************************************"); //wrong input
	}
}