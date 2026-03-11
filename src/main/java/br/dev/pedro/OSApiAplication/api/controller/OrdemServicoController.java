/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.pedro.OSApiAplication.api.controller;

import br.dev.pedro.OSApiAplication.domain.model.OrdemServico;
import br.dev.pedro.OSApiAplication.domain.repository.OrdemServicoRepository;
import br.dev.pedro.OSApiAplication.domain.service.OrdemServicoService;
import jakarta.persistence.Id;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dib
 */
@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }
    
    
    @GetMapping("/listar")
    public List<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
        //return ordemServicoRepository.findByPreco
    }
    
    
    @GetMapping ("listar/{id}")
    public ResponseEntity<OrdemServico> buscar(@PathVariable Long id) {
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
        if(ordemServico.isPresent()) {
            return ResponseEntity.ok(ordemServico.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/por-cliente/{clienteID}")
    public ResponseEntity<List<OrdemServico>> listar(@PathVariable Long clienteID) {
        List<OrdemServico> ordensDoUsuario = ordemServicoService.listarPorCliente(clienteID);
        
        if(ordensDoUsuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(ordensDoUsuario);
        }
    }
    
    
    @PutMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Long ordemServicoId,
            @RequestBody OrdemServico ordemServico) {
        
        //Verificador de registro
        if (!ordemServicoRepository.existsById(ordemServicoId)) {
            return ResponseEntity.notFound().build();
        
        } else {
        
        OrdemServico atualizada = ordemServicoService.salvar(ordemServico);
        
        return ResponseEntity.ok(atualizada);
    }
            
    }
        @DeleteMapping("/{ordemServicoId}")
        public ResponseEntity<Void> excluir(@PathVariable Long ordemServicoId) 
        {
            // Caso a ordem de serviço não exista
            if (!ordemServicoRepository.existsById(ordemServicoId)) 
            {
                return ResponseEntity.notFound().build();
            }
            
            ordemServicoService.excluir(ordemServicoId);
            return ResponseEntity.noContent() .build();
        }
}
