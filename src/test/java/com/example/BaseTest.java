package com.example;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    protected static String EMPTY_STRING = "";

    @BeforeClass
    @Override
    public void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

}
