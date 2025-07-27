package com.gamingroom;

/**
 * Main class to test the game application
 */
public class ProgramDriver {
    public static void main(String[] args) {
        // Get the GameService instance (Singleton)
        GameService gameService = GameService.getInstance();
        
        try {
            // Create some games
            Game game1 = gameService.addGame("Draw It or Lose It - Season 1");
           
            
            // Try to add duplicate game (should throw exception)
            try {
                gameService.addGame("Draw It or Lose It - Season 1");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }
            
            // Create teams
            Team teamA = gameService.addTeam("The Artists");
            Team teamB = gameService.addTeam("The Guessers");
            
            // Try to add duplicate team (should throw exception)
            try {
                gameService.addTeam("The Artists");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }
            
            // Create players
            Player player1 = gameService.addPlayer("Alice");
            Player player2 = gameService.addPlayer("Bob");
            Player player3 = gameService.addPlayer("Charlie");
            Player player4 = gameService.addPlayer("Dana");
            
            // Try to add duplicate player (should throw exception)
            try {
                gameService.addPlayer("Alice");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }
            
            // Add players to teams
            teamA.addPlayer(player1);
            teamA.addPlayer(player2);
            teamB.addPlayer(player3);
            teamB.addPlayer(player4);
            
            // Add teams to game
            game1.addTeam(teamA);
            game1.addTeam(teamB);
            
            // Display all games
            System.out.println("\nAll Games:");
            for (Game game : gameService.getGames()) {
                System.out.println(game);
                for (Team team : game.getTeams()) {
                    System.out.println("  " + team);
                    for (Player player : team.getPlayers()) {
                        System.out.println("    " + player);
                    }
                }
            }
            
            // Test getGame method
            System.out.println("\nSearching for game:");
            Game foundGame = gameService.getGame("Draw It or Lose It - Season 1");
            if (foundGame != null) {
                System.out.println("Found game: " + foundGame);
            } else {
                System.out.println("Game not found");
            }
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
