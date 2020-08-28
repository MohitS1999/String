import java.util.*;
public class LongestPalidromicSubstring{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while (t-->0){
			String s=sc.next();
			System.out.println(longPalindrome(s));
		}
	}
	public static String longPalindrome(String s){
		if (s.length()==0) return "";
		String newStr=Character.toString(s.charAt(0));
		int max=0;
		
		for (int i=0;i<s.length()-1;i++){
			for (int j=i+1;j<s.length();j++){
				String substr=s.substring(i,j+1);
				int checkPalin=checkPalindrome(substr);
				if (max<checkPalin) {
					newStr=substr;
					max=checkPalin;
				}
			}
		}
		return newStr;
	}
	public static int checkPalindrome(String s){
		int i=0;
		int j=s.length()-1;
		while (i<j){
			if (s.charAt(i)!=s.charAt(j) ) return 0;
			i++;
			j--;
		}
		return s.length();
	}
}