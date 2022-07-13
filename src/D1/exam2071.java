package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            double sum = 0;
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                sum += Double.parseDouble(st.nextToken());
            }
            System.out.printf("#%d %d\n",t, Math.round(sum/10));
        }

    }
}
