package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.notification;

import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction.Transaction;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public void notify(Transaction transaction){
        notificationProducer.sendNotification(transaction);
    }
}
