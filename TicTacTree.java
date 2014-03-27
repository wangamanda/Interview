public class TicTacTree{
	public static void main(String[] args){
		int N = 10;
		Boolean[][] board = new Boolean[N][N];
		for(int i = 0 ; i < N ; i ++ ){
			for(int j = 0 ; j < N ; j ++ ){
				if(i % 2 == 0 && j % 2 == 0){
					board[i][j] = true;
				} 
				if(i % 2 == 1 && j % 2 == 0){
					board[i][j] = false;
				}
				if(j % 2 == 1){
					board[i][j] = null;
				}
				if(board[i][j] != null){
					System.out.print(Boolean.toString(board[i][j]));
				}else{
					System.out.print("\t");
				}
			}
			System.out.println();
		}

		Winner(board);
	}

	public static int Winner(Boolean[][] board){
		int cnt1 = 0;
		int cnt2 = 0;

	}
}
