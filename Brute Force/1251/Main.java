import java.io.*;
import java.util.*;

public class Main{

	private static ArrayList<String> ans = new ArrayList<>();
	private static String word;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		getNewWord(new LinkedList<String>(), 0);
		Collections.sort(ans); // 사전 순 정렬.
		System.out.println(ans.get(0)); // 첫번째 단어 출력.
		br.close();
	}

	// pieces: 단어 조각들을 담을 연결리스트, start: 단어 조각의 첫 시작 문자를 정할 변수.
	private static void getNewWord(LinkedList<String> pieces, int start){

		// 리스트가 단어 조각 3개를 가지고 있다면 재귀탈출.
		if(pieces.size() == 3){

			String new_word = "";

			for(String p : pieces){
				// 단어 조각들을 뒤집어서 새로운 단어에 이어 붙임.
				new_word += new StringBuilder(p).reverse().toString();
			}
			// 새로운 단어와 기존 단어의 길이가 같다면 어레이리스트에 추가.
			if(new_word.length() == word.length()){
				ans.add(new_word);
			}
			return ;
		}

		for(int i = start; i < word.length(); i++){

			pieces.add(word.substring(start,i+1));
			getNewWord(pieces, i+1);
			pieces.removeLast();
		}
	}
}