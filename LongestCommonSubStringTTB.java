import java.util.*;
public class LongestCommonSubStringTTB{
	static int indexI=0;
	static int indexJ=0;
	static int  max=0;
	public static void main(String[] arhs){
		Scanner sc=new Scanner (System.in);
			String a=sc.next();
			String b=sc.next();
			int m=a.length();
			int n=b.length();
			int dp[][]=new int[m+1][n+1];
			String s="";
			commonSubstring(a,b,m,n,dp);
			//find the common substring from the dp matrix
			while (dp[indexI][indexJ]!=0){
				s=a.charAt(indexI-1)+s;
				indexI--;
				indexJ--;
			}
			System.out.println(s);
		
	}
	public static int commonSubstring(String a,String b,int m,int n,int[][] dp){
		//Base Condition
		if (m==0 || n==0 ) return 0;
		
		// Memorization
		if (dp[m][n]!=0) return dp[m][n];
		//iterate it m*n times
		commonSubstring(a,b,m-1,n,dp);
		commonSubstring(a,b,m,n-1,dp);
		
		if (a.charAt(m-1)==b.charAt(n-1)){
			dp[m][n]=commonSubstring(a,b,m-1,n-1,dp)+1;
			if (max<dp[m][n]){
				max=dp[m][n];
				indexI=m;
				indexJ=n;
			}
			return dp[m][n];
		}
		return dp[m][n]=0;
	}
}
