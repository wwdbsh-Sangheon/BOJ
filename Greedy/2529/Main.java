import java.io.*;
import java.util.*;
/*
주어진 길이에 해당하는 모든 수열 만든 뒤,
주어진 부등호에 대해 체크.
*/
public class Main{

  private static String max = "0", min = "9876543210";
  private static char[] a;
  private static boolean[] chk;
  private static int k;

  public static void main(String[] args) throws IOException{

    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    a = new char[k];
    chk = new boolean[10];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < k; i++){
      a[i] = st.nextToken().charAt(0);
    }
    makeNumber("", 0);
    System.out.println(max+"\n"+min);
    br.close();
  }

  private static void makeNumber(String number, int count){

    if(count == k+1){
      if(check(number)){
        if(Long.parseLong(max) < Long.parseLong(number)){
          max = number;
        }
        if(Long.parseLong(min) > Long.parseLong(number)){
          min = number;
        }
      }
      return;
    }

    for(int i = 0; i < 10; i++){
      if(!chk[i]){
        chk[i] = true;
        makeNumber(number+i, count+1);
        chk[i] = false;
      }
    }
  }

  private static boolean check(String number){

    for(int i = 0; i < k; i++){
      switch(a[i]){
        case '<':
        if(number.charAt(i) - '0' > number.charAt(i+1) - '0') return false;
        break;
        case '>':
        if(number.charAt(i) - '0' < number.charAt(i+1) - '0') return false;
      }
    }
    return true;
  }
}
