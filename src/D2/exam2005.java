package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class exam2005 {
	// 조합 연습!
	static int[][] combi;

	public static int combination(int n, int r) {
		if (n == r || r == 0)
			return combi[n][r] = 1;
		else if (combi[n][r] != 0)
			return combi[n][r];
		else
			return combi[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");

			int N = Integer.parseInt(br.readLine());
			combi = new int[N][N];
			combi[0][0] = 1;

			for (int r = 0; r < N; r++) {
				combination(N-1, r);
			}

			for (int[] row : combi) {
				for (int val : row) {
					if (val != 0)
						sb.append(val + " ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}