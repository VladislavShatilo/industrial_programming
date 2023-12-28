import java.util.Scanner;
import java.util.Formatter;

public class lab1Class
{
    static long calculateFactorial(int n)
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

    public static void main(String[] args)
    {
        double   x, k, e, term, term1= 1, sum = 1;
        int i = 4;
        Scanner in = new Scanner(System.in);
        System.out.println("Input X");
        x = in.nextDouble();

        System.out.println("Input k");
        k = in.nextInt();
        e = Math.pow(10,-k);
        term = x * x;
        sum += term/2;

        while(Math.abs(term1)>e)
        {
            term = term * x * x;
            term1 = term / calculateFactorial(i);
            i+=2;
            sum += term1;
        }
        System.out.println(sum);
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
