public class StepTracker
{
    // copy the instance variable declarations here
    private int minSteps;
    private int activeDays;
    private int totalSteps;
    private int daysTracked;

    // copy the constructor with a parameter here
    public StepTracker(int min)
    {
        minSteps = min;
        activeDays = 0;
        totalSteps = 0;
        daysTracked = 0;
    }

    // copy the accessor method activeDays() here.
    public int activeDays()
    {
        return activeDays;
    }

    public double averageSteps()
    {
        if (daysTracked == 0)
        {
            return 0.0;
        }
        else
        {
            return (double) totalSteps / daysTracked;
        }
    }

    // Write the mutator method addDailySteps here.
    // @param number of steps taken that day
    public void addDailySteps(int steps)
    { 
        totalSteps += steps;
        daysTracked++;
        if (steps >= minSteps)
        {
            activeDays++;
        }
    }

    public static void main(String[] args)
    {
        StepTracker tr = new StepTracker(10000);
        // returns 0. No data has been recorded yet.
        System.out.println(tr.activeDays());
        // returns 0.0. When no step data have been recorded,
        //  the averageSteps method returns 0.0
        System.out.println(tr.averageSteps());

        // This is too few steps for the day to be considered active.
        tr.addDailySteps(9000);

        // This is too few steps for the day to be considered active.
        tr.addDailySteps(5000);

        // returns 0.  No day had at least 10,000 steps.
        System.out.println(tr.activeDays());
        // returns 7000.0 The average number of steps per day is (14000/2).
        System.out.println(tr.averageSteps());

        // This represents an active day.
        tr.addDailySteps(13000);
        // returns 1. Of the three days for which step data were entered,
        // one day had at least 10,000 steps.
        System.out.println(tr.activeDays());
        // returns 9000.0. The average number of steps per day is (27000/3).
        System.out.println(tr.averageSteps());

        tr.addDailySteps(23000); // This represents an active day.
        tr.addDailySteps(1111); // This is too few steps for the day to be active.
        // returns 2. Of the five days for which step data were entered,
        //    two days had at least 10,000 steps.
        System.out.println(tr.activeDays());
        // returns 10222.2. The average number of steps per day is (51111/5).
        System.out.println(tr.averageSteps());
    }
}

