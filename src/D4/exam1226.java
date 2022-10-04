package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1226 {
    static final int TEST_CASE = 10, BOUNDARY = 16;
    static char[][] map;
    static int[] di= {0,1,0,-1}, dj= {1,0,-1,0};
    static int ans, eI, eJ;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=TEST_CASE; t++) {
            int N = Integer.parseInt(br.readLine());
            ans = 0;

            int sI=-1, sJ=-1;
            eI=-1;
            eJ=-1;

            map = new char[BOUNDARY][BOUNDARY];
            for(int i=0; i<BOUNDARY; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<BOUNDARY; j++) {
                    if(map[i][j]=='0' || map[i][j]=='1') {
                        continue;
                    }else if(map[i][j]=='2') {				//시작점
                        sI = i;
                        sJ = j;
                    } else if(map[i][j]=='3') {				//도착점
                        eI = i;
                        eJ = j;
                    }
                }
            }

            dfs(sI,sJ);

            sb.append("#"+N+" "+ans+"\n");
        }
        System.out.println(sb);



    }

    public static void dfs(int i, int j) {
        if(i==eI && j==eJ) {
            ans = 1;
        } else {
            for(int d=0; d<4; d++) {
                int newI = i+di[d];
                int newJ = j+dj[d];

                if(newI<0 || newI>=BOUNDARY || newJ<0 || newJ>=BOUNDARY || map[newI][newJ]=='1' || map[newI][newJ]=='v') {
                    continue;
                }

                map[newI][newJ]='v';
                dfs(newI, newJ);
            }
        }
    }

}
