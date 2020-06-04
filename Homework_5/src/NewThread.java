public class NewThread implements Runnable {


    Thread t;
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float [] arr = new float[h];
    private float [] arr2 = new float[h];
    private int val;

   NewThread (float [] arr, String name, int val)
   {
       setArr2(arr);
       this.val = val;
       t = new Thread(this, name);
       t.start();
   }

    private void setArr2(float [] arr)
    {
        arr2 = arr;
    }

    public float[] getArr2()
    {
        return arr2;
    }

    @Override
    public void run()
    {
        System.out.println(t.getName() + " запущен!");
         for (int i = 1; i < arr.length; i ++)
            {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + val) / 5) * Math.cos(0.2f + (i + val) / 5) * Math.cos(0.4f + (i + val) / 2));
            }
            setArr2(arr);
        System.out.println(t.getName() + " остановлен!");
    }
}
