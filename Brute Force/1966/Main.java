import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Paper> printer = new LinkedList<Paper>(); // 프린터
			// 프린터에 Paper 객체들 삽입.
			for(int i = 0; i < n; i++){
				printer.offer(new Paper(i, Integer.parseInt(st.nextToken())));
			}

			int ans = 0;

next:		while(!printer.isEmpty()){

				Paper head = printer.poll(); // 프린터 가장 앞에 위치한 객체.

				// 반복문을 통해 모든 객체들과 비교.
				for(Paper p : printer){

					// 만약 head의 중요도가 작다면 프린터에 다시 삽입.
					if(head.weight < p.weight){

						printer.offer(head);
						continue next; // 반복문 처음으로 복귀.
					}
				}
				ans++; // 문서가 출력된 경우. 순서 1씩 증가.
				if(head.paper == m) break; // 문서의 번호가 원하는 번호와 같다면 반복문 탈출.
			}
			System.out.println(ans);
		}
		br.close();
	}

	// 문서를 객체로 표현할 클래스.
	private static class Paper{

		private int paper, weight;

		private Paper(int paper, int weight){

			this.paper = paper;
			this.weight = weight;
		}
	}
}
