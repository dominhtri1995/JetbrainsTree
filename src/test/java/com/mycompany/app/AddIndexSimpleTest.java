package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class AddIndexSimpleTest {

    public AddIndexSimpleTest() {
    }

    @Test
    public void test() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(6);
        jb.add(1,7);
        jb.add(2,8);
        assertEquals(5, jb.get(0));
        assertEquals(7, jb.get(1));
        assertEquals(6, jb.get(3));
    }
    @Test
    public void test2(){
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(6);
        jb.add(7);
        jb.add(1, 8);
        jb.add(1,9);
        jb.add(1,10);
        jb.add(2,11);
        jb.add(3,12);
//        assertEquals(7, jb.get(1));
    }
}
