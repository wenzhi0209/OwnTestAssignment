/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Winnie wong
 */
public class Player {
    String name;
    String id;
    double score;
    String password;

    public Player(String name, String id, double score, String password) {
        this.name = name;
        this.id = id;
        this.score = score;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", id=" + id + ", score=" + score + ", password=" + password + '}';
    }
    
    
}
