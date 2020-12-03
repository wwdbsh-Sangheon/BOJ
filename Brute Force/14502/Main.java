import java.io.*;
import java.util.*;

public class Main
{
	private static int[][] map;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, m, ans = 0;

	public static void main(String[] args) throws IOException
	{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < m; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		build(0);
		System.out.println(ans);
		br.close();
	}

	// c: 새로 새운 벽의 수, dfs
	private static void build(int c)
	{
		if(c == 3) // 벽이 3개 세워졌을때 바이러스 확산.
		{
			virus();
			return ;
		}

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(map[i][j] == 0)
				{
					map[i][j] = 1; // 벽세우기.
					build(c+1); // 하나의 벽을 세운뒤 넘겨줌.
					map[i][j] = 0; // 완전탐색을 위해 원상복구.
				}
			}
		}
	}

	// 바이러스 확산. bfs
	private static void virus()
	{
		int[][] copy = new int[n][m];
		copyArray(map, copy); /* 작업의 편리함을 위해서 복사본 형성.
								하나의 지도로 작업하는것 가능하나 비효율적.*/
		Queue<Node> queue = new LinkedList<Node>();
		for(int i = 0; i < n; i++) // 바이러스의 위치 큐에 추가.
		{
			for(int j = 0; j < m; j++)
			{
				if(copy[i][j] == 2)
				{
					queue.offer(new Node(i, j));
				}
			}
		}

		while(!queue.isEmpty()) // bfs 실행. 바이러스 확산.
		{
			Node node = queue.poll();

			for(int i = 0; i < 4; i++)
			{
				int ax = node.x + dx[i];
				int ay = node.y + dy[i];

				if(ax >= 0 && ax < n && ay >= 0 && ay < m)
				{
					if(copy[ax][ay] == 0)
					{
						copy[ax][ay] = 2;
						queue.offer(new Node(ax, ay));
					}
				}
			}
		}

		int area = 0;

		for(int i = 0; i < n; i++) // 안전한 영역 카운트.
		{
			for(int j = 0; j < m; j++)
			{
				if(copy[i][j] == 0)
				{
					area++;
				}
			}
		}

		ans = (ans > area) ? ans : area; // 답 도출.
	}

	private static void copyArray(int[][] array, int[][] copy)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				copy[i][j] = array[i][j];
			}
		}
	}

	private static class Node
	{
		private int x, y;

		private Node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}