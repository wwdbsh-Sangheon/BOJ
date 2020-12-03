import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken()) - a;
        int share = top / (a - b);
        System.out.println((top - (share * (a - b)) <= 0) ? share + 1 : (share + 1) + 1);
        br.close();
    }
}