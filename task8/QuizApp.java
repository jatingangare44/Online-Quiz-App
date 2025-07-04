package task8;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        List<Question> quiz = fetchQuestionsFromAPI();
        if (quiz.isEmpty()) {
            System.out.println("❌ Failed to load quiz questions.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int total = quiz.size();

        System.out.println("\uD83E\uDDE0 Welcome to the Java Online Quiz App");
        System.out.println("Fetching questions from API... ✅");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < total; i++) {
            Question q = quiz.get(i);

            showProgressBar(i + 1, total);
            q.display(i + 1, total);

            System.out.print("\n⏳ Your answer (1-4): ");
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                answer = -1;
            }

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
                System.out.println("✔️ Correct Answer: " + q.getCorrectAnswer());
            }

            System.out.println("--------------------------------------------------");
        }

        int percent = (score * 100) / total;
        System.out.println("\n\uD83C\uDFC6 Quiz Completed!");
        System.out.println("📊 Final Score: " + score + " / " + total);
        System.out.println("🏆 Percentage: " + percent + "%");
        if (percent >= 90) System.out.println("🎉 Excellent! You're a quiz wizard!");
        else if (percent >= 70) System.out.println("👍 Great job! Keep it up!");
        else if (percent >= 50) System.out.println("😊 Not bad! Practice more!");
        else System.out.println("😟 Keep practicing. You'll improve!");

        scanner.close();
    }

    private static List<Question> fetchQuestionsFromAPI() {
        List<Question> quiz = new ArrayList<>();
        try {
            URL url = new URL("https://opentdb.com/api.php?amount=10&type=multiple");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            ApiResponse response = gson.fromJson(jsonBuilder.toString(), ApiResponse.class);

            for (ApiResponse.ApiQuestion apiQ : response.results) {
                List<String> options = new ArrayList<>(apiQ.incorrect_answers);
                String correct = htmlDecode(apiQ.correct_answer);
                options.add(correct);
                quiz.add(new Question(
                        htmlDecode(apiQ.question),
                        decodeList(options),
                        correct
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quiz;
    }

    private static void showProgressBar(int current, int total) {
        int progress = (int) (((double) current / total) * 10);
        System.out.print("\nProgress: [");
        for (int i = 0; i < 10; i++) {
            System.out.print(i < progress ? "#" : "-");
        }
        System.out.println("] " + current + "/" + total);
    }

    private static String htmlDecode(String input) {
        return input.replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }

    private static List<String> decodeList(List<String> list) {
        List<String> decoded = new ArrayList<>();
        for (String s : list) {
            decoded.add(htmlDecode(s));
        }
        return decoded;
    }
}