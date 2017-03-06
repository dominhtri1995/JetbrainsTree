/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class ObjectTest {
    
    String name;
    int age;
    String position;
    public ObjectTest(String name,String position, int age) {
        this.name =name;
        this.age = age;
        this.position = position;
    }
    @Test
    public void test() {
        JBStruct jb = new JBStruct();
        //add
        jb.add(new ObjectTest("jetbrains","company", 17));
        jb.add(new ObjectTest("tri","engineer intern",21));
        jb.add(1, new ObjectTest("Uliana", "Project Coordinator", 26));
        
        ObjectTest o = (ObjectTest)jb.get(0);
        assertEquals(17,o.age) ;
        o = (ObjectTest)jb.get(1);
        assertEquals(26,o.age) ;
        
        //remove
        jb.remove(1);
        jb.add(new ObjectTest("tri", "engineer", 21));
        o = (ObjectTest)jb.get(1);
        assertEquals("Uliana",o.name) ;
        o = (ObjectTest)jb.get(2);
        assertEquals("engineer",o.position) ;
        
        //set
        jb.set(2, new ObjectTest("tri", "engineer", 22));
        o = (ObjectTest)jb.get(2);
        assertEquals(2,o.age) ;
    }
}
