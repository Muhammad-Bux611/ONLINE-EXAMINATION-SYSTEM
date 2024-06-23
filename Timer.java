public class Timer {
    private int timeRemaining; // in seconds

    public Timer(int durationMinutes) {
        this.timeRemaining = durationMinutes * 60; // convert minutes to seconds
    }

    public void start() {
        while (timeRemaining > 0) {
            try {
                Thread.sleep(1000); // sleep for 1 second
                timeRemaining--;
                System.out.println("Time remaining: " + timeRemaining + " seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time's up! Auto-submitting test.");
        // Perform auto-submit logic here
    }
}
