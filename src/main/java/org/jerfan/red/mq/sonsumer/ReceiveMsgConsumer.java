package org.jerfan.red.mq.sonsumer;

import org.jerfan.red.vo.TradeOrderBean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "CalonDirectQueue") //CalonDirectQueue为队列名称
public class ReceiveMsgConsumer {

    @RabbitHandler
    public void process(TradeOrderBean tradeOrderBean) {
        System.out.println("prepare receive message");

        System.out.println("orderNo:"+tradeOrderBean.getOrderNo());
        //System.out.println("DirectReceiver消费者收到消息  : " + tradeOrderBean.getTradeNo()+","+tradeOrderBean.getOrderNo()+","+tradeOrderBean.getOrderFrom());
    }
}
