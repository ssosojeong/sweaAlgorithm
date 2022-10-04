package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1244 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			String input = st.nextToken();
			int[] numbers = new int[input.length()];
			for(int i=0; i<input.length(); i++) {
				numbers[i] = input.charAt(i)-'0';
			}
			int N = Integer.parseInt(st.nextToken());
			
			while(N-->0) {
				int x = numbers[0N];
				int max = -1, idx=0;
				
				//제일 큰 수 찾기
				for(int i=1; i<input.length(); i++) {
					if(numbers[i]>=max) {
						max = numbers[i];
						idx = i;
					}
				}

				//바꾸기
				int tmp = numbers[idx];
				numbers[idx] = x;
				numbers[0] = tmp;
			}
			
			String ans="";
			for(int i=0; i<input.length(); i++) {
				ans += String.valueOf(numbers[i]);
			}
			
			System.out.printf("#%d %s", t, ans);
		}

	}

}
