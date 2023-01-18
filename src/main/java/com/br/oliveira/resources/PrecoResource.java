package com.br.oliveira.resources;

import com.br.oliveira.constantes.RabbitMQConstantes;
import com.br.oliveira.dto.PrecoDto;
import com.br.oliveira.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "preco")
public class PrecoResource {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity alteraPreco(@RequestBody PrecoDto precoDto) {
        this.rabbitmqService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
