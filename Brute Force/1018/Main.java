import java.io.*;
import java.util.*;

public class Main{

	private static int[][] board;
	private static boolean[][] chk;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, m, ans = 987654321;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m]; // W: 0, B: 1
		chk = new boolean[n][m];
		for(int i = 0; i < n; i++){
			int j = 0;
			for(char c : br.readLine().toCharArray()){
				if(c == 'B') board[i][j] = 1;
				j++;
			}
		}

		// 왼쪽 위 모서리를 기준으로 8x8 크기에 맞춰 순회.
		for(int i = 0; i <= n - 8; i++){
			for(int j = 0; j <= m - 8; j++){
				// 왼쪽 위 모서리가 'W'일 경우와 'B'일 경우 각각 bfs 순회를 시켜 얻어 횟수 중 작은값과 기존 ans값과 비교 후 최솟값 도출.
				ans = Math.min(ans, Math.min(bfs(board[i][j], i, j, 0), bfs(Math.abs(board[i][j]-1), i, j, 1)));
			}
		}
		System.out.println(ans);
		br.close();
	}

	// color: 정사각형의 색, x: x좌표, y: y좌표, count: 다시 칠한 정사각형 갯수
	private static int bfs(int color, int x, int y, int count){

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(color, x, y));
		chk[x][y] = true;

		while(!queue.isEmpty()){

			Node node = queue.poll();

			for(int i = 0; i < 4; i++){

				int ax = node.x + dx[i];
				int ay = node.y + dy[i];

				if(ax >= x && ax < x + 8 && ay >= y && ay < y + 8){

					if(!chk[ax][ay]){

						// 현재 정사각형과 근접한 정사각형의 색이 같다면 count 증가.
						if(node.color == board[ax][ay]) count++;
						// 색을 0과 1로 표현했으므로, 근접한 정사각형의 색은 기존 색에서 1을 뺀 절대값으로 지정(기존 값에 대하여 무조건 반대값이 됨).
						queue.offer(new Node(Math.abs(node.color - 1), ax, ay));
						chk[ax][ay] = true;
					}
				}
			}
		}
		chk = new boolean[n][m]; // 체크 배열 초기화.

		return count;
	}

	private static class Node{

		private int color, x, y;

		private Node(int color, int x, int y){

			this.color = color;
			this.x = x;
			this.y = y;
		}
	}
}