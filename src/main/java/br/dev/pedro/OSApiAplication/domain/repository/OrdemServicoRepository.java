/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.pedro.OSApiAplication.domain.repository;

import br.dev.pedro.OSApiAplication.domain.model.OrdemServico;
import br.dev.pedro.OSApiAplication.domain.model.StatusOrdemServico;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesi3dib
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
    List<OrdemServico> findByDataAbertura(LocalDateTime dataAbertura);
    List<OrdemServico> findByDataFinalizacao(LocalDateTime dataFinalizacao);
    List<OrdemServico> findByStatus (StatusOrdemServico status);
 }
