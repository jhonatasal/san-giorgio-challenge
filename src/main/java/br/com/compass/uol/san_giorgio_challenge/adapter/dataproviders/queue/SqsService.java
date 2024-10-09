package br.com.compass.uol.san_giorgio_challenge.adapter.dataproviders.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public void sendMessage(String queueName, Object message) {
        queueMessagingTemplate.convertAndSend(queueName, message);
    }
}
