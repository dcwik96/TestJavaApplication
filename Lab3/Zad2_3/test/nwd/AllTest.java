package nwd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testNWDCorrect.class, testNWDExceptions.class })
public class AllTest {
  
}
