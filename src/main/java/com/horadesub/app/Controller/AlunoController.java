package com.horadesub.app.Controller;

import com.horadesub.app.model.AlunoModel;
import com.horadesub.app.model.CursoModel;
import com.horadesub.app.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @PostMapping
    public ResponseEntity<AlunoModel> save(@RequestBody AlunoModel alunoModel){
        AlunoModel response = this.alunoService.save(alunoModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> findAll(){
        List<AlunoModel> response = this.alunoService.findAll();
        if(!response.isEmpty()){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> findById(@PathVariable("id") Long id){
        return this.alunoService.findById(id)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> update(@PathVariable("id") Long id, @RequestBody AlunoModel alunoModel){
        return this.alunoService.update(id, alunoModel)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoModel> delete(@PathVariable("id") Long id){
        return this.alunoService.delete(id)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }


}
