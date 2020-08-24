import java.util.*;
public class LongestCommonSubsequenceBTT{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-->0){
			String x=sc.next();
			String y=sc.next();
			System.out.println(commonSubsequence(x,y,x.length(),y.length()));
		}
	}
	public static String commonSubsequence(String x,String y,int m,int n){
		int dp[][]=new int[m+1][n+1];
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				if (x.charAt(i-1)==y.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		String s="";
		int i=m;
		int j=n;
		while (i!=0 && j!=0){
			if (x.charAt(i-1)==y.charAt(j-1)){
				s=Character.toString(x.charAt(i-1))+s;
				i--;
				j--;
			}else{
				if (dp[i-1][j]>dp[i][j-1]) i--;
				else j--;
			}
		}
		return s;
	}
}