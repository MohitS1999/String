import java.util.*;
public class LongestCommonSubStringBTT{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			String b=sc.next();	
			System.out.println(commonSubstring(a,b));
		}
	}
	public static String commonSubstring(String a,String b){
		int m=a.length();
		int n=b.length();
		int dp[][]=new int[m+1][n+1];
		int indexI=0;
		int indexJ=0;
		int max=0;
		for (int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				if (a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
					if (max<dp[i][j]){
						max=dp[i][j];
						indexI=i;
						indexJ=j;
					}
				}
				else dp[i][j]=0;
			}
		}
		//longest substring
		String s="";
		while (dp[indexI][indexJ]!=0){
			s=a.charAt(indexI-1)+s;
			indexI--;
			indexJ--;
		}
		return s;
	} 
}
