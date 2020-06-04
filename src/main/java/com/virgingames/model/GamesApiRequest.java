package com.virgingames.model;


/*
 * Ravi's Creation
 * Date of Creation 01/06/20
 */

public class GamesApiRequest {

    public static GamesPojo getAPIGamesRequest(String gameName, int gameFreq) {

        GamesPojo gamesPojo = new GamesPojo();

        if (gameName != null) {
            gamesPojo.setGameName(gameName);
        }
        if (gameFreq != 300000) {
            gamesPojo.setGameFreq(gameFreq);
        }
return gamesPojo;
    }
}