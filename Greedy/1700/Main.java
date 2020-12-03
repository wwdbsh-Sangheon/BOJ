import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> plug = new ArrayList<Integer>();
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] order = new int[k];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < k; i++){
      order[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;

next:for(int i = 0; i < k; i++){
      // 물건이 이미 꽂혀 있을때 넘어가기.
      for(int idx = 0; idx < plug.size(); idx++){
        if(plug.get(idx) == order[i]) continue next;
      }
      // 멀티텝에 남는 플러그가 있을때 꽂아주고 넘어가기.
      if(plug.size() < n){
        plug.add(order[i]);
        continue;
      }

      // 멀티텝에 남는 자리가 없을때 가장 마지막에 사용할 플러그 뽑아주기.
      int dev = 0, p = 0;

      for(int idx = 0; idx < plug.size(); idx++){
        int d = 987654321;
        for(int j = i+1; j < k; j++){
          if(plug.get(idx) == order[j]){
            d = j;
            break;
          }
        }
        // d가 변하지 않았을 경우는 앞으로 쓰지 않을 물건을 의미한다.
        if(dev < d){
          dev = d;
          p = idx;
        }
      }
      // 플러그에 꽂아주기.
      plug.set(p, order[i]);
      ans++;
    }
    System.out.println(ans);
    br.close();
  }
}
