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
public class RemoveIntensiveTest {

    public RemoveIntensiveTest() {
    }

    @Test
    public void test() {
        JBStruct jb = new JBStruct();
        jb.add(0);
        jb.add(0.5);
        for (int i = 1; i <= 10; i++) {
            jb.add(1, i);
        }
        for (int i = 10; i >=1; i--) {
            assertEquals(i,jb.get(1));
            jb.remove(1);
        }
    }
}
