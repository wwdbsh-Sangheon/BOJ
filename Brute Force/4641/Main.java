import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){

			String input = br.readLine();
			if(input.equals("-1")) break;

			st = new StringTokenizer(input);
			int n = st.countTokens(), ans = 0;
			int[] list = new int[n];

			for(int i = 0; i < n; i++){
				list[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(list); // 수행시간의 효율을 위해 오름차순 정렬.(정렬을 통해 자신 보다 작은 수는 검사하지 않음으로써 O(n^2)을 피한다)

			for(int i = 0; i < n; i++){
				for(int j = i+1; j < n; j++){
					if(list[i]*2 == list[j]){
						ans++;
						break;
					}
				}
			}
			System.out.println(ans);
		}
		br.close();
	}
}