package com.gamingroom;
/**
 * Base class for all entities in the game application
 * Holds common attributes and behaviors
 */
public class Entity {
    private String id;
    private String name;
    
    /**
     * Constructor for Entity
     * @param id unique identifier
     * @param name name of the entity
     */
    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}