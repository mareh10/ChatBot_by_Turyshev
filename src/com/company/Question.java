package com.company;

class Question
{
    String Question;
    String[] Variants;
    String CorrectAnswer;

    Question(String question, String[] variants, String correctAnswer)
    {
        this.Question = question;
        this.Variants = variants;
        this.CorrectAnswer = correctAnswer;
    }
}
