package com.horadesub.app.Controller;

import com.horadesub.app.model.CursoModel;
import com.horadesub.app.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoModel> save(@RequestBody CursoModel cursoModel){
        CursoModel response = this.cursoService.save(cursoModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CursoModel>> findAll(){
        List<CursoModel> response = this.cursoService.findAll();
        if(!response.isEmpty()){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoModel> findById(@PathVariable("id") Long id){
        return this.cursoService.findById(id)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<CursoModel> update(@PathVariable("id") Long id, @RequestBody CursoModel cursoModel){
        return this.cursoService.update(id, cursoModel)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CursoModel> delete(@PathVariable("id") Long id){
        return this.cursoService.delete(id)
                .map(self -> ResponseEntity.ok(self))
                .orElse(ResponseEntity.notFound().build());
    }


}
