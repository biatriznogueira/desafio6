package br.com.edusync.Spring.Controllers;
import br.com.edusync.Spring.Models.Consulta;
import br.com.edusync.Spring.Serveces.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novoConsulta(@RequestBody Consulta consulta){
        consultaService.adicionar(consulta);
        return new ResponseEntity(consulta, HttpStatus.CREATED);

    }
    //listar
    @GetMapping(value = "/listar")
    public ResponseEntity listarConsulta(){
        return new ResponseEntity(consultaService.listarTodo(), HttpStatus.OK);
    }

    @DeleteMapping(value = "deletar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo){
        consultaService.deletar(codigo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "atualizar/{codigo}")
    public ResponseEntity atualizarConsulta(@PathVariable Integer codigo, @RequestBody Consulta consulta){
        consultaService.atualizar(codigo);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }
}
