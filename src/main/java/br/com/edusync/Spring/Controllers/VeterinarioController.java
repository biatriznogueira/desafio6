package br.com.edusync.Spring.Controllers;
import br.com.edusync.Spring.Models.Veterinario;
import br.com.edusync.Spring.Serveces.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novoVeterinario(@RequestBody Veterinario veterinario){
        veterinarioService.adicionar(veterinario);
        return new ResponseEntity(veterinario, HttpStatus.CREATED);
    }

    //listar
    @GetMapping(value = "/listar")
    public ResponseEntity listarVeterinario(){
        return new ResponseEntity(veterinarioService.listarTodos(), HttpStatus.OK);
    }

    //deletar
    @DeleteMapping(value = "/deletar")
    public ResponseEntity deletar(@PathVariable Integer codigo){
        veterinarioService.deletar(codigo);
        return new ResponseEntity(HttpStatus.OK);
    }

    //atualizar
    @PutMapping(value = "atualizar/{codigo}")
    public ResponseEntity atualizarVeterinario(@PathVariable Integer codigo, @RequestBody Veterinario veterinario){
       veterinarioService.atualizar(codigo);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }

}
