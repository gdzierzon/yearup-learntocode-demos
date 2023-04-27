package org.yearup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayerStatsApp2
{
    private ArrayList<Player> players = new ArrayList<>();

    public void run()
    {
        loadPlayers("2k23_players_1.csv");
        displayPlayers();
        System.out.println();

        loadPlayers("2k23_players_2.csv");
        Collections.sort(players);
        displayPlayers();
    }

    public void loadPlayers(String fileName)
    {
        // NOW I can read the file and add new players
        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(fileStream);

            fileScanner.nextLine();

            // start adding AFTER the current last player
            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");

                String name = columns[0];
                int overall = Integer.parseInt(columns[1]);
                int threes = Integer.parseInt(columns[2]);
                int dunk = Integer.parseInt(columns[3]);

                Player player = new Player(name, overall, threes, dunk);
                players.add(player);
            }

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void displayPlayers()
    {
        for (int i = 0; i < players.size(); i++)
        {
            Player player = players.get(i);
            System.out.printf("%-25s %-3d %-3d %d \n", player.getName(), player.getOverallRating(), player.getThreeRating(), player.getDunkRating());
        }
    }
}
