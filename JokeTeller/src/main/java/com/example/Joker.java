package com.example;


import java.util.Random;

/**
 * Created by ryand on 6/15/2016.
 */
public class Joker {

  private static String[] jokeList = {
          "I for one like Roman numerals.",
          "If I had a dollar for every time a girl told me I was unattractive, they'd eventually find me attractive.",
          "I have an inferiority complex, but it's not a very good one.",
          "Apparently, I snore so loudly that it scares everyone in the car that I'm driving.",
          "I find that a duck’s opinion of me is very much influenced over whether or not I have bread.",
          "I order the club sandwich all the time. And I’m not even a member, man. I don’t know how I get away with it.",
          "The worst time to have a heart attack is during a game of charades.",
          "I bought a cactus. A week later it died. And I got depressed, because I thought, Man. I am less nurturing than a desert.",
          "I used to play sports. Then I realized you can buy trophies. Now I am good at everything.",
          "The digital camera is a great invention because it allows us to reminisce. Instantly.",
          "The easiest time to add insult to injury is when you're signing their cast.",
          "Saying I'm sorry is the same as I apologize... except at a funeral",
          "There should be a children’s song, ‘If You’re Happy And You Know It, Keep It To Yourself And Let Your Dad Sleep.",
          "You know what it’s like having a fourth kid? Imagine you’re drowning, then someone hands you a baby.",
          "You think when gym teachers are younger, they're thinking, 'You know I want to teach, but I don't want to read"

  };

  public static String getJoke(){
    Random rand = new Random();
    int randomNum = rand.nextInt((jokeList.length - 0));
    return jokeList[randomNum];
  }


}
