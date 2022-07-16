package D4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class exam1226{
    static int[][] map, visit;
    static int[] startP, endP, di={1,0,-1,0}, dj={0,1,0,-1};
    static int flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input;

        for(int t=0; t<10; t++){
            int T = Integer.parseInt(br.readLine());
            startP = new int[2];
            endP = new int[2];
            flag = 0;

            map = new int[16][16];
            visit = new int[16][16];

            for(int i=0; i<16; i++){
                input = br.readLine().toCharArray();
                for(int j=0; j<16; j++){
                    int tar = input[j]-'0';
                    map[i][j] = tar;
                    if(tar==2) startP =new int[] {i, j};
                    else if(tar==3) endP =new int[] {i, j};
                }
            }
            dfs(startP[0], startP[1]);

            System.out.printf("#%d %d%n", T, flag);

        }



    }

    static void dfs(int i, int j){
        if(i==endP[0] && j==endP[1]){
            flag = 1;
            return;
        } else{
            for(int d=0; d<4; d++){
                int newI = i + di[d];
                int newJ = j + dj[d];

                if(newI<0 || newI>15 || newJ<0 || newJ>15 || map[newI][newJ] == 1 || visit[newI][newJ]==1)  continue;

                visit[newI][newJ] = 1;
                dfs(newI, newJ);
                visit[newI][newJ] = 0;
            }

        }

    }




}