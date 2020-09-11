import java.util.*;
public class ShortestCommonSupersequenceBTT{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			String b=sc.next();
			System.out.println(shortestsubseq(a,b));
		
	}
	public static String shortestsubseq(String a,String b){
		int m=a.length();
		int n=b.length();
		int dp[][]=new int[m+1][n+1];
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				if (a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		int i=m;
		int j=n;
		String s="";
		while (i!=0 && j!=0){
			if (a.charAt(i-1)==b.charAt(j-1)){
				s=a.charAt(i-1)+s;
				i--;
				j--;
			}else{
				if (dp[i-1][j]>dp[i][j-1]){
					s=a.charAt(i-1)+s;
					i--;
				}else{
					s=b.charAt(j-1)+s;
					j--;
				}
			}
		}
		//remaining character
		while (i!=0){
			s=a.charAt(i-1)+s;
			i--;
		}
		while (j!=0){
			s=s.charAt(j-1)+s;
			j--;
		}
		return s;
	}
}
