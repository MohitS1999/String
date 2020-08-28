import java.util.*;
public class LongestPalindromeSubString{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String a=sc.next();
			System.out.println(func(a,a.length()));
			System.out.println(shortestPalindrome(a));
		}
	}
	//Two pointer algo (time complexity O(n^2))
	public static String func(String s,int n){
		int strt=0;
		int end=0;
		int max_Len=1;
		//odd length
		for (int i=0;i<n-1;++i){
			int l=i,r=i;
			while (l>=0 && r<n){
				if (s.charAt(l)==s.charAt(r))
				{	l--;
					r++;
				}
				else 
					break;
			}
			int len=r-l-1;
			if (len > max_Len){
				max_Len=len;
				strt=l+1;
				end=r-1;
			}
		}
		//even length
		for (int i=0;i<n-1;++i){
			int l=i,r=i+1;
			while (l>=0 && r<n){
				if (s.charAt(l)==s.charAt(r)) {
					l--;r++;
				}
				else break;
			}
			int len=r-l-1;
			if (len > max_Len){
				max_Len=len;
				strt=l+1;
				end=r-1;
			}
		}
		//System.out.println(strt+" "+end);
		return s.substring(strt,end+1);
	}
	//Naive approach (Time complexity O(n^3))
	// public static String longPalindrome(String s){
		// if (s.length()==0) return "";
		// String newStr=Character.toString(s.charAt(0));
		// int max=0;
		
		// for (int i=0;i<s.length()-1;i++){
			// for (int j=i+1;j<s.length();j++){
				// String substr=s.substring(i,j+1);
				// int checkPalin=checkPalindrome(substr);
				// if (max<checkPalin) {
					// newStr=substr;
					// max=checkPalin;
				// }
			// }
		// }
		// return newStr;
	// }
	// public static int checkPalindrome(String s){
		// int i=0;
		// int j=s.length()-1;
		// while (i<j){
			// if (s.charAt(i)!=s.charAt(j) ) return 0;
			// i++;
			// j--;
		// }
		// return s.length();
	// }
	public static String shortestPalindrome(String s) {
        if (s.length()<=1) return s;
        int strt=0;
		int end=0;
		int n=s.length();
		int max_Len=1;
		//odd length
		for (int i=0;i<n-1;++i){
			int l=i,r=i;
			while (l>=0 && r<n){
				if (s.charAt(l)==s.charAt(r))
				{	l--;
					r++;
				}
				else 
					break;
			}
			int len=r-l-1;
			if (len > max_Len){
				max_Len=len;
				strt=l+1;
				end=r-1;
			}
		}
		//even length
		for (int i=0;i<n-1;++i){
			int l=i,r=i+1;
			while (l>=0 && r<n){
				if (s.charAt(l)==s.charAt(r)) {
					l--;r++;
				}
				else break;
			}
			int len=r-l-1;
			if (len > max_Len){
				max_Len=len;
				strt=l+1;
				end=r-1;
			}
		}
		//return s.substring(strt,end+1);
        String newStr=s.substring(strt,end+1);
        StringBuffer sb= new StringBuffer();
        sb.append(s);
        sb.delete(strt,end+1);
        for (int i=0;i<sb.length();i++){
            String x=Character.toString(sb.charAt(i));
            newStr=x+newStr+x;
        }
        return newStr;
    }
}
