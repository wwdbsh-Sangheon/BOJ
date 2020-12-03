import java.io.*;
import java.util.*;

public class Main{

	private static int[][] power;
	private static boolean[] member;
	private static int n, ans = 987654321;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		power = new int[n+1][n+1];
		member = new boolean[n+1];
		for(int i = 1; i <= n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++){
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 0);
		System.out.println(ans);
		br.close();
	}

	// idx: 중복을 피하기 위한 색인(오름차순 뽑기), c: 뽑힌 인원의 수
	private static void dfs(int idx, int c){

		// 각 팀의 정원은 무조건 전체 인원의 반이기 때문에 n/2 만큼만 메소드를 호출하면 된다.
		if(c == n / 2){

			int start = 0, link = 0;

			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= i; j++){
					if(member[i] && member[j]){ // 뽑힌 멤버들 -> start팀
						start += power[i][j] + power[j][i];
					}
					if(!member[i] && !member[j]){ // 안뽑힌 멤버들 -> link팀
						link += power[i][j] + power[j][i];
					}
				}
			}
			ans = Math.min(ans, Math.abs(start - link)); // 최솟값 도출.
			return ;
		}

		// 뽑힐 멤버를 정할 완전탐색 dfs.
		for(int i = idx; i <= n; i++){

			if(!member[i]){
				member[i] = true;
				dfs(i+1, c+1);
				member[i] = false;
			}
		}
	}
}