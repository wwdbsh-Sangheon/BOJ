import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine().replace(br.readLine(), "`"); // 문서내 찾아야할 모든 단어를 ₩로 치환.

		int ans = 0;

		for(int i = 0; i < doc.length(); i++){
			if(doc.charAt(i) == '`') ans++;
		}
		System.out.println(ans);
		br.close();
	}
}