package com.gwg.demo.mq.consumer.message.process;


import com.gwg.demo.mq.common.DetailRes;

public interface MessageProcess<T> {
	
    public DetailRes process(T messageBean);
}

