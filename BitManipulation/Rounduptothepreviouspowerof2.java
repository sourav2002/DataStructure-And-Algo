package BitManipulation;

class Main
{
	// Compute a power of two less than or equal to `n`
	public static int findPreviousPowerOf2(int n)
	{
		// initialize result by 1
		int k = 1;

		// double `k` and divide `n` in half till it becomes 0
		while ((n >>= 1) != 0) {
			k = k << 1;	// double `k`
		}

		return k;
	}

	public static void main(String[] args)
	{
		int n = 127;

		System.out.println("The previous power of 2 is " + findPreviousPowerOf2(n));
	}
}