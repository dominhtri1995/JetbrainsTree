package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class AddIndexIntensive2Test {
    
    public AddIndexIntensive2Test() {
    }
     @Test
    public void test() {
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(0.5);
        for (int i = 1; i <=10; i++) {
            jb.add(1, i);
        }
        //test with multiple positions
        for (int i =1;i<=10;i++){
            jb.add(i,90+i);
        }
        for(int i =1;i<=10;i++){
            assertEquals(90+i, jb.get(i));
        }
    }
}
