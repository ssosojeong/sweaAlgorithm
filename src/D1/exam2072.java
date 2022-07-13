package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int ans = 0;
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                int tar = Integer.parseInt(st.nextToken());
                if(tar%2==1) ans+= tar;
            }
            System.out.printf("#%d %d\n",t,ans);
        }

    }
}
