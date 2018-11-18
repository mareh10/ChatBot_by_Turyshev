package com.company;

import java.util.*;

class Shuffler {

    static String[] shuffle(String[] arr) {
        Random rnd = new Random(System.nanoTime());
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, rnd.nextInt(arr.length));
        }
        return arr;
    }

    private static void swap(String[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Quiz
{
    private Question[] questions;
    private Scanner scanner = new Scanner(System.in);

    Quiz() {
        questions = QuestionsParser.getQuestions(
                RequestToURL.openUrl("https://baza-otvetov.ru/categories/view/1/"));
    }

    void runQuiz() {
        var random = new Random();
        while (true) {
            var index = random.nextInt(10);
            var question = questions[index];
            System.out.println(question.Question);

            for (var variant : Shuffler.shuffle(question.Variants))
                System.out.println(variant);

            var userAnswer = this.scanner.next();
            if (userAnswer.toLowerCase().equals(question.CorrectAnswer.toLowerCase()))
                System.out.println("Йай! Молодцом");
            else
                System.out.println("Неправильно, давай еще раз");
        }
    }

}
