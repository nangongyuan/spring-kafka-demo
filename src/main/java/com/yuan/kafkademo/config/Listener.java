/**
 * Copyright (C), 2015-2018, 虹软
 * FileName: Listener
 * Author:   yuan
 * Date:     2018/12/14 16:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yuan           修改时间           版本号              描述
 */
package com.yuan.kafkademo.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ly6333
 * @create 2018/12/14
 * @since 1.0.0
 */
public class Listener {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
    }

}