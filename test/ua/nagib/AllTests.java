package ua.nagib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nagib.GUI.ConvertFrameTest;
import ua.nagib.GUI.EditFrameTest;
import ua.nagib.data.CurrencyTest;

@RunWith(Suite.class)
@SuiteClasses({ LauncherTest.class, CurrencyTest.class, EditFrameTest.class, ConvertFrameTest.class })
public class AllTests {
	
	

}
