package task8;

import java.util.List;

public class ApiResponse {
    public int response_code;
    public List<ApiQuestion> results;

    public static class ApiQuestion {
        public String question;
        public String correct_answer;
        public List<String> incorrect_answers;
    }
}