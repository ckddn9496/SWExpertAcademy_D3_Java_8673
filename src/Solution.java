import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] power = new int[(int) Math.pow(2, N)];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < power.length; i++) {
				power[i] = Integer.parseInt(st.nextToken());
			}

			int boring = 0;

			for (int i = N; i > 0; i--) {
				for (int j = 0; j < Math.pow(2, i) / 2; j++) {
					int winner = power[2 * j] > power[2 * j + 1] ? power[2 * j] : power[2 * j + 1];
					boring += Math.abs(power[2 * j] - power[2 * j + 1]);
					power[j] = winner;
				}
			}

			System.out.println("#" + test_case + " " + boring);
		}

	}

}
