package org.example;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    @Test
    public void log()
    {
        Assert.assertEquals("success",Login.login());
    }
}
