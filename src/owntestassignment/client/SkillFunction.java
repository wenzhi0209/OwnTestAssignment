/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owntestassignment.client;

import java.util.Random;
import adt.LinkedStack;
import java.util.Scanner;
import owntestassignment.entity.SpecialSkill;

/**
 *
 * @author wenzh
 */
public class SkillFunction {

    
    /**
     *
     * @return
     */
    public SpecialSkill getAskill()
    {
        SpecialSkill a= new SpecialSkill("Double Chance", "You will have double chance to answer a question.", 1, 'A');
        return a;
    }

}
