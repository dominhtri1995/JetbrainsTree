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
public class RemoveSimpleTest {
    
    public RemoveSimpleTest() {
    }
   @Test
    public void test(){
        JBStruct jb = new JBStruct();
        
        jb.add(1);
        jb.add(2);
        jb.add(3);
        jb.add(4);
        jb.remove(2);
        assertEquals(4, jb.get(2));
    }
}
