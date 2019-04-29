import java.io.*;
import java.util.*;

public class Main{

	private static String[] id = {"Adrian", "Bruno", "Goran"};
	private static int[] correct = new int[3];
	private static String answer;
	private static int n, max = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = br.readLine();
		// 각각 맞은 문제의 개수를 찾은뒤 배열에 삽입한다.
		correct[0] = getNumCorrect("ABC", 0, 0, 0);
		correct[1] = getNumCorrect("BABC", 0, 0, 0);
		correct[2] = getNumCorrect("CCAABB", 0, 0, 0);
		System.out.println(max);
		for(int i = 0; i < 3; i++){
			// 맞은 문제의 개수가 최고점과 같다면 아이디를 출력한다.
			if(max == correct[i]){
				System.out.println(id[i]);
			}
		}
		br.close();
	}

	// pattern: 찍기에 사용할 패턴, a_idx: 문제 번호, p_idx: 찍을 답을 나타내는 색인, count: 맞은 개수.
	private static int getNumCorrect(String pattern, int a_idx, int p_idx, int count){

		if(a_idx == answer.length()){ // 문제가 끝났다면 count 반환.
			max = Math.max(max, count);
			return count;
		}
		if(p_idx == pattern.length()){ // 패턴을 끝나면 패턴 다시 시작.
			return getNumCorrect(pattern, a_idx, 0, count);
		}
		if(answer.charAt(a_idx) == pattern.charAt(p_idx)) count++; // 문제의 답과 찍은 답이 일치한다면 맞은 개수 증가.
		return getNumCorrect(pattern, a_idx+1, p_idx+1, count); // 다음 문제로 이동. 패턴 역시 이동.
	}
}