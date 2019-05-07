import java.io.*;
import java.util.*;

public class Main{

	private static int[][] matrix;
	private static int[] counts = new int[3];

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];

		for(int i = 0; i < n; i++){

			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < n; j++){

				int digit = Integer.parseInt(st.nextToken());
				// 숫자가 -1이라면 2로 대체(counts배열에 적용하기 위해서)
				if(digit == -1) digit = 2;
				matrix[i][j] = digit;
			}
		}
		setCountOfPaper(0, 0, n);
		System.out.println(counts[2] + "\n" + counts[0] + "\n" + counts[1]);
		br.close();
	}

	// x: x좌표, y: y좌표, div: 탐색할 범위를 정해주는 변수.
	private static void setCountOfPaper(int x, int y, int div){

		// flag: 탐색한 범위가 모두 같은 숫자인지 아닌지 알려줄 변수, paper: 탐색할 숫자.
		int flag = -1, paper = matrix[x][y];

		for(int i = x; i < x + div; i++){
			for(int j = y; j < y + div; j++){
				// 탐색할 숫자와 다른 숫자가 나올 경우 flag = 0 후 반복문 탈출.
				if(paper != matrix[i][j]){
					flag = 0;
					break;
				}
			}
			if(flag == 0) break;
		}

		// 탐색한 범위가 모두 같은 숫자라면, 해당 숫자 개수 늘려준 뒤 재귀 탈출.
		if(flag == -1){

			counts[paper]++;
			return ;
		}

		// 9개 부분으로 나눠준 뒤 메소드 호출.
		int tri = div / 3;

		setCountOfPaper(x, y, tri);
		setCountOfPaper(x, y+tri, tri);
		setCountOfPaper(x, y+2*tri, tri);
		setCountOfPaper(x+tri, y, tri);
		setCountOfPaper(x+tri, y+tri, tri);
		setCountOfPaper(x+tri, y+2*tri, tri);
		setCountOfPaper(x+2*tri, y, tri);
		setCountOfPaper(x+2*tri, y+tri, tri);
		setCountOfPaper(x+2*tri, y+2*tri, tri);
	}
}