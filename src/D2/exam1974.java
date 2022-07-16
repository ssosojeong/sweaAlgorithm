package D2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam1974{
    static final int ROW = 0, COLUMN = 1, BOX = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int[][] sudoku = new int[9][9];
            int flag =1;

            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                int rowSum = 0;
                for(int j=0; j<9; j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += sudoku[i][j];
                }
                if(rowSum!=45) {	// 가로 검사 (입력 즉시)
                    flag = 0;
                }
            }

            //세로, 박스 검사
            if(flag==1) flag = checkSudoku(sudoku);

            System.out.printf("#%d %d%n", t, flag);
        }

    }

    static int checkSudoku(int[][] sudoku){
        //세로 체크
        for(int j=0; j<9; j++){
            int colSum = 0;
            for(int i=0; i<9; i++){
                colSum += sudoku[i][j];
            }
            if(colSum!=45) return 0;
        }

        //박스 체크
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){	//시작점 -> 0,0 / 0,3 / 0,6 / 3,0 / 3,3 / 3,6 / 6,0 / 6,3 / 6,6 -> i*3 / j*3
                int boxSum = 0;
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        boxSum += sudoku[i*3 + k][j*3 + l];
                    }
                }
                if(boxSum!=45) return 0;
            }
        }

        return 1;
    }

}