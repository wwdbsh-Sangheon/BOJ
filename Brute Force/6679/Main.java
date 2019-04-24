import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		for(int num = 1000; num <= 9999; num++){

			String dec = String.valueOf(num);
			String duo = getDuo(num);
			String hex = getHex(num);

			int dec_sum = getSum(dec);
			int duo_sum = getSum(duo);
			int hex_sum = getSum(hex);

			// 10, 12, 16진법으로 나타낸 수들의 각 자리수 합이 서로 같다면 숫자 출력.
			if(dec_sum == duo_sum && duo_sum == hex_sum){
				System.out.println(num);
			}
		}
	}

	// 각 자리수들의 합을 구하는 메소드. num: 숫자
	private static int getSum(String num){

		int ret = 0;

		for(int i = 0; i < num.length(); i++){

			char digit = num.charAt(i);

			// 숫자가 10보다 크거나 같으면 메소드로 숫자값으로 변환 후 더하기.
			if(digit >= 'A'){
				ret += getValue(digit);
			}else{
				ret += Integer.parseInt(num.substring(i, i+1));
			}
		}

		return ret;
	}

	// 12진법으로 변환하는 메소드.
	private static String getDuo(int num){

		String ret = "";

		while(num > 0){

			int r = num % 12;
			num /= 12;

			// 나머지가 9보다 크면 알파벳으로 변환 후 반환 값에 붙이기.
			if(r > 9){
				ret = getDigit(r) + ret;
			}else{
				ret = String.valueOf(r) + ret;
			}
		}

		return ret;
	}

	// 16진법으로 변환하는 메소드.
	private static String getHex(int num){

		String ret = "";

		while(num > 0){

			int r = num % 16;
			num /= 16;

			if(r > 9){
				ret = getDigit(r) + ret;
			}else{
				ret = String.valueOf(r) + ret;
			}
		}

		return ret;
	}

	// 알파벳을 숫자로 변환하는 메소드.
	private static int getValue(char digit){

		switch(digit){

			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
		}

		return -1;
	}

	// 숫자를 알파벳으로 변환하는 메소드.
	private static String getDigit(int num){

		switch(num){

			case 10 :
				return "A";
			case 11 :
				return "B";
			case 12 :
				return "C";
			case 13 :
				return "D";
			case 14 :
				return "E";
			case 15 :
				return "F";
		}

		return "";
	}
}