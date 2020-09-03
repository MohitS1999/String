import java.util.*;
public class LengthOfCommonSubstringBTT{
	public static void main(String[] arhs){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String x=sc.next();
			String y=sc.next();
			System.out.println(commonSubstring(x,y,x.length(),y.length()));
		}
	}
	
	//With memorization
	public static int commonSubstring(String x,String y,int n,int m){
		int dp[][]=new int[n+1][m+1];
		int res=0;
		for (int i=0;i<n;i++){
			for (int j=0;j<m;j++){
				if (x.charAt(i)==y.charAt(j))
				{       
					//if the character is same from both the string
					dp[i+1][j+1]=dp[i][j]+1;
					res=Math.max(res,dp[i+1][j+1]);
				}
			}
		}
		return res;
	}
	
}
