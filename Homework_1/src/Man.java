import java.util.Random;

public class Man implements RunJump {
    private String type = "Man";
    private String name;
    private int age;
    private float maxRun;
    private float maxJump;
    private final Random random = new Random();

    Man (String name, int age, float maxJump, float maxRun)
    {
        this.name = name;
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
        return name;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public float getMaxRun()
    {
        return this.maxRun;
    }

    @Override
    public float getMaxJump()
    {
        return this.maxJump;
    }
}
