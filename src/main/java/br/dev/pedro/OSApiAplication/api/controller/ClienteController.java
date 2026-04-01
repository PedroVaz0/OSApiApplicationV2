/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.pedro.OSApiAplication.api.controller;

import br.dev.pedro.OSApiAplication.domain.model.Cliente;
import br.dev.pedro.OSApiAplication.domain.repository.ClienteRepository;
import br.dev.pedro.OSApiAplication.domain.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DIT2B
 */
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    
    @Operation(summary = "Buscar todos os clientes por id", description = "Retorna os clinetes")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso na busca"),
    @ApiResponse(responseCode = "404", description = "Nada encontrado")
 })
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        return clienteRepository.findAll();
        //return clienteRepository.findByNome("KGe");
    }
    
    @Operation(summary = "Buscar cliente por id", description = "Retorna o clinete com o id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso na busca"),
    @ApiResponse(responseCode = "404", description = "Nada encontrado - O clinete nao foi encontrado")
 })
    
    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
        
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //metodo post
    
    
    @Operation(summary = "Adicionar informacao", description = "Adiciona um clinete ao banco de dados")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
    @ApiResponse(responseCode = "404", description = "Nao foi possivel adicionar o cliente")
 })
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar (@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }
    
    
    //metodo put
    
    @Operation(summary = "Substituir informacao ja existente", description = "Atualiza alguma informacao ja colocada no banco de dados")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
    @ApiResponse(responseCode = "404", description = "Nao foi possivel adicionar o cliente")
 })
    
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
                                             @RequestBody Cliente cliente) {
        
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(clienteID);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }
    
    
    
    @Operation(summary = "Deletar cliente", description = "Deleta um cliente do banco de dados ")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso na acao"),
    @ApiResponse(responseCode = "404", description = "O clinete nao foi excluido")
 })
    
    
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID) {
        
        
        if (!clienteRepository.existsById(clienteID)) {
            
            return ResponseEntity.notFound().build();
        }
        
        
        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
    }
}
