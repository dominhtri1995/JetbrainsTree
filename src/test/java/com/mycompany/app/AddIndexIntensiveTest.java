package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class AddIndexIntensiveTest {
    
    public AddIndexIntensiveTest() {
    }
    
    @Test
    public void test() {
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(0.5);
        //intensive add to 1 position to see how the tree handle and reindex
        for (int i = 100000; i >= 1; i--) {
            jb.add(1, i);
        }
        for (int i = 1; i <= 100000; i++) {
            assertEquals(i, jb.get(i));
        }
        assertEquals(0.5, jb.get(100001));
    }
    @Test
    public void test1() {
        JBStruct jb = new JBStruct();
        jb.add(0);

        //intensive add to the back
        for (int i = 1; i <= 10000; i++) {
            jb.add(i);
        }
        
        for (int i = 1; i <= 10000; i++) {
            assertEquals(i, jb.get(i));
        }
        assertEquals(0.5, jb.get(10001));
    }

    @Test
    public void test2() {
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(0.5);
        for (int i = 1; i <= 10; i++) {
            jb.add(1, i);
        }
        //test with multiple positions
        for (int i = 1; i <= 10; i++) {
            jb.add(i, 90 + i);
        }
        for (int i = 1; i <= 10; i++) {
            assertEquals(90 + i, jb.get(i));
        }
    }

    @Test
    public void addfronttest() {
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(0.5);

        //intensive add front
        for (int i = 10000; i >= 1; i--) {
            jb.add(0, i);
        }

        for (int i = 0; i < 10000; i++) {
            assertEquals(i+1, jb.get(i));
        }
        assertEquals(0.5, jb.get(10001));
    }
}
