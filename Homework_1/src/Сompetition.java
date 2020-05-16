public class Сompetition {

    public static void main(String[] args) {

        String eventResult;

       Man a1 = new Man("Алексей", 27, 100, 2000);
       Man a2 = new Man("Алёна", 25, 100, 2000);

       Cat b1 = new Cat("Борис", "black", 3, 90, 1800);
       Cat b2 = new Cat("Маруся", "redhead", 2, 90, 1800);

       Robot c1 = new Robot("R2D2", 5, 110, 2100);
       Robot c2 = new Robot("T-1000", 1, 130, 2200);

       RunJump [] participant = {a1, a2, b1, b2, c1, c2};


       Wall wall_1 = new Wall(100);
       Wall wall_2 = new Wall(80);
       Wall wall_3 = new Wall(120);
       RunningTrack runTr_1 = new RunningTrack(1700);
       RunningTrack runTr_2 = new RunningTrack(2000);
       RunningTrack runTr_3 = new RunningTrack(2200);


        Tests [] test = {wall_1, runTr_1, wall_2, runTr_2, wall_3, runTr_3};



        for (int i = 0; i < participant.length; i++)
        {
            for (int j = 0; j < test.length; j++)
            {
                String nameString = participant[i].getType() + " " + participant[i].getName() + " can ";

                String eventName = String.format("jump max %.2fcm. Tries to jump ", participant[i].getMaxJump());

                if (test[j] instanceof Wall) {
                    eventResult = (participant[i].jump((Wall) test[j]) ? "succeed" : "fails");
                    System.out.println(nameString + eventName + test[j].doIt() + "m and " + eventResult);
                    if (eventResult.equals("fails")) i++;
                }

                if (test[j] instanceof RunningTrack) {
                    eventName = String.format("run max %.2fm. Tries to run ", participant[i].getMaxRun());
                    eventResult = participant[i].run((RunningTrack) test[j]) ? "succeed" : "fails";
                    System.out.println(nameString + eventName + test[j].doIt() + "m and " + eventResult);
                    if (eventResult.equals("fails")) i++;
                }
            }
        }

    }
}
