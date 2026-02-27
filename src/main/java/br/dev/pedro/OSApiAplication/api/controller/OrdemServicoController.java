/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.pedro.OSApiAplication.api.controller;

import br.dev.pedro.OSApiAplication.domain.model.OrdemServico;
import br.dev.pedro.OSApiAplication.domain.repository.OrdemServicoRepository;
import br.dev.pedro.OSApiAplication.domain.service.OrdemServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        
        
        @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID) {
        
        
        if (!clienteRepository.existsById(clienteID)) {
            
            return ResponseEntity.notFound().build();
        }
        
        
        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
    }
    
}
