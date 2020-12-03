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
			boolean[] books = new boolean[n+1];
			Student[] students = new Student[m];
			for(int i = 0; i < m; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				students[i] = new Student(a, b);
			}
			// 끝나는 번호 오름차순 정렬. 끝번호가 같다면 앞번호 내림차순 정렬.
			Arrays.sort(students, new Comparator<Student>(){
				@Override
				public int compare(Student s1, Student s2){
					if(s1.b > s2.b){
						return 1;
					}
					else if(s1.b == s2.b){
						if(s1.a < s2.a) return 1;
						else if(s1.a == s2.a) return 0;
						else return -1;
 					}else{
						return -1;
					}
				}
			});

			int b_cnt = 0;

			for(int idx = 0; idx < m; idx++){

				int start = students[idx].a;
				int end = students[idx].b;

				for(int i = start; i <= end; i++){
					if(!books[i]){
						books[i] = true;
						b_cnt++;
						break;
					}
				}
			}
			System.out.println(b_cnt);
		}
		br.close();
	}

	private static class Student{

		int a, b;

		private Student(int a, int b){

			this.a = a;
			this.b = b;
		}
	}
}