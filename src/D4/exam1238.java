package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class exam1238{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine()," ");
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> contact = new ArrayList<>();
            for(int i=0; i<=100; i++){
                contact.add(new ArrayList<Integer>());
            }
            int[] time = new int[101];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<len-1; i+=2){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                contact.get(from).add(to);
            }


            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            time[start] = 0;
            int max = -1;

            while(!queue.isEmpty()) {
                int from = queue.poll();
                for(int to : contact.get(from)) {
                    if(time[to]!=0) continue;
                    queue.offer(to);
                    time[to] = time[from]+1;
                    max = Math.max(time[to], max);
                }

            }

            int ans = 0;
            for(int i=1; i<101; i++) {
                if(time[i]==max) ans=i;
            }
            System.out.printf("#%d %d\n", t, ans);



        }
    }
}