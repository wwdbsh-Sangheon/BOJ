import java.io.*;
import java.util.*;

public class Main{

	private static StringBuilder sb = new StringBuilder();
	private static Person[] p;
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new Person[n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		solve(0, 0);
		System.out.println(sb.toString());
		br.close();
	}

	// idx: 등수를 매겨질 사람의 색인, c: 등수가 정해진 사람의 수
	private static void solve(int idx, int c){

		// 모두 등수를 매겼다면 메소드 탈출.
		if(c == n) return ;

		int k = 0;

		for(int i = 0; i < n; i++){
			// 키와 몸무게 모두 작다면 등수 감소.
			if(p[idx].weight < p[i].weight && p[idx].height < p[i].height){
				k++;
			}
		}
		sb.append(k+1 + " "); // 등수 반영.
		solve(idx+1, c+1); // 다음 사람으로 이동.
	}

	private static class Person{

		private int weight, height;

		private Person(int weight, int height){

			this.weight = weight;
			this.height = height;
		}
	}
}