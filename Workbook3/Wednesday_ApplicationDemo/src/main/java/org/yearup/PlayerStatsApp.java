package org.yearup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerStatsApp
{

    private Player[] players = new Player[0];

    public void run()
    {
        loadPlayers("2k23_players_1.csv");
        displayPlayers();
        System.out.println();

        loadPlayers("2k23_players_2.csv");
        displayPlayers();
    }

    public void loadPlayers(String fileName)
    {
        // I have to resize the array first - before I can add any new players
        // figure out how big the new array needs to be
        int currentSize = players.length;
        int newSize = currentSize + 5;
        // create a new temp array that is the new size
        Player[] tempArray = new Player[newSize];
        // copy all players from the current array into the new array
        System.arraycopy(players, 0, tempArray, 0, currentSize);
        // point the players variable to the new array
        players = tempArray;


        // NOW I can read the file and add new players
        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(fileStream);

            fileScanner.nextLine();

            // start adding AFTER the current last player
            int lineCount = currentSize;
            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");

                String name = columns[0];
                int overall = Integer.parseInt(columns[1]);
                int threes = Integer.parseInt(columns[2]);
                int dunk = Integer.parseInt(columns[3]);

                Player player = new Player(name, overall, threes, dunk);

                players[lineCount] = player;
                lineCount++;
            }

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void displayPlayers()
    {
        for (int i = 0; i < players.length; i++)
        {
            Player player = players[i];
            System.out.printf("%-25s %-3d %-3d %d \n", player.getName(), player.getOverallRating(), player.getThreeRating(), player.getDunkRating());
        }
    }
}
