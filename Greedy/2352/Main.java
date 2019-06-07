import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ports = new int[n];
    int[] new_ports = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      ports[i] = Integer.parseInt(st.nextToken());
    }
    // LIS(최장증가수열) 구하는 문제.
    new_ports[0] = ports[0];
    int len = 1;

    for(int i = 1; i < n; i++){
      // 뉴포트의 첫 번째 값이 포트 값 보다 크다면 갱신.
      if(new_ports[0] > ports[i]){
        new_ports[0] = ports[i];
      // 뉴포트의 마지막 값이 포트 값 보다 작다면 갱신.
      }else if(new_ports[len-1] < ports[i]){
        new_ports[len++] = ports[i];
      }else{
        // 포트 값을 이진검색을 통하여 뉴포트에서 인덱스 검색.
        int idx = Arrays.binarySearch(new_ports, 0, len, ports[i]);
        idx = idx < 0 ? -idx-1 : idx; // 뉴포트에 존재하지 않는다면 -idx-1에 뉴포트 값 갱신.(인덱스 값에 대한 것은 binarysearch 메소드 작동 원리 참조.)
        new_ports[idx] = ports[i];
      }
    }
    System.out.println(len);
    br.close();
  }
}
