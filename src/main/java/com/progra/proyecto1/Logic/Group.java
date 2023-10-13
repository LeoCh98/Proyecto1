/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Logic;

/**
 *
 * @author leoch
 */
public class Group {

    private int id;
    private int sequence;
    private String name;
    private int capacity;
    private boolean active;

    public Group() {
    }

    public Group(int id, int sequence, String name, int capacity, boolean active) {
        this.setId(id);
        this.sequence = sequence;
        this.name = name;
        this.capacity = capacity;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return id + sequence + name + capacity + active;
    }
    
}
