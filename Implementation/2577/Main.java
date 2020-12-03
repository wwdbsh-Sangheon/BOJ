import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[10];
		String num = String.valueOf(Integer.parseInt(br.readLine()) *
									Integer.parseInt(br.readLine()) *
									Integer.parseInt(br.readLine()));
		for(int i = 0; i < num.length(); i++)
		{
			int digit = Integer.parseInt(num.substring(i, i+1));
			count[digit]++;
		}

		for(int i : count) System.out.println(i);
		br.close();
	}
}