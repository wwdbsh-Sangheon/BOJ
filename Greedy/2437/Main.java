import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] weight = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      weight[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(weight);

    int ans = 1;

    /*
    while(true){
      int temp = ans;
      for(int i = n-1; i >= 0; i--){
        if(weight[i] > temp) continue;
        else if(weight[i] == temp){
          temp -= weight[i];
          break;
        }else{
          temp -= weight[i];
        }
      }
      if(temp != 0) break;
      ans++;
    }
    */

    for(int i = 0; i < n; i++){
      // 누적합이 다음 추의 무게 보다 작으면 반복문 탈출.
      if(ans < weight[i]) break;
      ans += weight[i];
    }
    System.out.println(ans);
    br.close();
  }
}
