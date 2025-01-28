package com.espe.orquestador.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.resolve(response.status());

        if (status == HttpStatus.NOT_FOUND) {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "El recurso solicitado no fue encontrado.");
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
            return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servicio remoto: " + methodKey);
        } else {
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Error desconocido en la comunicación con el servicio remoto.");
        }
    }
}
