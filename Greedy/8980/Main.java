import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] towns = new int[n+1];
		Information[] infos = new Information[m];
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int send = Integer.parseInt(st.nextToken());
			int rec = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			infos[i] = new Information(send, rec, num);
		}

		Arrays.sort(infos, new Comparator<Information>(){
			@Override
			public int compare(Information i1, Information i2){
				if(i1.rec > i2.rec){
					return 1;
				}else if(i1.rec == i2.rec){
					if(i1.send > i2.send) return 1;
					else if(i1.send == i2.send) return 0;
					else return -1;
				}else{
					return -1;
				}
			}
		});

		int ans = 0;

		for(Information info : infos){

			int tc = 10000;

			//출발 도착지 전까지 각 마을별로 최대한 많이 담아 갈 수 있는 화물의 무게 확인.
			for(int i = info.send; i < info.rec; i++){
				tc = Math.min(tc, c - towns[i]);
			}

			//화물 정보의 실제 무게와 마을의 여유 공간을 비교.
			int ac = Math.min(tc, info.num);

			if(ac == 0){
				continue;
			}else{
				//마을에 적재한 화물만큼 추가.
				ans += ac;
				for(int i = info.send; i < info.rec; i++){
					towns[i] += ac;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}

	private static class Information{

		int send, rec, num;

		private Information(int s, int r, int n){

			this.send = s;
			this.rec = r;
			this.num = n;
		}
	}
}