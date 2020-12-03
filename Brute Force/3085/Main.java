import java.io.*;
import java.util.*;

public class Main{

	private static int[][] board;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, ans = 1;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for(int i = 0; i < n; i++){

			String line = br.readLine();

			for(int j = 0; j < n; j++){

				switch(line.charAt(j)){

					case 'C':
						board[i][j] = 1;
						break;
					case 'P':
						board[i][j] = 2;
						break;
					case 'Z':
						board[i][j] = 3;
				}
			}
		}
		changeCandy();
		System.out.println(ans);
		br.close();
	}

	// 인접한 사탕을 바꿔주는 메소드.
	private static void changeCandy(){

		for(int x = 0; x < n; x++){
			for(int y = 0; y < n; y++){

				int candy = board[x][y]; // 현 위치의 사탕.
				ans = Math.max(ans, Math.max(getColCnt(x, y), getRowCnt(x, y))); // 사탕을 바꾸지 않았을때 먹을 수 있는 최대 사탕 개수 도출.

				for(int k = 0; k < 4; k++){

					int ax = x + dx[k];
					int ay = y + dy[k];

					if(ax >= 0 && ax < n && ay >= 0 && ay < n){

						int temp = board[ax][ay]; // 현 위치의 사탕과 바꿔줄 위치의 사탕.
						board[ax][ay] = candy; // 사탕 교환.
						board[x][y] = temp;
						ans = Math.max(ans, Math.max(getColCnt(ax, ay), getRowCnt(ax, ay))); // 먹을 수 있는 최대 사탕의 개수 도출.
						board[ax][ay] = temp; // 완전탐색을 위한 원상복구.
						board[x][y] = candy;	
					}
				}
			}
		}
	}

	// 열에서의 먹을 수 있는 사탕의 개수를 반환하는 메소드.
	private static int getColCnt(int x, int y){

		// x1, x2 현위치 반영. ax1, ax2 다음 위치 반영.
		int x1 = x, x2 = x, ax1 = x + dx[2], ax2 = x + dx[3], count = 1;

		// 아랫방향.
		while(true){
			// 다음 위치가 보드 범위에서 벗어나거나 이전 위치와 사탕이 같지 않을 때 반복문 탈출.
			if(ax1 < 0 || ax1 >= n || board[ax1][y] != board[x1][y]){
				break;
			}
			x1 = ax1; // 위치 갱신
			ax1 += dx[2];
			count++; // 먹을 수 있는 사탕 개수 증가.
		}

		// 윗방향. 설명은 아랫방향과 같음.
		while(true){
			if(ax2 < 0 || ax2 >= n || board[ax2][y] != board[x2][y]){
				break;
			}
			x2 = ax2;
			ax2 += dx[3];
			count++;
		}

		return count;
	}

	// 행에서의 먹을 수 있는 사탕의 개수를 반환하는 메소드.
	private static int getRowCnt(int x, int y){

		// y1, y2 현위치 반영. ay1, ay2 다음 위치 반영.
		int y1 = y, y2 = y, ay1 = y + dy[0], ay2 = y + dy[1], count = 1;

		// 오른쪽 방향.
		while(true){
			// 다음 위치가 보드 범위에서 벗어나거나 이전 위치와 사탕이 같지 않을 때 반복문 탈출.
			if(ay1 < 0 || ay1 >= n || board[x][ay1] != board[x][y1]){
				break;
			}
			y1 = ay1; // 위치 갱신
			ay1 += dy[0];
			count++; // 먹을 수 있는 사탕 개수 증가.
		}

		// 왼쪽 방향. 설명은 오른쪽 방향과 같음.
		while(true){
			if(ay2 < 0 || ay2 >= n || board[x][ay2] != board[x][y2]){
				break;
			}
			y2 = ay2;
			ay2 += dy[1];
			count++;
		}

		return count;
	}
}