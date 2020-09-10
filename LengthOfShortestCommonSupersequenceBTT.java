import java.util.*;
public class LengthOfShortestCommonSupersequenceBTT{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			String b=sc.next();
			int m=a.length();
			int n=b.length();
			int commonLen=commonSubsequence(a,b,m,n);
			System.out.println(m+n-commonLen);
		}
		
	}
	//Longest Common Subsequence
	public static int commonSubsequence(String a,String b,int m,int n){
		int dp[][]=new int[m+1][n+1];
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				if (a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][n]; 	
	}
}
