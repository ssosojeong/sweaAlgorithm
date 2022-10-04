package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam2007 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			String str = br.readLine();
			int ans = 0;

			for (int len = 1; len <= 10; len++) {
				String tmp = str.substring(0, len);

				if (!tmp.equals(str.substring(len, len * 2)))
					continue;
				else {
					ans = len;
					break;
				}

			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}