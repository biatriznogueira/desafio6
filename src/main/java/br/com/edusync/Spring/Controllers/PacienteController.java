package br.com.edusync.Spring.Controllers;
import br.com.edusync.Spring.Models.Paciente;
import br.com.edusync.Spring.Serveces.PacienteServece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "Paciente")
public class PacienteController {
    @Autowired
    private PacienteServece pacienteServece;

    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novoPaciente(@RequestBody Paciente paciente){
        pacienteServece.adicionar(paciente);
        return new ResponseEntity(paciente, HttpStatus.CREATED);

    }

    //listar
    @GetMapping(value = "/listar")
    public ResponseEntity listarPaciente(){
        return new ResponseEntity(pacienteServece.listarTodo(), HttpStatus.OK);
    }

    //deletar
    @DeleteMapping(value = "deletar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo){
        pacienteServece.deletar(codigo);
        return new ResponseEntity(HttpStatus.OK);
    }


    //atualizar
    @PutMapping(value = "/atualizar/{registro}")
    public ResponseEntity atualizarClinica(@PathVariable Integer codigo, @RequestBody Paciente paciente){
        pacienteServece.atualizar(codigo);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }

}
