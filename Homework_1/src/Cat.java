import java.util.Random;

  public class Cat implements RunJump {

    private String type = "Cat";
    private String name;
    private String color;
    private int age;
    private float maxRun;
    private float maxJump;
    private final Random random = new Random();

    Cat (String name, String color, int age, float maxJump, float maxRun)
    {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxJump = createVariation(maxJump);
        this.maxRun = createVariation(maxRun);
    }

    private float createVariation(float reference)
    {
        return reference + random.nextFloat() * reference - (reference / 2);
    }

      @Override
      public boolean jump(Wall height)
      {
          return (height.doIt() <= maxJump);
      }

      @Override
      public boolean run(RunningTrack distance)
      {
          return (distance.doIt() <= maxRun);
      }

      @Override
      public String getName()
      {
          return this.name;
      }

      String getColor()
      {
          return color;
      }

      public int getAge()
      {
          return age;
      }

      @Override
      public String getType()
      {
          return this.type;
      }

      public float getMaxRun()
      {
          return this.maxRun;
      }

      public float getMaxJump()
      {
          return this.maxJump;
      }
}
