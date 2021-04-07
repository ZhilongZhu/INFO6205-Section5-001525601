package edu.neu.coe.info6205.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** 
* RedBlackTree Tester. 
* 
* @author zhilong zhu
* @since Apri 4, 2021
* @version 1.0 
*/ 
public class RedBlackTreeTest { 

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: size()
* this method also cloud test (Method: put)
*/
@Test
public void testSize() throws Exception {
//TODO: Test goes here...
    RedBlackTree rbt = new RedBlackTree();
    int n = 1000;
    for (int i = 0; i < n; i++) {
        rbt.put(i, i);
    }
    assertEquals(1000, rbt.size());
}

/**
*
* Method: get(int key)
* this method also cloud test (Method: put)
*/
@Test
public void testGet() throws Exception {
//TODO: Test goes here...
    RedBlackTree rbt = new RedBlackTree();
    int n = 100;
    for (int i = 0; i < n; i++) {
        rbt.put(i, i);
    }
    assertEquals((Integer)55, rbt.get(55)); // if the tree contains this key
    assertEquals(null, rbt.get(101)); // if the tree does not contain this key

}

/**
 *
 * Method: noRedLinks()
 * this method also cloud test (Method: put)
 */
    @Test
    public void testRedLinks() throws Exception {
        RedBlackTree rbt = new RedBlackTree();
        int n = 255;
        for (int i = 0; i < n; i++) {
            rbt.put(i, i);
        }
        assertEquals(true, rbt.noRedLinks());
    }

 // Testing the construction functions of this class
@Test
    public void testConsturctionFunctions() throws Exception {
        RedBlackTree rbt = new RedBlackTree();
        rbt.put(6,6);
        rbt.put(7,7);
        rbt.put(1,1);
        rbt.put(5,5);
        rbt.put(3,3);
        rbt.put(4,4);
        rbt.put(2,2);

        // Compare the val and color of each node
        assertEquals((Integer)6, rbt.root.val);
        assertEquals(false, rbt.root.color);

        assertEquals((Integer)3, rbt.root.left.val);
        assertEquals(true, rbt.root.left.color);

        assertEquals((Integer)2, rbt.root.left.left.val);
        assertEquals(false, rbt.root.left.left.color);

        assertEquals((Integer)1, rbt.root.left.left.left.val);
        assertEquals(true, rbt.root.left.left.left.color);

        assertEquals((Integer)5, rbt.root.left.right.val);
        assertEquals(false, rbt.root.left.right.color);

        assertEquals((Integer)4, rbt.root.left.right.left.val);
        assertEquals(true, rbt.root.left.right.left.color);

        assertEquals((Integer)7, rbt.root.right.val);
        assertEquals(false, rbt.root.right.color);
    }

}
