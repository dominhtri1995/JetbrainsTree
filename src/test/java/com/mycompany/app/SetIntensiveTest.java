package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class SetIntensiveTest {
    
    public SetIntensiveTest() {
    }
    
   @Test
    public void test(){
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(1000);
        for (int i = 1; i <= 10; i++) {
            jb.add(1, i);
        }
        for (int i = 1; i <= 10; i++) {
            jb.set(i, i*10);
        }
        for (int i = 1; i <= 10; i++) {
            assertEquals(i*10,jb.get(i));
        }
        
        assertEquals(1000,jb.get(11));
        
    }
}
