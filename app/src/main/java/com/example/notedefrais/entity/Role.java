package com.example.notedefrais.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private int id;
    private String roleName;

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for roleName
    public String getRoleName() {
        return roleName;
    }

    // Setter for roleName
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}


