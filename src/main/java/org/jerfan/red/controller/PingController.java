package org.jerfan.red.controller;


import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.jerfan.red.vo.TradeOrderBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PingController {


    @Autowired
    private RabbitTemplate template;
    @RequestMapping(value = "/start")
    public String start(){
        return "sky red server start success ... ";

        /*initFlowRules();
        while(true){
            String rs="";
            try{
                rs="server start";
            }catch (Exception e){
                rs="error";
            }
            return rs;
        }*/

    }

    @RequestMapping(value = "msg/send")
    public String sendMsg(){

        TradeOrderBean tradeOrderBean = new TradeOrderBean();
        tradeOrderBean.setTradeNo("201908");
        tradeOrderBean.setOrderNo("0809001");
        tradeOrderBean.setOrderFrom("2");
        try{
            template.convertAndSend("CalonDirectExchange","CalonDirectRouting",tradeOrderBean);
        }catch (Exception e){

            System.out.println(e);
        }
        return "send messages successfully ...";
    }


    private void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
