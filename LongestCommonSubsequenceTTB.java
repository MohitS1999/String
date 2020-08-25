import java.util.*;
public class LongestCommonSubsequenceTTB{
	public static void main(String ars[]){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String x=sc.next();
			String y=sc.next();
			int m=x.length();
			int n=y.length();
			int dp[][]=new int[m+1][n+1];
			commonSubsequence(x,y,m,n,dp);
			//find out the longest common subsequence
			int i=m;
			int j=n;
			String s="";
			while (i!=0 && j!=0){
				if (x.charAt(i-1)==y.charAt(j-1)){
					s=Character.toString(x.charAt(i-1))+s;
					i--;
					j--;
				}else {
					if (dp[i-1][j]>dp[i][j-1]) i--;
					else j--;
				}
			}
			if (s.length()==0) System.out.println("Nothing common in string");
			else System.out.println(s);
			
		}
	}
	public static int commonSubsequence(String x,String y,int m,int n,int[][] dp){
		//Base condition
		if (m==0 || n==0) return 0;
		//Memorization
		if (dp[m][n]!=0) return dp[m][n];
		
		if (x.charAt(m-1)==y.charAt(n-1)){
			return dp[m][n]=commonSubsequence(x,y,m-1,n-1,dp)+1;
		}
		else{
			return dp[m][n]=Math.max(commonSubsequence(x,y,m-1,n,dp),commonSubsequence(x,y,m,n-1,dp));
		}
	}
}