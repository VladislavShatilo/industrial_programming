package org.example;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.math.BigDecimal;

import java.util.Scanner;

public class Big
{
    public static BigInteger bigFactorial(int n)
    {
        BigInteger result = new BigInteger("1");
        for (long i=2; i <= n; ++i)
        {
            result= result.multiply( BigInteger.valueOf(i));
        }
        return result;
    }
    public static BigDecimal BigTaylor(int k, double x)
    {

        int i =2;
        BigDecimal e = BigDecimal.valueOf(Math.pow(10, -k));
        BigDecimal term = BigDecimal.valueOf(Math.pow(x, i));
        term = term.divide(new BigDecimal(bigFactorial(i)),k+1,RoundingMode.DOWN);
        BigDecimal sum = new BigDecimal(1);
        sum = sum.add(term);
        while(term.compareTo(e) > 0)
        {
            i+=2;
            term = BigDecimal.valueOf(Math.pow(x, i));
            term = term.divide(new BigDecimal(bigFactorial(i)),k+1,RoundingMode.DOWN);
            sum = sum.add(term);
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int k;
        double x;
        Scanner in = new Scanner(System.in);
        System.out.println("Input X");
        x = in.nextDouble();
        System.out.println("Input k");
        k = in.nextInt();

        System.out.println(BigTaylor(k,x));
        System.out.println(Math.cosh(x));

    }
}
