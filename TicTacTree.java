public class TicTacTree{
	public static void main(String[] args){
		int N = 5;
		Boolean[][] board = {{false, false, null, null, null},{null, false, false, null, null},
		{null, null, false, false, true},{true, true, true, false, true},
		{null, null, null, null, true}};

		int res = Winner(board);
		System.out.println("Winner: "+res);
	}

	public static int Winner(Boolean[][] board){
		int cnt1 = 0;
		int cnt2 = 0;
		int N = board.length;
		for(int i = 0 ; i < N ; i ++ ){
			for(int j = 0 ; j < N-2 ; j ++ ){
				if(board[i][j] == null || board[i][j+1] == null || board[i][j+2] == null){
					continue;
				}

				if(board[i][j] == true && board[i][j+1] == true && board[i][j+2] == true){
					cnt1 ++ ;
				}

				if(board[i][j] == false && board[i][j+1] == false && board[i][j+2] == false){
					cnt2 ++ ;
				}
			}
		}

		for(int i = 0 ; i < N-2 ; i ++ ){
			for(int j = 0 ; j < N ; j ++ ){
				if(board[i][j] == null || board[i+1][j] == null || board[i+2][j] == null){
					continue;
				}

				if(board[i][j] == true && board[i+1][j] == true && board[i+2][j] == true){
					cnt1 ++ ;
				}

				if(board[i][j] == false && board[i+1][j] == false && board[i+2][j] == false){
					cnt2 ++ ;
				}
			}
		}

		for(int i = 0 ; i < N-2 ; i ++ ){
			for(int j = 0 ; j < N-2 ; j ++ ){
				if(board[i][j] == null || board[i+1][j+1] == null || board[i+2][j+2] == null){
					continue;
				}

				if(board[i][j] == true && board[i+1][j+1] == true && board[i+2][j+2] == true){
					cnt1 ++ ;
				}

				if(board[i][j] == false && board[i+1][j+1] == false && board[i+2][j+2] == false){
					cnt2 ++ ;
				}
			}
		}

		for(int i = 0 ; i < N-2 ; i ++ ){
			for(int j = 2 ; j < N ; j ++ ){
				if(board[i][j] == null || board[i+1][j-1] == null || board[i+2][j-2] == null){
					continue;
				}

				if(board[i][j] == true && board[i+1][j-1] == true && board[i+2][j-2] == true){
					cnt1 ++ ;
				}

				if(board[i][j] == false && board[i+1][j-1] == false && board[i+2][j-2] == false){
					cnt2 ++ ;
				}
			}
		}

		System.out.println(cnt1+" : "+cnt2);
		if(cnt1 > cnt2){
			return 1;
		}else if(cnt1 < cnt2){
			return 2;
		}else{
			return 0;
		}
	}
}
