package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.authorization;

import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder restClientBuilder) {
       this.restClient = restClientBuilder
               .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
               .build();
    }
    public void authorize(Transaction transaction) {
        LOGGER.info("Authorizing transaction: {}", transaction);
          var response =  restClient.get().retrieve().toEntity(Authorization.class);

          if (response.getStatusCode().isError() || !response.getBody().isAuthorized()){
              throw new UnauthorizedExeception("Unauthorized");
          }
        LOGGER.info("Transaction authorizing: {}", transaction);
    }
}
