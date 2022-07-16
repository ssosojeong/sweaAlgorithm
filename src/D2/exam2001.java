package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam2001{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = -1;
            for(int i=0; i<=N-M; i++){
                for(int j=0; j<=N-M; j++){
                    int sum = 0;
                    for(int mr=0; mr<M; mr++){
                        for(int mc=0; mc<M; mc++){
                            sum += arr[i+mr][j+mc];
                        }
                    }
                    if(sum>ans) ans = sum;
                }
            }

            System.out.println("#" + t + " " + ans);

        }

    }
}