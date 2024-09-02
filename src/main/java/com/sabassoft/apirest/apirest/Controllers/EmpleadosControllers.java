package com.sabassoft.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabassoft.apirest.apirest.Entities.Empleados;
import com.sabassoft.apirest.apirest.Repositories.EmpleadosRepository;

@RestController
@RequestMapping("/api/clientes")
public class EmpleadosControllers {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    //traer todos los empleados
    @GetMapping
    public List<Empleados> getAllEmpleados(){
        return empleadosRepository.findAll();
    }

    //traer empleados por id
    @GetMapping("/{id}")
    public Empleados getEmpleadosById(@PathVariable long id){
        return empleadosRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
    }

    //crear empleado
    @PostMapping
    public Empleados createEmpleado(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }

    //actualizar un empleado
    @PutMapping("/{id}")
    public Empleados updateEmpleado(@PathVariable long id, @RequestBody Empleados updateEmpleado){
        Empleados empleados = empleadosRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
        empleados.setNombre(updateEmpleado.getNombre());
        empleados.setApellido(updateEmpleado.getApellido());
        empleados.setPuesto(updateEmpleado.getPuesto());
        empleados.setUsuario(updateEmpleado.getUsuario());
        empleados.setPassword(updateEmpleado.getPassword());
        return empleadosRepository.save(empleados);
    }

    //eliminar empleados
    @DeleteMapping("/{id}")
    public String deleteEmpleado(@PathVariable long id){
        Empleados empleado = empleadosRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
        empleadosRepository.delete(empleado);
        return "El empleado con el id " + id + "ha sido eliminado correctamente";
    }
}
