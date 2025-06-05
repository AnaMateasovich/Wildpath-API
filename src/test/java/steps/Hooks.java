package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        Fixtures.setUpClass();
    }
/*
   @After
    public void tearDown() {
        Fixtures.tearDownClass();
    }*/
}
