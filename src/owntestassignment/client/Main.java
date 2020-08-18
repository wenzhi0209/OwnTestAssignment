/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owntestassignment.client;
import java.util.Scanner;

/**
 *
 * @author wenzh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //the main will go through the game
        Scanner scan=new Scanner(System.in);
        Game person1;
        //game2
        //game3
        //game4
        
        //game 1,2,3,4 arrage with queue
        //single player not neet queue
        System.out.println("HERE WILL BE THE MENU");
        System.out.println("Choose Single player mode");
        System.out.println("Please enter your name");
        String name=scan.next();
        
        //after all parameter pass in create the game identity for player
        person1=new Game(name);
        person1.deductMark();
        person1.useSkill();
        
        
        // what if multiplayer
        // set to 4 and let player enter their name
        // troblesome so just let player select player from the player record
        
        
    }
    
}
