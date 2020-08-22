import java.util.*;
public class LengthOfLongestPalindromeSubsequenceTTB{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			StringBuffer sb=new StringBuffer();
			sb.append(a);
			sb.reverse();
			int m=a.length();
			int dp[][]=new int[m+1][m+1];
			System.out.println(palindromeSub(a,sb.toString(),m,m,dp));
		}
	}
	public static int palindromeSub(String a,String b,int m,int n,int dp[][]){
		// Base Condition
		if (m==0 || n==0) return 0;
		// Memorization
		if (dp[m][n]!=0) return dp[m][n];
		// check character of both string is equal or not
		if (a.charAt(m-1)==b.charAt(n-1)){
			return dp[m][n]=palindromeSub(a,b,m-1,n-1,dp)+1;
		}else{
			return dp[m][n]=Math.max(palindromeSub(a,b,m-1,n,dp),palindromeSub(a,b,m,n-1,dp));
		}
		
	}
}
