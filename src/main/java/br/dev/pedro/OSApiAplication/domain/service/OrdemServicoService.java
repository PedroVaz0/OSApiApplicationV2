/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.pedro.OSApiAplication.domain.service;

import br.dev.pedro.OSApiAplication.domain.exception.DomainException;
import br.dev.pedro.OSApiAplication.domain.model.Cliente;
import br.dev.pedro.OSApiAplication.domain.model.OrdemServico;
import br.dev.pedro.OSApiAplication.domain.model.StatusOrdemServico;
import br.dev.pedro.OSApiAplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.dev.pedro.OSApiAplication.domain.repository.ClienteRepository;

@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    public OrdemServico criar(OrdemServico ordemServico) 
    {
       ordemServico.setStatus(StatusOrdemServico.ABERTA);
       ordemServico.setDataAbertura(LocalDateTime.now());
       
       return ordemServicoRepository.save(ordemServico);
    }
    
    public OrdemServico salvar(OrdemServico ordemServico) 
    {
        return ordemServicoRepository.save(ordemServico);
    }
    
}
