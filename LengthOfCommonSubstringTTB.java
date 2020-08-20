import java.util.*;
public class LengthOfCommonSubstringTTB{
	static int ans=0;
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String x=sc.next();
			String y=sc.next();
			int dp[][]=new int[x.length()+1][y.length()+1];
			for (int i=0;i<x.length()+1;i++)
				Arrays.fill(dp[i],-1);
			commonSubstring(x,y,x.length(),y.length(),dp);
			System.out.println(ans);
			ans=0;
		}
	}
	public static int commonSubstring(String x,String y,int n,int m,int[][] dp){
		if (n==0 || m==0) return 0;
		if (dp[n][m]!=-1) return dp[n][m];
		
		//Traverse the whole string one by one n*m
		commonSubstring(x,y,n,m-1,dp);
		commonSubstring(x,y,n-1,m,dp);
		if (x.charAt(n-1)==y.charAt(m-1)) 
		{
			dp[n][m]=commonSubstring(x,y,n-1,m-1,dp)+1;
			ans=Math.max(ans,dp[n][m]);
			return dp[n][m];
		}
		return dp[n][m]=0;
	}
}
