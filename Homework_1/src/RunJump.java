public interface RunJump {

    boolean jump(Wall height);


    boolean run(RunningTrack distance);

    String getName();

    String getType();

    float getMaxRun();

    float getMaxJump();
}
