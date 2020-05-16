public class RunningTrack extends Tests{
    private int distance = 2000;

    RunningTrack() {};
    RunningTrack(int distance)
    {
        this.distance = distance;
    }


    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    @Override
    int doIt() {
        return distance;
    }
}
