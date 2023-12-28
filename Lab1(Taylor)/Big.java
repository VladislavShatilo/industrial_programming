import java.math.BigInteger;
import java.math.RoundingMode;
import java.math.BigDecimal;

import java.util.Scanner;

public class Big
{
    static BigInteger calculateFactorial(int n)
    {
        BigInteger result = new BigInteger("1");

        for (long i=2; i <= n; ++i)
        {
            result= result.multiply( BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args)
    {
        double x;
        int k, i = 2;
        Scanner in = new Scanner(System.in);
        System.out.println("Input X");
        x = in.nextDouble();
        System.out.println("Input k");
        k = in.nextInt();
        BigDecimal e = BigDecimal.valueOf(Math.pow(10, -k));
        BigDecimal term = BigDecimal.valueOf(Math.pow(x, i));
        term = term.divide(new BigDecimal(calculateFactorial(i)),k+1,RoundingMode.DOWN);
        BigDecimal sum = new BigDecimal(1);
        sum = sum.add(term);
        while(term.compareTo(e) == 1)
        {
            i+=2;
            term = BigDecimal.valueOf(Math.pow(x, i));
            term = term.divide(new BigDecimal(calculateFactorial(i)),k+1,RoundingMode.DOWN);
            sum = sum.add(term);
        }
        System.out.println(sum);
        System.out.println(Math.cosh(x));

    }
}
