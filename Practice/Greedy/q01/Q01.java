import java.io.*;
import java.util.*;

public class Q01 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[n];
        for(int idx = 0; idx < n; idx++) people[idx] = Integer.parseInt(st.nextToken());

        Arrays.sort(people);

        int result = 0, count = 0;

        for(int idx = 0; idx < n; idx++){
            count++;
            if(count >= people[idx]){
                result++;
                count = 0;
            }
        }
        
        System.out.println(result);
        br.close();
    }
}
