import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int[] leak = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      leak[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(leak);

    int p = leak[0], ans = 1;

    for(int i = 1; i < n; i++){
      // 앞에서 부터 붙여줌. 1을 빼주는 이유는 특정 위치 p에서 부터 붙혀진 테이프를 왼쪽으로 0.5만큼 땡겨주는 것을 의미.
      if(p + l - 1 < leak[i]){
        p = leak[i];
        ans++;
      }
    }
    System.out.println(ans);
    br.close();
  }
}
