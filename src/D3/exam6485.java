package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam6485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] cnt = new int[5001];
			for(int n=0; n<N; n++){
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				for(int i=s; i<=e; i++){
					cnt[i]++;
				}
			}

			sb.append("#"+t+" ");
			int P = Integer.parseInt(br.readLine());
			for(int p=0; p<P; p++){
				int c = Integer.parseInt(br.readLine());
				sb.append(cnt[c]+" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

}
