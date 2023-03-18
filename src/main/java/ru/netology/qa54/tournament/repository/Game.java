package ru.netology.qa54.tournament.repository;

import ru.netology.qa54.tournament.domain.Player;
import ru.netology.qa54.tournament.exceptions.NotRegisterException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }

        }

        if (player1 == null) {
            throw new NotRegisterException(
                    "Игрок с именем: " + playerName1 + " не найден"
            );
        }
        if (player2 == null) {
            throw new NotRegisterException(
                    "Игрок с именем: " + playerName2 + " не найден"
            );

        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return -1;
        }
        return 0;
    }
}
