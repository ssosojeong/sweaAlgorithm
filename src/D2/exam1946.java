package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam1946
{
    static final int LEN = 10;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            int curNum = 0;
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine()," ");
                char character = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                curNum = unpacking(character,num,sb,curNum);
            }
            System.out.printf("#%d \n%s",t,sb.toString());
        }
    }

    public static int unpacking(char character, int num, StringBuilder sb, int curNum){
        while(num>0){
            if(curNum==LEN){
                sb.append("\n");
                curNum=0;
            }
            sb.append(character);
            curNum++;
            num--;
        }


        return curNum;
    }
}