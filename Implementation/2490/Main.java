import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 3; i++)
		{
			int count = 0;
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++)
			{
				if(Integer.parseInt(st.nextToken()) == 0)
				{
					count++;
				}
			}
			System.out.println(getName(count));
		}
		br.close();
	}

	private static String getName(int count)
	{
		switch(count)
		{
			case 1 :
				return "A";
			case 2 :
				return "B";
			case 3 :
				return "C";
			case 4 :
				return "D";
			case 0 :
				return "E";
		}

		return null;
	}
}