/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Logic;

import java.sql.Timestamp;

/**
* -------------------------------------------------------------------
*
* (c) 2023
*
* @author: Leonardo Chaves Hernández
*
* @version 1.0.0 2023-10-14
*
* --------------------------------------------------------------------
*/
public class Student {

    private String id;
    private int nrc;
    private String lastname;
    private String name;
    private int sequence;
    private String password;
    private Timestamp timeStamp;
    private Integer group;

    public Student() {
    }

    public Student(String id, int nrc, String lastname, String name, int sequence, String password, Timestamp timeStamp, Integer group) {
        this.id = id;
        this.nrc = nrc;
        this.lastname = lastname;
        this.name = name;
        this.sequence = sequence;
        this.password = password;
        this.timeStamp = timeStamp;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return id + nrc + lastname + name + sequence + password + timeStamp + group;
    }

}