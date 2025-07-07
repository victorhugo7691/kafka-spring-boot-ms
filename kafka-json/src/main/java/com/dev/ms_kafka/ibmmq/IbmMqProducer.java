package com.dev.ms_kafka.ibmmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableJms
public class IbmMqProducer {

    private JmsTemplate jmsTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(IbmMqProducer.class);

    public IbmMqProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToIbmMq(String mensagem) {
        try {
            jmsTemplate.convertAndSend("DEV.QUEUE.1", mensagem);
            LOGGER.info("A mensagem foi enviada com sucesso " + mensagem);
        } catch (JmsException e) {
            e.printStackTrace();
            LOGGER.error("Falha no envio da mensagem " + mensagem, e);
            throw new RuntimeException("Falha no envio para a fila MQ");
        }
    }
}
