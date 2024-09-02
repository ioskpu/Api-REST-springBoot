package com.sabassoft.apirest.apirest.Controllers;
import org.springframework.web.bind.annotation.RestController;

import com.sabassoft.apirest.apirest.Entities.Clientes;
import com.sabassoft.apirest.apirest.Repositories.ClientesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/clientes")
    
public class ClientesControllers {

    @Autowired
    private ClientesRepository clientesRepository;

    //traer todos los clientes
    @GetMapping
    public List<Clientes> getAllClientes(){
        return clientesRepository.findAll();
    }

    //treaer cliente por id
    @GetMapping("/{id}")
    public Clientes getClientById(@PathVariable long id){
        return clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado " + id));
    }

    //crear un cliente
    @PostMapping
    public Clientes createCliente(@RequestBody Clientes cliente){
        return clientesRepository.save(cliente);
    }

    //actualizar un cliente
    @PutMapping("/{id}")
    public Clientes updateCliente(@PathVariable long id, @RequestBody Clientes updatedCliente){
        Clientes cliente = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado" + id) );
        cliente.setNombre(updatedCliente.getNombre());
        cliente.setApellido(updatedCliente.getApellido());
        cliente.setIdentificacion(updatedCliente.getIdentificacion());
        cliente.setTelefono(updatedCliente.getTelefono());
        cliente.setEmail(updatedCliente.getEmail());
        return clientesRepository.save(cliente);        
    }

    //eliminar un cliente
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable long id){
        Clientes cliente = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado" + id));
        clientesRepository.delete(cliente);
        return "El cliente con el id " + id + " ha sido eliminado correctamente";
    }
    
}
