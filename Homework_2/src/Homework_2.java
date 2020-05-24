import com.sun.javafx.binding.StringFormatter;

import java.util.Arrays;
import java.util.Scanner;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static java.lang.Integer.parseInt;

public class Homework_2 {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException
    {

        String [][] arr = new String[4][4];

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите элементы массива!");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextLine();
            }
        }
        sc.close();


      try
      {
          System.out.println("Summ of Arr is " + checkArray(arr));
      }
      catch (MyArraySizeException | MyArrayDataException e)
      {
          printStackTrace();
      }

    }

    public static int checkArray (String [][] arr) throws MyArraySizeException, MyArrayDataException
    {
        int sum = 0;
        try
        {
             if ((arr.length != 4) || (arr[0].length != 4)) throw new MyArraySizeException("Передан не верный размер массива!");
        }

        catch (MyArraySizeException e)
        {
            System.out.println("Не правильный размер массива!");
        }

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                try
                {
                    sum += parseInt(arr[i][j]);
                }

                catch (NumberFormatException e)
                {
                    throw new MyArrayDataException ("Error in cell № " + (i+1) + ":" + (j+1) + " contains " + arr[i][j]);
                }

            }
        }
        return sum;
    }
}

class MyArraySizeException extends  NegativeArraySizeException {

    String s;

    public MyArraySizeException(String s)
    {
        this.s = s;
        printStackTrace();
    }

    @Override
    public void printStackTrace()
    {
        System.err.println(s);
    }
}

class MyArrayDataException extends NumberFormatException {

    String println;
    public MyArrayDataException(String println)
    {
        this.println = println;
        printStackTrace();
    }

    @Override
    public void printStackTrace() {
        System.err.println("Ошибка!" + println);
    }
}