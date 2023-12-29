package org.example;

import java.util.Scanner;
import java.util.Formatter;

public class Main
{
    public static long calculateFactorial(int n)
    {
        long result = 1;
        for (int i = 1; i <=n; i ++)
        {
            if(result > Integer.MAX_VALUE)
            {
                return result;
            }
            result = result*i;
        }
        return result;
    }
    public static double calculateTaylor(double k,double x)
    {
        double sum = 1;
        double term1 =1;
        int i =4;
        double e = Math.pow(10,-k);
        double term = x * x;
        sum += (term/2);

        while(Math.abs(term1)>e)
        {
            term = term * x * x;
            term1 = term / calculateFactorial(i);
            i+=2;
            sum += term1;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        double   x, k, e, term, term1= 1, sum = 1;
        int i = 4;
        Scanner in = new Scanner(System.in);
        System.out.println("Input X");
        x = in.nextDouble();

        System.out.println("Input k");
        k = in.nextInt();



        System.out.println(calculateTaylor(k,x));
        System.out.println(Math.cosh(x));

        in.close();
        int f =213;
        Formatter F = new Formatter();
        F.format("213 in 16x: %x\n", f);
        F.format("213 in 8x: %o\n", f);

        System.out.println(F);
        System.out.printf("%+011.1f\n",x);

    }

}
