package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

class exam1959
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            int k = (N>M?N-M:M-N);
            int ans = -1;
            for(int i=0; i<=k; i++){
                ans = Math.max(ans, (N<M? calcSum(arrA, arrB, i, N) : calcSum(arrB, arrA, i, M)));
            }

            sb.append("#" + t + " " + ans + "\n");
        }

        System.out.print(sb);

    }

    private static int calcSum(int[] arrA, int[] arrB, int start, int N){
        int sum = 0;

        for(int i=0; i<N; i++){
            sum += arrA[i] * arrB[start++];
        }

        return sum;
    }


}