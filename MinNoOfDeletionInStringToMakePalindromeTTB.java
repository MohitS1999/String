import java.util.*;
public class MinNoOfDeletionInStringToMakePalindromeTTB{
	public static void main(String[] arhs){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			StringBuffer sb=new StringBuffer();
			sb.append(a);
			sb.reverse();
			int m=a.length();
			int dp[][]=new int[m+1][m+1];
			int LongestPalindrome=longestPalindrome(a,sb.toString(),m,m,dp);
			System.out.println("Min Deletion required to make string palindromic :-  "+(m-LongestPalindrome));
		}
	}
	//LCS
	public static int longestPalindrome(String a,String b,int m,int n,int dp[][]){
		if (m==0|| n==0) return 0;
		if (dp[m][n]!=0) return dp[m][n];
		if (a.charAt(m-1)==b.charAt(n-1)){
			return dp[m][n]=longestPalindrome(a,b,m-1,n-1,dp)+1;
		}else
			return dp[m][n]=Math.max(longestPalindrome(a,b,m-1,n,dp),longestPalindrome(a,b,m,n-1,dp));
	}
}
