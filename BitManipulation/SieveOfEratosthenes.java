package BitManipulation;
import java.util.Scanner;

// Java program to print all primes smaller than or equal to
// n using Sieve of Eratosthenes
class SieveOfEratosthenes
{
	void sieveOfEratosthenes(int n)
	{
		// Create a boolean array "prime[0..n]" and initialize
		// all entries it as true. A value in prime[i] will
		// finally be false if i is Not a prime, else true.
		boolean prime[] = new boolean[n+1];
		for(int i=0;i<=n;i++)
			prime[i] = true;
		
		for(int p = 2; p*p <=n; p++)
		{
			// If prime[p] is not changed, then it is a prime
			if(prime[p] == true)
			{
				// Update all multiples of p
				for(int i = p*p; i <= n; i += p)
					prime[i] = false;
			}
		}
		
		// Print all prime numbers
		for(int i = 2; i <= n; i++)
		{
			if(prime[i] == true)
				System.out.print(i + " ");
		}
	}
	public static void main(String args[])
	{
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.print("Following are the prime numbers ");
			System.out.println("Smaller than or equal to " + n);
			SieveOfEratosthenes g = new SieveOfEratosthenes();
			g.sieveOfEratosthenes(n);
		}
	}
}

// This code has been contributed by Amit Khandelwal.
