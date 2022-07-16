package D2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class exam1961{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#" + t + "\n");
            int N = Integer.parseInt(br.readLine());
            String[][] input = new String[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    input[i][j] = st.nextToken();
                }
            }


            String[][] output = new String[N][3];

            for(int j=0; j<3; j++){
                String[] tempOutput = rotation(j,N,input);
                for(int i=0; i<N; i++){
                    output[i][j] = tempOutput[i];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<3; j++){
                    sb.append(output[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    static String[] rotation(int tar, int N, String[][] input){
        String[] col = new String[N];
        if(tar==0){	//90도 회전
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<N; j++){
                    sb.append(input[N-1-j][i]);
                }
                col[i] = sb.toString();
            }
        }
        else if(tar==1){	//180도
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<N; j++){
                    sb.append(input[N-1-i][N-1-j]);
                }
                col[i] = sb.toString();
            }
        }
        else if(tar==2){	//270도
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<N; j++){
                    sb.append(input[j][N-1-i]);
                }
                col[i] = sb.toString();
            }
        }
        return col;
    }

}