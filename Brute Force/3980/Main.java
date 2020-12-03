import java.io.*;
import java.util.*;

public class Main{

	private static int[][] stats;
	private static boolean[] chk;
	private static int ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){

			stats = new int[11][11];
			chk = new boolean[11];

			for(int i = 0; i < 11; i++){

				st = new StringTokenizer(br.readLine());

				for(int j = 0; j < 11; j++){
					stats[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			setPosition(0, 0, 0);
			System.out.println(ans);
			ans = 0;
		}
		br.close();
	}

	// sum: 능력치 합, player: 포지션이 정해지지 않은 선수들 중 가장 먼저인 선수, count: 포지션이 정해진 선수의 수.
	private static void setPosition(int sum, int player, int count){

		// 포지션이 모두 정해졌다면 재귀탈출.
		if(count == 11){
			ans = Math.max(ans, sum);
			return ;
		}

		for(int i = player; i < 11; i++){
			for(int j = 0; j < 11; j++){
				// i번째 선수의 j 포지션 능력이 0이라면 스킵. 
				if(stats[i][j] == 0) continue;
				// 아직 포지션이 선수에게 배정되지 않았을시 선수 배정.
				if(!chk[j]){
					chk[j] = true;
					setPosition(sum+stats[i][j], i+1, count+1);
					chk[j] = false;
				}
			}
		}
	}
}