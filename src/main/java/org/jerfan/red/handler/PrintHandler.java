package org.jerfan.red.handler;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class PrintHandler {

    public void printGreetWord(String word) {
        initFlowRules();
        Entry entry = null;
        try {
            entry = SphU.entry("helloSentinel");
            System.out.println("hello " + word);
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
            }
        } catch (BlockException e) {
            System.out.println("block!");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("helloSentinel");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
