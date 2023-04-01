package com.tabd.mcdonalds.service;

import com.tabd.mcdonalds.model.McDonalds;
import com.tabd.mcdonalds.repository.McDonaldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class McDonaldsService {
    private McDonaldsRepository mcDonaldsRepository;

    public McDonaldsService(McDonaldsRepository mcDonaldsRepository){
        this.mcDonaldsRepository = mcDonaldsRepository;
    }


    public void criarPedido(McDonalds mcDonalds) {
        mcDonaldsRepository.save(mcDonalds);
    }

    public Optional<McDonalds> buscarPorPedido(Integer id) {
        return mcDonaldsRepository.findById(id);
    }

    public void deletarPorPedido(Integer id) {
        mcDonaldsRepository.deleteById(id);
    }

    public void atualizarPedido(Integer id, McDonalds mcdonaldsNovoPedido) {
        Optional<McDonalds> mcdonaldsPedidoAntigo = mcDonaldsRepository.findById(id);
        mcdonaldsNovoPedido.setNumeroPedido(mcdonaldsPedidoAntigo.get().getNumeroPedido());
        this.mcDonaldsRepository.save(mcdonaldsNovoPedido);
    }

}
