package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.notification;

import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.authorization.AuthorizerService;
import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import javax.management.Notification;

@Service
public class NotificationConsumer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);

    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
                .build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
    public void receiveNotification(Transaction transaction) {
        LOGGER.info("Notifying transaction: {}", transaction);

        var response = restClient.get().retrieve().toEntity(Notifications.class);

        if (response.getStatusCode().isError() || !response.getBody().message()){
            throw new NoticationException("Error sending notification");
        }
        LOGGER.info("Notifying has been send: {}...", transaction);

    }
}
