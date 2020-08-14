import java.util.*;
import java.io.*;
public class ReverseTheString{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
			String s=br.readLine();
			String res=new String();
			int i=0;
			int n=s.length();
			while (i<n){
				while (i<n && s.charAt(i)==' ') i++;
				if (i>=n) break;
				int j=i+1;
				while (j<n && s.charAt(j)!=' ') j++;
				String sub=s.substring(i,j);
				res=(res.length()==0) ? sub : sub+" "+res;
				i=j+1;
			}
			System.out.println(res);
		}
		
	}
}