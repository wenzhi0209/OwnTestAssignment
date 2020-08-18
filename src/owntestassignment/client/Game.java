/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//------------------------------------------------------------------------------
// MAIN CONTROL FOR THE WHOLE APPLICATION
//------------------------------------------------------------------------------
package owntestassignment.client;
import entity.Player;
import owntestassignment.entity.SpecialSkill;

public class Game{
    
    Player player;
    int life;
    int score;
    SpecialSkill skill;
    
    //use static way can also
    SkillFunction test=new SkillFunction();
    
    
    public Game(String name)
    {
        //it should pass by parameter since
       player = new Player(name,"p1",0,"1111");
       int life=3;
       int score=0;
       skill=test.getAskill();
    
    }
    
    public void deductMark()
    {
        System.out.println(player.getName()+" Mark deducted");
        
    }
    
     public void useSkill()
    {
        System.out.println(player.getName()+"  "+skill.getName());
        
    }
    
    
    
    
    
       
    
    
    

        
}
