import java.io.*;
import java.util.*;

public class Main{

	private static char[][] img;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		img = new char[n][n];

		for(int i = 0; i < n; i++){

			String line = br.readLine();

			for(int j = 0; j < n; j++){

				img[i][j] = line.charAt(j);
			}
		}
		System.out.println(getQuadTree(0, 0, n));
		br.close();
	}

	// x: x좌표, y: y좌표, half: 검사할 범위를 정해주는 변수.
	private static String getQuadTree(int x, int y, int half){

		boolean flag = false;
		char color = img[x][y];

		for(int i = x; i < x + half; i++){
			for(int j = y; j < y + half; j++){
				// 검사하는 범위 내에 하나라도 색이 다른게 있다면 flag->true 후 반복문 탈출.
				if(color != img[i][j]){
					flag = true;
					break;
				}
			}
			if(flag) break;
		}

		// 검사한 범위 내에 색이 모두 같다면 현재 색 반환.
		if(!flag) return String.valueOf(color);
		
		// 왼위,오위,왼아,오아 4부분으로 검사를 나누고 각각 시작점 정해준 후 메소드 호출.
		String upper_left = getQuadTree(x, y, half/2);
		String upper_right = getQuadTree(x, y+half/2, half/2);
		String lower_left = getQuadTree(x+half/2, y, half/2);
		String lower_right = getQuadTree(x+half/2, y+half/2, half/2);

		// 나눠준 값들 이어 붙힌 후 반환(괄호로 감싸서).
		return "(" + upper_left + upper_right + lower_left + lower_right + ")";
	}
}