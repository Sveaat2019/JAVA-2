import java.util.Random;

public class Robot implements RunJump {
    private String type = "Robot";
    private String name;
    private static int IDnumber = 1;
    private int ID;
    private int age;
    private float maxRun;
    private float maxJump;
    private final Random random = new Random();

    Robot (String name, int age, float maxJump, float maxRun)
    {
        this.name = name;
        this.ID = IDnumber;
        IDnumber++;
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

    int getID()
    {
        return ID;
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
