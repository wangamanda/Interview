import java.util.ArrayList;
import java.util.Arrays;

public class PhoneNumberPermutation{
	public static void main(String[] args){
		int len = 3;
		int[] arr = {0, 1, 5, 6, 8, 9};
		Permutation(len, arr);
	}

	public static void Permutation(int len, int[] arr){
		int[] digits = new int[10];
		for(int i = 0 ; i < digits.length ; i ++ ){
			digits[i] = 1;
		}
		for(int n : arr){
			digits[n] = 0;
		}

		int[] num = new int[len];

		ArrayList<int[]> arrList = new ArrayList<int[]>();
		if(digits[4] == 1){
			num[0] = 4;
			digits[4] = 0;
			Print(digits, num, arrList, 1);
		}
		Print(digits, num, arrList, 0);
		for(int[] a : arrList){
			System.out.println(Arrays.toString(a));
		}
	}

	public static void Print(int[] digits, int[] num, ArrayList<int[]> arr, int start){
		int[] number = new int[num.length];
		for(int i = 0 ; i < num.length ; i ++ ){
			number[i] = num[i];
		}

		int len = number.length;
		if(start == number.length){
			arr.add(number);
			return;
		}


		if(start == 0){
			for(int i = 0 ; i < 10 ; i ++ ){
				if(digits[i] == 1){
					number[start] = i;
					Print(digits, number, arr, start+1);
				}
			}
		}else{
			for(int i = 0 ; i < 10 ; i ++ ){
				if(digits[i] == 1 && i != number[start-1]){
					number[start] = i;
					Print(digits, number, arr, start+1);
				}
			}
		}
	}
}
