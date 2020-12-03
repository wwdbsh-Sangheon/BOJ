import java.io.*;
import java.util.*;

public class Main{

	private static double[] p = new double[4];
	private static boolean[][] chk = new boolean[31][31]; // 최대 14번 행동을 취할수 있기 때문에 시작점을 (15,15)로 지정하고, 전체 지도 크기를 30x30으로 정해준다.
	private static int[] dx = {0, 0, 1, -1}; // 동서남북
	private static int[] dy = {1, -1, 0, 0};
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; i++){
			p[i] = Integer.parseInt(st.nextToken()) / 100.0; // 동서남북 각각 확률을 계산해서 배열에 넣어준다.
		}
		chk[15][15] = true; // 시작지점으로 돌아올 일은 없으니 체크해준다.
		System.out.println(getProbability(15, 15, 0));
		br.close();
	}

	// dfs. x: x좌표, y: y좌표, count: 행동을 취한 횟수.
	private static double getProbability(int x, int y, int count){

		double ret = 0.0;

		// 행동을 모두 취했을시 1.0을 반환해준다. 재귀호출로 누적된 확률값을 얻으려면 마지막에 1.0을 곱해줘야 한다.
		if(count == n){
			return 1.0;
		}

		for(int i = 0; i < 4; i++){

			int ax = x + dx[i];
			int ay = y + dy[i];

			if(ax > 0 && ax <= 30 && ay > 0 && ay <= 30){

				// 방문한 지점은 다시 방문하지 않는다.
				if(!chk[ax][ay]){
					chk[ax][ay] = true;
					ret += getProbability(ax, ay, count+1) * p[i]; // 최종적으로 하나의 경우 마다 1.0 * p1 * p2 * ... * pn의 형태를 가진다.
					chk[ax][ay] = false;
				}
			}
		}

		return ret;
	}
}