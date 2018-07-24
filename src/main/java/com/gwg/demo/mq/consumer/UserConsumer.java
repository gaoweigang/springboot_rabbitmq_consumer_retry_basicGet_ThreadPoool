package com.gwg.demo.mq.consumer;

import java.io.IOException;

import com.gwg.demo.mq.common.ThreadPoolConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gwg.demo.mq.common.MessageConsumer;

/**
 * 在满足一定条件的 情况下 才会去拉去数据，我们常用的是推模式
 */
@Component
public class UserConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

	@Autowired
	private MessageConsumer messageConsumer;

	@Autowired
	private ThreadPoolConsumer<?> threadPoolConsumer;
	 
	/**
	 * 这个使用的消息队列监听器，需要队列提前创建好，否则会报错
	 */
	/*public void consume() throws IOException {
		logger.info("尝试从队列获取50条消息 start .....");
		for(int i = 0; i < 50; i++){
			messageConsumer.consume();
		}

	}*/
	public void consume() throws IOException {
    	logger.info("采用线程池消费：{}", threadPoolConsumer);
		threadPoolConsumer.start();
	}
 
}
