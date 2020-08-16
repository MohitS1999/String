import java.util.*;
public class LengthOfCommonSubsequenceTTB{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-->0){
			String x=sc.next();
			String y=sc.next();
			//int[][] dp=new int[x.length()+1][y.length()+1];
			System.out.println(CommonSubsequence(x,y));
		}
	}
    public static int CommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[m+1][n+1];
        return lcs(text1,text2,m,n,dp);
    }
     public static int lcs(String x,String y,int m,int n,int[][] dp){
		// Base COndition
        if (m==0 || n==0) return 0;
		// Memorization
        if (dp[m][n]!=0) return dp[m][n];
		// if both the character is same from the last of the string
        if (x.charAt(m-1)==y.charAt(n-1))
            return dp[m][n]=lcs(x,y,m-1,n-1,dp)+1;
        else 
			// if not,then we  reduce by 1 from  both the string one by one
            return dp[m][n]=Math.max(lcs(x,y,m-1,n,dp),lcs(x,y,m,n-1,dp));
    }
}