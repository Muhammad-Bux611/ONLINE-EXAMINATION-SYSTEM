import java.util.ArrayList;
import java.util.List;

public class Test {
    private String testName;
    private List<Question> questions;
    private int durationMinutes;

    public Test(String testName, int durationMinutes) {
        this.testName = testName;
        this.questions = new ArrayList<>();
        this.durationMinutes = durationMinutes;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getTestName() {
        return testName;
    }
}
