public class LargestSubArray{
	public static void main(String[] args){
		int[] arr = new int[args.length];
		for(int i = 0 ; i < args.length ; i ++ ){
			arr[i] = Integer.parseInt(args[i]);
		}
		FindSubArray(arr);
	}

	public static void FindSubArray(int[] arr){
		int max = 0;
		int[] sum = new int[arr.length];
		int start = 0;
		int end = 0;
		int st = 0;
		int en = 0;
		sum[0] = arr[0];
		for(int i = 1 ; i < arr.length ; i ++ ){
			sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
			if(sum[i] == sum[i-1]+arr[i]){
				end = i;
			}else if(sum[i] == arr[i]){
				start = i;
			}

			if(sum[i] > max && end-start >= 1){
				max = sum[i];
				st = start;
				en = end;
			}
		}

		System.out.println("max value:" +max+"");
		if(st == 0 && en == 0){
			System.out.println("No such sub-sequence.");
		}else{
			for(int i = st ; i <= en ; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
