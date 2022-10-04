package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class exam1986 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0)
					ans -= i;
				else
					ans += i;
			}

			sb.append("#" + t + " " + ans + "\n");
		}

		System.out.print(sb);

	}
}