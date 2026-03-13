/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.dev.pedro.OSApiAplication.domain.dto;

import br.dev.pedro.OSApiAplication.domain.model.StatusOrdemServico;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author sesi3dib
 */
public record AtualizarStatusDTO(
        @NotNull(message = "Status é obrigatório")
        StatusOrdemServico status
        ) {

}
