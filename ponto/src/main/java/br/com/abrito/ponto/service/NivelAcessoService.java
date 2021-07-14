package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.NivelAcesso;
import br.com.abrito.ponto.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    NivelAcessoRepository repository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository repository) {
        this.repository = repository;
    }

    public NivelAcesso save(NivelAcesso entity){
       return repository.save(entity);
    }

    public List<NivelAcesso> findAll() {
       return repository.findAll();
    }

    public Optional<NivelAcesso> getById(Long id) {
        return repository.findById(id);
    }

    public NivelAcesso update(NivelAcesso entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
