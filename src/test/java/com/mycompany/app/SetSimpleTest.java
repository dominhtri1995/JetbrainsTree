package com.mycompany.app;


import com.mycompany.app.JBStruct;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
