package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.model.McDonalds;
import com.tabd.mcdonalds.service.McDonaldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="mcdonalds")
public class McDonaldsController {
    @Autowired
    private McDonaldsService mcDonaldsService;

    @PostMapping(value="/salvar")
    public ResponseEntity<Void> criarPedido(@RequestBody McDonalds mcdonalds) {
        mcDonaldsService.criarPedido(mcdonalds);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/buscar/{id}")
    public ResponseEntity<Optional<McDonalds>> buscarPedidoPorId(@PathVariable("id") Integer id) {
        Optional<McDonalds> mcDonalds = mcDonaldsService.buscarPorPedido(id);
        return ResponseEntity.status(HttpStatus.OK).body(mcDonalds);
    }

    @DeleteMapping(value="/deletar/{id}")
    public ResponseEntity<Void> deletarPedidoPorId(@PathVariable("id") Integer id) {
        mcDonaldsService.deletarPorPedido(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @PutMapping(value="/editar/{id}")
    public ResponseEntity<?> editarPedido(@PathVariable("id") Integer id, @RequestBody McDonalds mcdonalds) {
        this.mcDonaldsService.atualizarPedido(id, mcdonalds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
