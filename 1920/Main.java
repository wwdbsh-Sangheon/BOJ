import java.util.*;
import java.io.*;

public class Main{
    
    private static int[] A;
    public static void main(final String[] args) throws IOException{
        
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int number = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(number));
        }
        br.close();
    }

    private static int binarySearch(int num){

        int left = 0;
        int right = A.length - 1;
        
        while(left <= right){
            int half = (right + left) / 2;
            if(A[half] < num){
                left = half + 1;
            }else if(A[half] > num){
                right = half - 1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}