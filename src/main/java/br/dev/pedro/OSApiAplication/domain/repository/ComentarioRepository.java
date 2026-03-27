/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.pedro.OSApiAplication.domain.repository;

import br.dev.pedro.OSApiAplication.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesi3dib
 */
public interface ComentarioRepository  extends JpaRepository<Comentario, Long>{
    
}
