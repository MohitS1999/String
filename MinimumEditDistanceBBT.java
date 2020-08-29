//Leetcode 
import java.util.*;
public class MinimumEditDistanceBBT{
	public static void main(String[] arhs){
		Scanner sc=new Scanner (System.in);
		String a=sc.next();
		String b=sc.next();
		System.out.println(minEditDis(a,b,a.length(),b.length()));
	}
	//function
	public static int minEditDis(String a,String b ,int m,int n){
		int dp[][]=new int[m+1][n+1];
		for (int i=0;i<=m;i++){
			for (int j=0;j<=n;j++){
				if (i==0 || j==0){
					if (i==0 && j>0)
						dp[i][j]=j;
					if (i>0 && j==0)
						dp[i][j]=i;
				}else{
					//if both character same then we will not do any changes in string
					if (a.charAt(i-1)==b.charAt(j-1)){
						dp[i][j]=dp[i-1][j-1];
					}else{
						dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
					}
				}
			}
		}
		return dp[m][n];
	}
}
