package com.mycompany.app;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class SetSimpleTest {
    
    public SetSimpleTest() {
    }
    
   @Test
    public void test(){
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(6);
        jb.add(7);
        jb.set(1, 7);
        assertEquals(7, jb.get(1));
    }
    
}
