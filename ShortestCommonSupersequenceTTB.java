import java.util.*;
public class ShortestCommonSupersequenceTTB{
	public static void main(String[] args){
		Scanner sc= new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			String b=sc.next();
			int m=a.length();
			int n=b.length();
			int dp[][]=new int[m+1][n+1];
			LCS(a,b,m,n,dp);
			int i=m;
			int j=n;
			String s="";
			while (i!=0 && j!=0){
				if (a.charAt(i-1)==b.charAt(j-1)){
					s=a.charAt(i-1)+s;
					i--;
					j--;
				}else{
					if  (dp[i-1][j]<dp[i][j-1]){
						s=b.charAt(j-1)+s;
						j--;
					}else{
						s=a.charAt(i-1)+s;
						i--;
					}
				}
			}
			while (i!=0){
				s=a.charAt(i-1)+s;
				i--;
			}
			while (j!=0){
				s=a.charAt(j-1)+s;
				j--;
			}
			System.out.println(s);
		}
	}
	public static int LCS(String a,String b,int m,int n,int[][] dp){
		if (m==0||n==0) return 0;
		if (dp[m][n]!=0) return dp[m][n];
		if (a.charAt(m-1)==b.charAt(n-1))
			return dp[m][n]=LCS(a,b,m-1,n-1,dp)+1;
		else 
			return dp[m][n]=Math.max(LCS(a,b,m-1,n,dp),LCS(a,b,m,n-1,dp));
	}
}