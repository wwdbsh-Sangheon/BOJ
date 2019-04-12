import java.io.*;
import java.util.*;

public class Main{

	private static ArrayList<Node> city = new ArrayList<Node>();
	private static ArrayList<Node> chicken = new ArrayList<Node>();
	private static int[][] map;
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
		map = new int[n+1][n+1];
		for(int i = 1; i <= n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++){
				
				map[i][j] = Integer.parseInt(st.nextToken());

				// 도시와 치킨집 위치 저장.
				switch(map[i][j]){

					case 1 :
						city.add(new Node(i, j));
						break;
					case 2 :
						chicken.add(new Node(i, j));
				}
			}
		}
		dfs(0, 0); // 함수 호출.
		System.out.println(ans);
		br.close();
	}

	/*
	각각의 도시의 치킨거리를 구하기 위한 bfs.
	x: 도시의 x좌표, y: 도시의 y좌표
	*/
	private static int bfs(int x, int y){

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(x, y));
		chk[x][y] = true;

		while(!queue.isEmpty()){

			Node node = queue.poll();

			for(int i = 0; i < 4; i++){

				int ax = node.x + dx[i];
				int ay = node.y + dy[i];

				if(ax >= 1 && ax <= n && ay >= 1 && ay <= n){

					if(!chk[ax][ay]){

						/*
						치킨집을 만나면 도시와 치킨집 거리 계산한 값 반환.
						아니면 bfs전개.
						*/
						switch(map[ax][ay]){

							case 2 :
								return Math.abs(x - ax) + Math.abs(y - ay);

							default:
								chk[ax][ay] = true;
								queue.offer(new Node(ax, ay));
						}
					}
				}
			}
		}

		return 0;
	}

	/*
	폐업시킬 치킨집을 고르기 위한 dfs.
	idx: 치킨집 리스트의 색인을 위한 값, count: 폐업시킨 치킨집의 수
	*/
	private static void dfs(int idx, int count){

		/*
		폐업시킬 치킨집을 모두 정했다면 각각 도시들의 치킨거리를 bfs를 통해
		구한후 모두 더해준다. 그 후, ans와 비교하여 최솟값을 갱신한다.
		*/
		if(count == chicken.size() - m){

			int c_dist = 0;

			for(Node c : city){

				chk = new boolean[n+1][n+1]; // 방문을 체크할 배열 초기화.
				c_dist += bfs(c.x, c.y);
			}
			ans = Math.min(ans, c_dist);
			return ;
		}

		// 폐업시킬 치킨집 고르기.
		for(int i = idx; i < chicken.size(); i++){

			Node store = chicken.get(i);

			map[store.x][store.y] = 0;
			dfs(i+1, count+1);
			map[store.x][store.y] = 2;
		}
	}

	// 치킨집과 도시들을 나타낼 객체를 표현하는 클래스.
	private static class Node{

		private int x, y;

		private Node(int x, int y){

			this.x = x;
			this.y = y;
		}
	}
}