import java.io.*;
import java.util.*;

public class Main{

	private static int n, m, h, ans = -1;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int[][][] ladder = new int[n+2][n+2][h+1]; // 사다리를 표현할 3차원 배열.
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[b][b+1][a] = ladder[b+1][b][a] = 1; // 다리가 놓여져 있으면 1로 표현.
		}
		fabricate(ladder, 2, 1, 0);
		System.out.println(ans);
		br.close();
	}

	/*
	다리를 잇는 모든 경우의 수를 따질 완전탐색 메소드.
	ladder: 사다리의 방향성과 층을 표현한 배열, start: 다리를 놓을지 판단할 사다리, layer: 다리를 놓을지 판단할 층, count: 다리를 놓은 수
	*/
	private static void fabricate(int[][][] ladder, int start, int layer, int count){

		// 다리의 개수가 3개를 넘거나 층이 가장 아랫층 보다 아래면 메소드 탈출.
		if(count > 3 || layer > h) return ;

		// 사다리를 순서가 사다리의 개수 보다 커지면 사다리 순서 초기화 후 층을 한층 아래로 세팅해 메소드 재귀호출.
		if(start > n){
			fabricate(ladder, 2, layer+1, count);
			return ;
		}

		// 사다리가 조작이 성공적인지 확인하는 반복문.
		for(int i = 1; i <= n; i++){

			// 각각의 사다리를 getResult 메소드로 조작이 잘되었는지 확인.
			if(!getResult(ladder, i)){
				if(count == 3) return ; // 조작이 안되었는데 다리 3개를 놓았다면 메소드 탈출.
				break; // 조작이 안되었으면 반복문 탈출.
			}

			if(i == n){ // 마지막 사다리 까지 조작이 잘되었다면 최소 다리의 개수 도출 후 메소드 탈출.
				if(ans == -1) ans = count;
				else ans = Math.min(ans, count);
				return ;
			}
		}

		// 양옆이 다리가 이어져 있지 않고, 현재 다리를 놓을 자리에 다리가 없다면 다리를 놓은 후 메소드 재귀호출.
		if(ladder[start-2][start-1][layer] == 0 &&
			ladder[start+1][start][layer] == 0 &&
			ladder[start][start-1][layer] == 0){

			ladder[start][start-1][layer] = ladder[start-1][start][layer] = 1;
			fabricate(ladder, start, layer, count+1); // 다리를 놓았을 경우.
			ladder[start][start-1][layer] = ladder[start-1][start][layer] = 0;
		}
		fabricate(ladder, start+1, layer, count); // 다리를 안놓았을 경우.
	}

	// ladder: 사다리의 방향성과 층을 표현한 배열, num: 사다리 번호.
	private static boolean getResult(int[][][] ladder, int num){

		int cur = num; // 사다리를 타고 내려가는 값을 표현한 변수.

		for(int layer = 1; layer <= h; layer++){

			// 다리가 오른쪽에 놓여있다면 +1, 왼쪽에 놓여있다면 -1.
			if(ladder[cur][cur+1][layer] == 1) cur = cur + 1;
			else if(ladder[cur-1][cur][layer] == 1) cur = cur - 1;
		}

		return cur == num ? true : false; // 사다리를 타고 내려온 값과 사다리 번호가 일치하면 true 반환, 아니면 false 반환.
	}
}