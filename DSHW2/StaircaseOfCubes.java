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
		//Count the number of k-partitions of n. For example, 7 can be written with
		//two summands 3 ways 1+6, 2+5, and 3+4, therefore P(7, 2)=3
		if(k > n || k == 0) {
			return 0;
		} else if(n == k) {
			return 1;
		}
		/*  
			First, we count the number of all partitions of n that has 1 in them (i.e. 1+x)
			since this is the same as the number of partitions of n-1 (=x) with k-1 length,
			in other words, if we take the set of all k-1 length partitions of n-1 and add 1 to each
			we will get sets of length k with sum n.

			Second, now we count the number of partitions that do not have 1 in them,
			since all summands are bigger then 1, we can subtract one from each, we keep the equality
			we should also subtract k from n. For example 7=2+5, 7=3+4 => 6=1+4, 6=2+3

			The we add (First) and (Second), since partition either contains 1 or not.
		*/ 

		return P(n-1, k-1) + P(n-k, k);
	}

	private static int Q(int n, int k) {
		// see http://mathworld.wolfram.com/PartitionFunctionQ.html
		// Fix the 
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