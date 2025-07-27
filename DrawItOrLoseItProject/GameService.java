package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage games, teams, and players
 * Implements Singleton pattern to ensure only one instance exists
 */
public class GameService {
    // Singleton instance
    private static GameService instance = null;
    
    // Static variables for ID generation
    private static int nextGameId = 1;
    private static int nextTeamId = 1;
    private static int nextPlayerId = 1;
    
    // Collections to store game entities
    private List<Game> games = new ArrayList<Game>();
    private List<Team> teams = new ArrayList<Team>();
    private List<Player> players = new ArrayList<Player>();
    
    // Private constructor for Singleton
    private GameService() {}
    
    /**
     * Gets the singleton instance of GameService
     * @return GameService instance
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }
    
    /**
     * Adds a new game with a unique name
     * @param gameName name of the game
     * @return created Game object
     * @throws IllegalArgumentException if game name already exists
     */
    public Game addGame(String gameName) {
        // Check for unique name using iterator pattern
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                throw new IllegalArgumentException("Game name already exists");
            }
        }
        
        String gameId = "G" + nextGameId++;
        Game game = new Game(gameId, gameName);
        games.add(game);
        return game;
    }
    
    /**
     * Gets a game by name
     * @param gameName name of the game to find
     * @return Game object if found, null otherwise
     */
    public Game getGame(String gameName) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return null;
    }
    
    /**
     * Gets all games
     * @return list of games
     */
    public List<Game> getGames() {
        return games;
    }
    
    /**
     * Adds a new team with a unique name
     * @param teamName name of the team
     * @return created Team object
     * @throws IllegalArgumentException if team name already exists
     */
    public Team addTeam(String teamName) {
        // Check for unique name
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                throw new IllegalArgumentException("Team name already exists");
            }
        }
        
        String teamId = "T" + nextTeamId++;
        Team team = new Team(teamId, teamName);
        teams.add(team);
        return team;
    }
    
    /**
     * Gets all teams
     * @return list of teams
     */
    public List<Team> getTeams() {
        return teams;
    }
    
    /**
     * Adds a new player with a unique name
     * @param playerName name of the player
     * @return created Player object
     * @throws IllegalArgumentException if player name already exists
     */
    public Player addPlayer(String playerName) {
        // Check for unique name
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                throw new IllegalArgumentException("Player name already exists");
            }
        }
        
        String playerId = "P" + nextPlayerId++;
        Player player = new Player(playerId, playerName);
        players.add(player);
        return player;
    }
    
    /**
     * Gets all players
     * @return list of players
     */
    public List<Player> getPlayers() {
        return players;
    }
}