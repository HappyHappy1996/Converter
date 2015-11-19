package ua.nagib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nagib.GUI.ConvertFrameTest;
import ua.nagib.GUI.EditFrameTest;
import ua.nagib.GUI.LoginFrameTest;
import ua.nagib.calc.CalculatorTest;
import ua.nagib.cryptographic.CryptographerTest;
import ua.nagib.data.CurrencyTest;

@RunWith(Suite.class)
@SuiteClasses({ LauncherTest.class, CurrencyTest.class, LoginFrameTest.class, EditFrameTest.class, ConvertFrameTest.class, CryptographerTest.class, CalculatorTest.class })
public class AllTests {

}
