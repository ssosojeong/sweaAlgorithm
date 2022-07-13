package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int pw = Integer.parseInt(st.nextToken());
        int cur = Integer.parseInt(st.nextToken());

        if(pw>=cur) {
            System.out.println(pw-cur+1);
        } else{
            System.out.println((999-cur+1)+(pw));
        }
    }
}
