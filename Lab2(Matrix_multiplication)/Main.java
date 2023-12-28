package org.example;

import java.util.*;
import java.text.NumberFormat;
class lab2Class
{
    public static void main(String[] args)
    {
        int m,n, K1, K2;
        System.out.println("Input m, n");
        Scanner in = new Scanner(System.in);
        m = in.nextInt();

        n = in.nextInt();

        Integer[][] matrix1 = new Integer[m][n];
        Integer[][] matrix2 = new Integer[m][n];
        Integer[][] matrix3 = new Integer[m][n];
        for(int i =0; i < m; ++i)
        {
            for(int j =0; j < n; ++j)
            {
                matrix2[i][j] = (int)(Math.random() * 10 );
                matrix1[i][j] = (int)(Math.random() * 10 );
            }

        }
        System.out.println("matrix1");
        for(int i =0; i < m; ++i)
        {
            for(int j =0; j < n; ++j)
            {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nmatrix2");

        for(int i =0; i < m; ++i)
        {
            for(int j =0; j < n; ++j)
            {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("Input K1, K2");

        K1 = in.nextInt();

        K2 = in.nextInt();
        for(int i =0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                matrix3[i][j] = K1 * matrix1[i][j] + K2 * matrix2[i][j];


            }
        }

        System.out.println();
        System.out.println("matrix3");
        System.out.println();
        Comparator<Integer> comparator = Comparator.naturalOrder();


        Arrays.sort(matrix3[0],0, 5);
        Arrays.sort(matrix3[1],comparator);


        NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance();
        for(int i =0; i < m; ++i)
        {
            for(int j =0; j < n; ++j)
            {
                System.out.print(numberFormat3.format(matrix3[i][j]) + " ");
            }
            System.out.println();
        }




    }
}
