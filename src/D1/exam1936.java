package D1;

import java.util.Scanner;

class exam1936
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int A;
        A=sc.nextInt();
        int B;
        B = sc.nextInt();

        String ans = "A";

        if((A==1 && B==2) || (A==2 && B==3) || (A==3 && B==1)) ans="B";

        System.out.println(ans);
    }
}