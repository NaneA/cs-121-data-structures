public class StaircaseOfCubes {
	private static double nChooseK(int x, int y) {
	    if (y < 0 || y > x) {
	    	return 0;
	    }
	    if (y > x/2) {
	        // choose(n,k) == choose(n,n-k),
	        y = x - y;
	    }
	    double d = 1.0, n = 1.0;
	    for (int i = 1; i <= y; i++) {
	        d *= i;
	        n *= (x + 1 - i);
	    }
	    return n / d;
	}

	private static int P(int n, int k) {
		//see http://mathworld.wolfram.com/PartitionFunctionP.html
		if(k > n || k == 0) {
			return 0;
		} else if(n == k) {
			return 1;
		}

		return P(n-1, k-1) + P(n-k, k);
	}

	private static int Q(int n, int k) {
		// see http://mathworld.wolfram.com/PartitionFunctionQ.html
		return P(n - (int)nChooseK(k, 2), k);
	}

	public static int numStaircaseOfCubes(int n) {
		/*
			In every possible combination we use exactly n blocks, therefore the sum of 
			blockes should be n regardless of the way we count them. Since every level 
			is different form others, this is just the number of ways of writing the 
			integer n as a sum of positive integers without regard to order with the
			constraint that all integers in a given partition are distinct. This is a 
			well known math problem.

			See http://mathworld.wolfram.com/PartitionFunctionQ.html
		*/
		if(n <= 0) {
			//let's assume it is 0 and 
			return 0;
		}
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += Q(n, i);
		}
		return sum;
	}

	public static void main(String[] args) {
		for(int i = -1; i < 30; i++) {
			System.out.println(numStaircaseOfCubes(i));
		}
	}
}