import java.io.*;
import java.util.*;

public class Main{
	// 두구슬의 각각 방문한 지점을 체크하기 위한 4차원 불린 배열.(즉, 각각의 모든 경우의 수를 체크하기 위한 배열)
	private static boolean[][][][] chk;
	private static int[][] board;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, m, hx, hy; // 구멍의 위치를 위한 변수.

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chk = new boolean[n][m][n][m];
		board = new int[n][m];
		int rx = 0, ry = 0, bx = 0, by = 0; // 빨간구슬과 파란구슬의 시작점을 저장하기 위한 변수.
		for(int i = 0; i < n; i++){
			String input = br.readLine();
			for(int j = 0; j < m; j++){

				switch(input.charAt(j)){

					case 'R': // 빨간구슬 시작점 저장.
						rx = i;
						ry = j;
						break;
					case 'B': // 파란구슬 시작점 저장.
						bx = i;
						by = j;
						break;
					case 'O': // 구멍 위치 저장.
						hx = i;
						hy = j;
						break;
					case '#': // 벽 표시.
						board[i][j] = 1;
				}
			}
		}
		System.out.println(bfs(rx, ry, bx, by));
		br.close();
	}

	// rx: red x, ry: red y, bx: blue x, by: blue y
	private static int bfs(int rx, int ry, int bx, int by){

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(rx, ry, bx, by, 0));
		chk[rx][ry][bx][by] = true;

		while(!queue.isEmpty()){

			Node node = queue.poll();

			if(node.bx == hx && node.by == hy) continue; // 파란구슬이 구멍에 빠지면 케이스 버리기.
			if(node.count > 9) break; // bfs는 결과값을 리턴할때 이 지점에서의 count 보다 1을 증가한 값을 리턴시킨다. 즉, count가 9 보다 크다면 반복문 탈출.

			// 상,하,좌,우 경우를 위한 반복문.
			for(int i = 0; i < 4; i++){
				
				// 어떤 경우가 되든 일단 빨간구슬과 파란구슬의 위치를 갱신한 노드 생성.
				Node n = move(node.rx, node.ry, node.bx, node.by, node.count, i);

				if(n.bx == hx && n.by == hy) continue; // 파란구슬이 구멍에 빠지면 케이스 버리기. 
				if(n.rx == hx && n.ry == hy) return n.count; // 빨간구슬이 구멍에 빠지면 count 반환.
				if(n.rx == n.bx && n.ry == n.by){ // 빨간구슬과 파란구슬의 위치가 겹칠 경우.

					switch(i){
						// 오른쪽 기울이기. x좌표 같음. y좌표 비교.
						case 0 :
							if(node.ry < node.by){
								n.ry--;
							}else{
								n.by--;
							}
							break;
						// 왼쪽 기울이기. x좌표 같음. y좌표 비교.
						case 1 :
							if(node.ry > node.by){
								n.ry++;
							}else{
								n.by++;
							}
							break;
						// 아래 기울이기. y좌표 같음. x좌표 비교.
						case 2 :
							if(node.rx < node.bx){
								n.rx--;
							}else{
								n.bx--;
							}
							break;
						// 위 기울이기. y좌표 같음. x좌표 비교.
						case 3 :
							if(node.rx > node.bx){
								n.rx++;
							}else{
								n.bx++;
							}
					}
				}

				/*
				이전에 거쳤던 경우의 수(빨간구슬과 파란구슬이 각각 어떠한 위치에 있었던 단하나의 경우)가 
				아니라면 큐에 노드 삽입.  그리고 경우의 수 체크.
				*/
				if(!chk[n.rx][n.ry][n.bx][n.by]){
					queue.offer(n);
					chk[n.rx][n.ry][n.bx][n.by] = true;
				}
			}
		}

		return -1; // count > 10 -> -1 반환.
	}

	/*
	구슬의 위치를 갱신하기 위한 메소드.
	rx, ry, bx, by 모두 bfs의 매개변수와 동일한 의미.
	count: 기울인 횟수, type: 기울기 타입(상, 하, 좌, 우)
	*/
	private static Node move(int rx, int ry, int bx, int by, int count, int type){

		// 빨간구슬 위치 갱신.
		while(true){

			// 벽을 만나거나 구멍에 빠질때까지 이동.
			rx += dx[type];
			ry += dy[type];

			// 벽을 만나면 이동해온 반대방향으로 한칸 이동한후 반복문 탈출.
			if(board[rx][ry] == 1){
				rx -= dx[type];
				ry -= dy[type];
				break;
			}
			// 구멍에 빠진다면 반복문 탈출.
			if(rx == hx && ry == hy) break;
		}

		// 파란구슬 위치 갱신. 부연설명은 동일함.
		while(true){

			bx += dx[type];
			by += dy[type];

			if(board[bx][by] == 1){
				bx -= dx[type];
				by -= dy[type];
				break;
			}
			if(bx == hx && by == hy) break;
		}

		return new Node(rx, ry, bx, by, count+1); // 빨간구슬, 파란구슬, 그리고 기울인 횟수의 정보를 가지고 있는 노드 반환.
	}

	// 두구슬과 기울인 횟수에 대한 정보를 가지고 있는 객체를 표현할 클래스.
	private static class Node{

		private int rx, ry, bx, by, count;

		private Node(int rx, int ry, int bx, int by, int count){

			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}
	}
}