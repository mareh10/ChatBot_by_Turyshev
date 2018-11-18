package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class QuestionsParser {
    static Question[] getQuestions(ArrayList<String> data) {
        ArrayList<Question> questions = new ArrayList<>();
        Question question = new Question(null, null, null);

        Pattern questionFinder = Pattern.compile(">.*?</a>");
        Pattern answerFinder = Pattern.compile(":\\s.+?, .+?, .+?\\s");
        Pattern correctAnswerFinder = Pattern.compile("<td>\\D+?</td>");
        Matcher matcher;

        String[] answers = new String[4];

        for (String line : data) {
            if (line.matches(".*?<a href=\"/search/view/.*"))
            {
                matcher = questionFinder.matcher(line);
                if (matcher.find())
                {
                    question.Question = matcher.group().substring(1, matcher.group().length() - 4);
                }
            }
            if (line.matches(".*?Ответы для викторин: .*?"))
            {
                matcher = answerFinder.matcher(line);
                if (matcher.find())
                {
                    String[] vars = matcher.group().split(", ");
                    answers[0] = vars[0].substring(2);
                    answers[1] = vars[1];
                    answers[2] = vars[2].trim();
                }
            }
            if (line.matches(".*?<td>\\D+?</td>.*?"))
            {
                matcher = correctAnswerFinder.matcher(line);
                if (matcher.find())
                {
                    question.CorrectAnswer = matcher.group().substring(4, matcher.group().length() - 5);
                    answers[3] = question.CorrectAnswer;
                    question.Variants = answers;
                    answers = new String[4];

                    questions.add(question);
                    question = new Question(null, null, null);
                }
            }
        }
        return questions.toArray(new Question[0]);
    }
}
