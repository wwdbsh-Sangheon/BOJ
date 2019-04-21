import java.io.*;
import java.util.*;

public class Main{

	private static Question[] questions;
	private static int n, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		questions = new Question[n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			questions[i] = new Question(num, s, b);
		}
		
next:	for(int i = 123; i <= 987; i++){
			
			String num = String.valueOf(i);

			// 각 자릿수가 같은 것들이 있거나, 혹은 0 일때 스킵.
			if(num.charAt(0) == num.charAt(1) ||
				num.charAt(0) == num.charAt(2) ||
				num.charAt(1) == num.charAt(2) ||
				num.charAt(0) == '0' ||
				num.charAt(1) == '0' || 
				num.charAt(2) == '0') continue;

			// 각각의 질문들을 체크할 반복문. 한개의 질문이라도 조건을 만족하지 않는다면 next로 이동.
			for(Question q : questions){

				int s = 0, b = 0; // 스트라이크와 볼의 개수 초기화.

				// 질문의 숫자와 예측한 정답을 비교할 반복문.
				for(int idx = 0; idx < 3; idx++){
					
					// 두 수의 같은 동일한 자릿수의 값이 같다면 스트라이크 1 증가 후 스킵.
					if(num.charAt(idx) == q.number.charAt(idx)){
						s++;
						continue;
					}

					for(int j = 0; j < 3; j++){

						// 질문의 j자리의 수가 예측한 정답에 포함되어 있다면 볼 1 증가 후 반복문 탈출.
						if(num.charAt(j) == q.number.charAt(idx)){
							b++;
							break;
						}
					}
				}

				// 체크한 스트라이크와 볼의 수가 질문의 스트라이크와 볼의 수와 다르다면 next로 이동.
				if(s != q.s || b != q.b) continue next;
			}
			ans++; // 예측한 정답의 수 증가.
		}
		System.out.println(ans);
		br.close();
	}

	// 질문을 나타낼 객체를 표현한 클래스.
	private static class Question{

		private String number;
		private int s, b;

		private Question(String number, int s, int b){

			this.number = number;
			this.s = s;
			this.b = b;
		}
	}
}