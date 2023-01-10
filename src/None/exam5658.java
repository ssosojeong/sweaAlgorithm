package None;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //무조건 4의 배수
            int M = Integer.parseInt(st.nextToken());
            int R = N/4;                                //계산해야 하는 회전 수

            Queue<Character> nums = new LinkedList<>();
            String input = br.readLine();
            for(int n=0; n<N; n++){
                nums.offer(input.charAt(n));
            }

            Set<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            //회전 R번
            for(int r=0; r<R; r++){
                for(int k=0; k<4; k++){
                    StringBuilder tmp = new StringBuilder();
                    for(int l=0; l<R; l++){
                        char cur = nums.poll();
                        tmp.append(cur);
                        nums.offer(cur);
                    }
                    treeSet.add(Integer.valueOf(tmp.toString(),16));
                }

                for(int k=0; k<N-1; k++){
                    nums.offer(nums.poll());
                }
            }

            int ans = 0;
            Iterator<Integer> iterator = treeSet.iterator();
            for(int m=0; m<M; m++){
                ans = iterator.next();
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.print(sb);
    }
}
