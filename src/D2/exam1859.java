package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam1859 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = -1;
			long sum = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > max)
					max = arr[i];
				else {
					sum += max - arr[i];
				}
			}
			sb.append("#" + test_case + " " + sum);

		}
		System.out.println(sb);
	}
}