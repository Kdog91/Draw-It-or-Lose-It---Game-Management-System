package com.gamingroom;

/**
 * Represents a player in the game, inherits from Entity
 */
public class Player extends Entity {
    /**
     * Constructor for Player
     * @param id unique identifier
     * @param name name of the player
     */
    public Player(String id, String name) {
        super(id, name);
    }
    
    @Override
    public String toString() {
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}
