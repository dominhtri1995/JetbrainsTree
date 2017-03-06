
package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TriDo
 */
public class ExceptionTest {
    
    public ExceptionTest() {
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void Addtest() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1,2);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void Addtest2() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(-1,2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void Removetest() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.remove(2);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void Settest() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.set(2,3);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void Gettest() {
        JBStruct jb = new JBStruct();
        jb.add(5);
        jb.add(1);
        jb.get(2);
    }
}
