import java.io.*;
import java.util.*;

public class Main{

	private static Applicant[] applicants;
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){

			n = Integer.parseInt(br.readLine());
			applicants = new Applicant[n];
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				applicants[i] = new Applicant(paper, interview);
			}

			// 서류점수 기준 오름차순 정렬.
			Arrays.sort(applicants, new Comparator<Applicant>(){
				@Override
				public int compare(Applicant a1, Applicant a2){
					if(a1.paper < a2.paper) return -1;
					else if(a1.paper == a2.paper) return 0;
					else return 1;
				}
			});

			int ans = 1, iv = applicants[0].interview;

			// 서류점수가 높은 사람의 인터뷰점수가 다른 지원자의 인터뷰점수 보다 낮다면 다른 지원자는 선발 될수 있다.
			for(int i = 1; i < n; i++){
				if(iv > applicants[i].interview){
					iv = applicants[i].interview;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	private static class Applicant{

		private int paper, interview;

		private Applicant(int paper, int interview){

			this.paper = paper;
			this.interview = interview;
		}
	}
}