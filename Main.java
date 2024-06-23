import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample user and test creation
        User user = new User("user1", "password1", "John Doe");
        Test test = createTest();

        // Login process
        loginProcess(user);

        // Update profile and change password
        user.updateProfile("John Smith");
        user.changePassword("newpassword");

        // Take test
        takeTest(test);

        // Close session and logout (end of program)
        System.out.println("Session closed. Logging out.");
    }

    private static Test createTest() {
        Test test = new Test("Java Basics Test", 30); // 30 minutes duration

        // Add sample questions to the test
        test.addQuestion(new Question("What is Java?", new String[]{"A programming language", "A type of coffee", "An island"}, 0));
        test.addQuestion(new Question("What is a class?", new String[]{"A blueprint for objects", "A collection of data", "A type of method"}, 0));
        test.addQuestion(new Question("What is JVM?", new String[]{"Java Virtual Machine", "Java Visual Model", "Java Virtual Memory"}, 0));

        return test;
    }

    private static void loginProcess(User user) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (user.getUsername().equals(username) && user.authenticate(password)) {
            System.out.println("Login successful. Welcome, " + user.getUsername());
        } else {
            System.out.println("Invalid username or password. Please try again.");
            loginProcess(user);
        }
    }

    private static void takeTest(Test test) {
        System.out.println("Starting test: " + test.getTestName());
        Timer timer = new Timer(test.getDurationMinutes());
        Thread timerThread = new Thread(() -> timer.start());
        timerThread.start();

        for (Question question : test.getQuestions()) {
            System.out.println("\n" + question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter your choice (1-" + options.length + "): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice >= 1 && choice <= options.length) {
                boolean isCorrect = question.isCorrect(choice - 1);
                System.out.println("Your answer is " + (isCorrect ? "correct" : "incorrect"));
            } else {
                System.out.println("Invalid choice. Skipping question.");
            }
        }

        // End of test logic (can include auto-submit functionality here)
        try {
            timerThread.join(); // Wait for timer thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
