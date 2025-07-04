package task8;

import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int correctIndex;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        Collections.shuffle(this.options);
        this.correctIndex = this.options.indexOf(correctAnswer);
    }

    public void display(int number, int total) {
        System.out.println("\n\uD83D\uDCCB Question " + number + " of " + total);
        System.out.println("❓ " + question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userAnswer) {
        return (userAnswer - 1) == correctIndex;
    }

    public String getCorrectAnswer() {
        return options.get(correctIndex);
    }

    public String getQuestion() {
        return question;
    }
}