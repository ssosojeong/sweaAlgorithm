package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam1979
{
    static int[][] map;
    static boolean[][] visit;
    static int N, K;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int ans = 0;
            map = new int[N][N];
            visit = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //dfs 가로 check
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int cnt = 0;
                    if(map[i][j]==1 && visit[i][j]==false) {
                        if(dfsHor(i, j, cnt)==K) ans++;
                        //위의 함수를 거치면 visit배열에서 참조한 칸은 true로 표시되므로
                        //연속된 칸을 한번만 탐색할 수 있음(oooo을 ooo- -ooo으로 두 번 탐색하는 것 방지)
                    }
                }
            }

            //세로 탐색을 위해 visit 배열 재생성
            visit = new boolean[N][N];

            //dfs 세로 check
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int cnt = 0;
                    if(map[i][j]==1 && visit[i][j]==false) {
                        if(dfsVer(i, j, cnt)==K) ans++;
                    }
                }
            }

            System.out.println("#" + t + " " + ans);

        }
    }
    public static int dfsHor(int i, int j, int cnt){
        //가로 dfs
        if(j==N || map[i][j]==0 ){ return cnt;}
        else{
            visit[i][j] = true;
            return dfsHor(i, j+1, cnt+1);
        }
    }

    public static int dfsVer(int i, int j, int cnt){
        //가로 dfs
        if(i==N || map[i][j]==0 ){ return cnt;}
        else{
            visit[i][j] = true;
            return dfsVer(i+1, j, cnt+1);
        }
    }
}