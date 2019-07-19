package com.mx;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    App app = new App();
    @org.junit.jupiter.api.Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSum()
    {
//        Assert.assertTrue(app.sum(1, 2));
        Assert.assertEquals(app.sum(1, 2), 3);
    }
}
