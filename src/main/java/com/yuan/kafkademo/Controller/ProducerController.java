/**
 * Copyright (C), 2015-2018, 虹软
 * FileName: ProducerController
 * Author:   yuan
 * Date:     2018/12/14 15:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yuan           修改时间           版本号              描述
 */
package com.yuan.kafkademo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ly6333
 * @create 2018/12/14
 * @since 1.0.0
 */
@RestController
@RequestMapping("/kafka")
public class ProducerController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
        try {
            String message = request.getParameter("message");
            logger.info("kafka的消息={}",message);
            kafkaTemplate.send("test", "key", message);
            logger.info("发送kafka成功.");
            return "发送kafka成功";
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }
}