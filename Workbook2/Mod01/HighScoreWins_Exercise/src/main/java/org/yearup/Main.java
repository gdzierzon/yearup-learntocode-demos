package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String allInput = "";
        String[] inputParts;
        String teamsString = "";
        String[] teams;
        String scoresString = "";
        String[] scores;
        String team1 = "";
        String score1 = "0";
        int team1Score = 0;
        String team2 = "";
        String score2 = "0";
        int team2Score = 0;

        // get user input
        System.out.println();
        System.out.print("Please enter a score: ");
        allInput = input.nextLine().strip();

        // split input into teams and scores
        inputParts = allInput.split("\\|");
        teamsString = inputParts[0];
        scoresString = inputParts[1];

        // get team names
        teams = teamsString.split(":");
        team1 = teams[0];
        team2 = teams[1];

        // get scores
        scores = scoresString.split(":");
        score1 = scores[0];
        score2 = scores[1];
        team1Score = Integer.parseInt(score1);
        team2Score = Integer.parseInt(score2);

        // display winner
        System.out.println("Team                 Score | Score                 Team");
        System.out.println("-------------------- -----   ----- --------------------");
        System.out.printf ("%-20s %5s   %-5d %20s\n", team1, team1Score, team2Score, team2);
        System.out.println();
        if(team1Score > team2Score)
        {
            System.out.printf("Winner: %s", team1);
        }
        else
        {
            System.out.printf("Winner: %s", team2);
        }
    }
}