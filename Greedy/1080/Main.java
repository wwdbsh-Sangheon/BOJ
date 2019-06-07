import java.io.*;
import java.util.*;

public class Main{

	private static BufferedReader br;
	private static StringTokenizer st;
	private static char[][] a, b;
	private static int n, m, ans = 0;

	public static void main(String[] args) throws IOException{

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new char[n][m];
		b = new char[n][m];
		// 행렬입력.
		setMatrix(a);
		setMatrix(b);
		// 가로,세로 길이가 모두 3 이상 일때만 뒤집기 실행.
		if(n >= 3 && m >= 3){
			for(int i = 0; i <= n-3; i++){
				for(int j = 0; j <= m-3; j++){
					// 숫자가 다르다면 뒤집기 실행.
					if(a[i][j] != b[i][j]){
						convert(i, j);
						ans++;
					}
				}
			}
		}
		// 두 행렬이 같은지 확인.
		if(!check()){
			ans = -1;
		}
		System.out.println(ans);
		br.close();
	}

	private static void setMatrix(char[][] matrix) throws IOException{

		for(int i = 0; i < n; i++){
			String row = br.readLine();
			for(int j = 0; j < m; j++){
				matrix[i][j] = row.charAt(j);
			}
		}
	}

	private static boolean check(){

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(a[i][j] != b[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	private static void convert(int x, int y){

		for(int i = x; i < x+3; i++){
			for(int j = y; j < y+3; j++){
				a[i][j] = a[i][j] == '1' ? '0' : '1';
			}
		}
	}
}
