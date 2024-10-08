package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsService(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void sendMessage(String queueName, Object message) {
        queueMessagingTemplate.convertAndSend(queueName, message);
    }
}
