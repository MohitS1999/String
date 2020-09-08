import java.util.*;
public class MinNoOfInsertionAndDeletionConvertATOB_TTB{
	public static void main(String[] arhs){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			String b=sc.next();
			int m=a.length();
			int n=b.length();
			int dp[][]=new int[m+1][n+1];
			int commonSubsequence=LCS(a,b,m,n,dp);
			System.out.println("Minimum number of Insertion to convert A to B :- "+(n-commonSubsequence));
			System.out.println("Minimum number of Deletion to convert A to B :- "+(m-commonSubsequence));
		}
	}
	public static int LCS(String a,String b,int m,int n,int[][] dp){
		//Base Condition
		if (m==0 || n==0){
			return 0;
		}
		//Memorization
		if (dp[m][n]!=0) return dp[m][n];
		
		if (a.charAt(m-1)==b.charAt(n-1)){
			return dp[m][n]=LCS(a,b,m-1,n-1,dp)+1;
		}else{
			return dp[m][n]=Math.max(LCS(a,b,m-1,n,dp),LCS(a,b,m,n-1,dp));
		}
	}
}