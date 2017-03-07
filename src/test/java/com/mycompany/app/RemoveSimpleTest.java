package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveSimpleTest {

    public RemoveSimpleTest() {
    }

    @Test
    public void test() {
        JBStruct jb = new JBStruct();

        jb.add(1);
        jb.add(2);
        jb.add(3);
        jb.add(4);
        jb.remove(2);
        assertEquals(4, jb.get(2));
        jb.remove(0);
        assertEquals(2, jb.get(0));
    }
}
