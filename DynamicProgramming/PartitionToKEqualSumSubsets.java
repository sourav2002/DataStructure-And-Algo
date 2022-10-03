/*
Given an integer array and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
*/
import java.io.*;
import java.util.*;
class PartitionToKEqualSumSubsets{
    public static boolean help(int nums[],boolean visited[],int i,int k,int cs,int ts)
    {
        if(k==0)
            return true;
        if(cs>ts)
            return false;
        if(cs==ts)
            return help(nums,visited,0,k-1,0,ts);
        for(int j=i;j<nums.length;j++)
        {
            if(visited[j])
                continue;
            visited[j]=true;
            if(help(nums,visited,j+1,k,cs+nums[j],ts))
                return true;
            visited[j]=false;
        }
        return false;
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int s=0;
        for(int i:nums)
            s+=i;
        if(s%k!=0)
            return false;
        boolean visited[]=new boolean[nums.length];
        return help(nums,visited,0,k,0,s/k);
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size");
		int n=sc.nextInt();
		System.out.println("Enter array values");
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		  a[i]=sc.nextInt();
		System.out.println("Enter number of subsets");
		int k=sc.nextInt();
		if(canPartitionKSubsets(a,k))
		  System.out.println("Yes it can be partioned into "+k+" subsets of equal sum");
		else
		   System.out.println("No, it cannot be partioned into "+k+" subsets of equal sum");
	}
}
