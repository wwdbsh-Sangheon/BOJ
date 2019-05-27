import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i = n-1; i >= 0; i--){
			coin[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0, ans = 0;

		while(k != 0){

			if(k >= coin[idx]){ // 동전의 가치가 k 보다 작거나 같다면 k에서 빼준후 개수 1 증가.

				k -= coin[idx];
				ans++;
			}else{ // 아니면 idx 1증가.

				idx++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}