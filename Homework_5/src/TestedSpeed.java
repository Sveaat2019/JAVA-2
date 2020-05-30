import java.util.Arrays;

public class TestedSpeed {



    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];




    public static void main(String[] args) throws InterruptedException {







        float [] arr2 = fillArray(arr);



        long a = System.currentTimeMillis();

        float [] arr3 = mathArray(arr2);

        System.out.println("Затраченное время: " + Thread.currentThread().getName() + "  " + (System.currentTimeMillis() - a));



        long b = System.currentTimeMillis();

        float [] arr4 = mathArray2(arr2, a1, a2);


        System.out.println("Затраченное время двумя потоками: " + (System.currentTimeMillis() - b));

        if (Arrays.equals(arr3, arr4))
        {
            System.out.println("Массивы одинаковы!");
        }
        else
            {
        System.out.println("Массивы разные!");
            }




    }


     public static float[] fillArray(float[] arr)
     {
         for (int i = 0; i < arr.length; i++)
         {
             arr[i] = 1;
         }
         return arr;
     }

     public static float [] mathArray(float[] arr)
     {
         for (int i = 1; i < arr.length; i ++)
         {
             arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }
         return arr;
     }

     public static float [] mathArray2(float[] arr, float[] a1, float[] a2)
     {
         System.arraycopy(arr, 0, a1, 0, h);
         System.arraycopy(arr, h, a2, 0, h);

         NewThread  tr1 = new NewThread(a1, "Поток №1", 0);
         NewThread  tr2 = new NewThread(a2, "Поток №2", h);

         try
         {
             tr1.t.join();
             tr2.t.join();
         }
         catch (InterruptedException e)
         {
             throw new RuntimeException(e);
         }


         System.arraycopy(tr1.getArr2(), 0, arr, 0, h);
         System.arraycopy(tr2.getArr2(), 0, arr, h, h);
         return arr;
     }


}
