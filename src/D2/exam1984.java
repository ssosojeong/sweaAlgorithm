package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class exam1984 {
    public static void main(String[] args) throws Exception {
        //입력 자원
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //테스트케이스의 수
        int T = Integer.parseInt(br.readLine());

        //테스트케이스의 수만큼 반복한다.
        for(int t=1; t<=T; t++){
            //숫자를 저장할 배열을 선언한다.
            int[] intArr = new int[10];

            //숫자 입력을 받아오고 배열에 저장한다.
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<10; i++){
                intArr[i] = Integer.parseInt(st.nextToken());
            }

            //선택 정렬 사용해보기!
            selectionSort(intArr);

            //양 끝을 제외하고 sum구하고, 평균 계산해서 프린트
            int sum = 0;
            for(int i=1; i<9; i++){
                sum+=intArr[i];
            }
            System.out.printf("#%d %d\n",t,Math.round((double)sum/8));
        }
        br.close();
    }

     static void selectionSort(int[] intArr){
        int len = intArr.length;
        for(int i=0; i<len-1; i++){
            int min = i;
            for(int j=i+1; j<len; j++){
                if(intArr[j]<intArr[min]) min=j;
            }
            int tmp=intArr[min];
            intArr[min] = intArr[i];
            intArr[i] = tmp;
        }
    }
    
}
