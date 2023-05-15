package br.com.edusync.Spring.Controllers;
import br.com.edusync.Spring.Models.Clinica;
import br.com.edusync.Spring.Serveces.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novaClinica(@RequestBody Clinica clinica){
        clinicaService.adicionar(clinica);
        return new ResponseEntity(clinica, HttpStatus.CREATED);
    }

    //listar
    @GetMapping(value = "/listar")
    public ResponseEntity listarClinicas(){
        return new ResponseEntity(clinicaService.listarTodos(), HttpStatus.OK);
        }

        //deletar
    @DeleteMapping(value = "deletar/{CNPJ}")
    public ResponseEntity deletar(@PathVariable Integer CNPJ){
        clinicaService.deletar(CNPJ);
        return new ResponseEntity(HttpStatus.OK);
    }


    //atualizar
    @PutMapping(value = "/atualizar/{CRN}")
    public ResponseEntity atualizarClinica(@PathVariable Integer CNPJ, @RequestBody Clinica clinica){
        clinicaService.atualizar(CNPJ);
        return new ResponseEntity(CNPJ, HttpStatus.OK);
    }
}
