package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionTest {

    public ExceptionTest() {
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void struct_addOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void negative_addOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(-1, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void struct_removeOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.remove(2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void emptySet_removeOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void struct_setOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.set(2, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void struct_getOutBoundIndex_raiseException() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.get(2);
    }
}
