package w18comp1011s2apr9;

import java.util.stream.IntStream;

/**
 *
 * @author JWright
 */
public class SimpleStreams
{
    public static void main(String[] args)
    {
        //old way to sum the numbers 1 to 10
        int sum=0;
        for (int i=1; i<=10; i++)
            sum += i;
        System.out.printf("The sum was: %d%n", sum);
        
        //new way using Streams
        System.out.printf("The sum with streams is: %d%n",  IntStream.rangeClosed(1,10)
                                                                     .sum());
        
        
    }
}
