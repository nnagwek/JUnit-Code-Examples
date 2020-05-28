package com.JUnitCodeExamples.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArraysTest.class, QuickBeforeAfterTest.class })
public class AllTests {

}
