public class PowerOf3 {
	private static void powerOf3Helper(char[][] arr, int start, int l, int index) {
		int interval = l/3;
		if(interval == 0) {
			return;
		}
		for (int i = index; i < arr.length; i++) {
            for (int j = start + interval; j < start + interval * 2; j++) {
                arr[i][j] = ' ';
            }
        }

        powerOf3Helper(arr, start, interval, index + 1);
        powerOf3Helper(arr, start + interval * 2, interval, index + 1);
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

		char[][] theSet = new char[k+1][length];
		powerOf3Helper(theSet, 0, length, 1);

		for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < length; j++) {
            	if(theSet[i][j] != ' ') {
            		System.out.print(str.charAt(0));
            	} else {
            		System.out.print(theSet[i][j]);
            	}
            }
            System.out.println();
        }
	}
	public static void main(String args[]) {
		DevilsStaircase("*");
		DevilsStaircase("***");
		DevilsStaircase("******");
		DevilsStaircase("*********");
		DevilsStaircase("***************************");
		DevilsStaircase("*********************************************************************************");
		//my screen is too small for 81 :'(
		DevilsStaircase("*****************************************************************************"); //wrong input
	}
}