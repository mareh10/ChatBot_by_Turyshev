package com.company;

import java.util.Scanner;

class ChatBot
{
    private Scanner scanner = new Scanner(System.in);

    ChatBot()
    {
        System.out.println("Привет, я Чат Бот! Пообщаемся? Напиши /start и начнем :)");
    }

    void run()
    {
        String s = this.scanner.next();
        if ("/start".equals(s)) {
            System.out.println("Выбирай занятие: \n 1: Викторина");
            while (true)
            {
                switch (this.scanner.next())
                {
                    case "1":
                        var quiz = new Quiz();
                        quiz.runQuiz();

                }
            }
        }
    }
}
