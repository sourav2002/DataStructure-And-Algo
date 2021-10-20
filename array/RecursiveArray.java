package array;

import java.time.LocalDateTime;
import java.util.Scanner;

class Practical
{
    public static void main(String[] args)
    {
        LocalDateTime t1 = LocalDateTime.now();
        System.out.println(t1);
        System.out.println("Mihir501");
        System.out.println("Practical\n");

                Scanner input = new Scanner(System.in);
                int product=1;
                System.out.print("Enter five integers: ");
                int[] list = new int[5];
                for (int i = 0; i < list.length; i++)
                {
                    list[i] = input.nextInt();
                    product *= list[i];
                }
                System.out.println("The Product of elements is " + product);
            }
        }
