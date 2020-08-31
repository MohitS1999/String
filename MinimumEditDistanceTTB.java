import java.util.*;
public class MinimumEditDistanceTTB{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		String a=sc.next();
		String b=sc.next();
		int m=a.length();
		int n=b.length();
		int dp[][]=new int[m+1][n+1];
		System.out.println(minEditDis(a,b,m,n,dp));
	}
	public static int minEditDis(String a,String b,int m,int n,int[][] dp){
		//whenever the len of both the string is 0
		if (m==0 && n==0) return 0;
		//len of m string is 0
		if (m==0 && n>0) return n;
		//len of n string is 0
		if (m>0 && n==0) return m;
		if (dp[m][n]!=0) return dp[m][n];
		if (a.charAt(m-1)==b.charAt(n-1)){
			return dp[m][n]=minEditDis(a,b,m-1,n-1,dp);
		}
		return dp[m][n]=Math.min(minEditDis(a,b,m-1,n-1,dp),Math.min(minEditDis(a,b,m-1,n,dp),minEditDis(a,b,m,n-1,dp)))+1;
	} 
}
