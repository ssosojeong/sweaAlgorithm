package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2056 {
    static final int[] MONTH_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            String input = br.readLine();
            int M = Integer.parseInt(input.substring(4,6));
            int D = Integer.parseInt(input.substring(6));

            if(M>0 && M<=12){
                if(D!=0 && MONTH_DAYS[M]>=D) System.out.printf("#%d %s/%s/%s\n",t,input.substring(0,4),input.substring(4,6),input.substring(6));
                else System.out.printf("#%d -1\n",t);
            }
            else System.out.printf("#%d -1\n",t);
        }

    }
}
