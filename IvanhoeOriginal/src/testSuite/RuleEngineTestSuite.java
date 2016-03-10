package testSuite;

import gameRuleEngineTest.GameRuleEngineTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ruleEngine.GameRuleEngine;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GameRuleEngineTest.class})

public class RuleEngineTestSuite {

}
