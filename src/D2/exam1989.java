package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class exam1989
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {

            String tar = br.readLine();
            String rev = new StringBuilder(tar).reverse().toString();
            if(tar.equals(rev)) System.out.printf("#%d 1",t);
            else System.out.printf("#%d 0",t);

        }

    }
}