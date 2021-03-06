import java.util.*;
public class LengthOfLongestPalindromeSubsequenceBTT{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			StringBuffer sb=new StringBuffer();
			sb.append(a);
			//reverse the string
			
			sb.reverse();
			
			//function call
			System.out.println(palindromeSub(a,sb.toString()));
		}
	}
	//LCS
	public static int palindromeSub(String a,String b){
		int m=a.length();
		int dp[][]=new int[m+1][m+1];
		for (int i=1;i<=m;i++){
			for (int j=1;j<=m;j++){
				if (a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][m];
	}
}
