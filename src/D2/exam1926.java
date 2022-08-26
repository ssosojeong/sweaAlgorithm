package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class exam126
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
     
        for(int i=1;i<=N; i++){
            int cnt = 0;
            for(char c : String.valueOf(i).toCharArray()) if(c=='3' || c=='6' || c=='9') cnt++;
            if(cnt==0) sb.append(i);
            else for(int c=0; c<cnt; c++) sb.append("-");
            sb.append(" ");
        }
        
        System.out.print(sb);
		
	}
}