public class Wall extends Tests {

    private int height = 100;

    public Wall() {};
    public Wall(int height)
    {
        this.height = height;
    }

       public void setHeight(int height)
    {
        this.height = height;
    }

    @Override
    int doIt() {
        return height;
    }
}
