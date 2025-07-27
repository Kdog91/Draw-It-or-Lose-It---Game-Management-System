package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class Team extends Entity {
    private List<Player> players;
    
    public Team(String id, String name) {
        super(id, name);
        this.players = new ArrayList<Player>();
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public List<Player> getPlayers() {
        return players;
    }
}