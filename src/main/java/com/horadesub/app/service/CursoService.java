package com.horadesub.app.service;


import com.horadesub.app.model.AlunoModel;
import com.horadesub.app.model.CursoModel;
import com.horadesub.app.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoModel save(CursoModel curso){
        return this.cursoRepository.save(curso);
    }

    public void add(Long id, AlunoModel a){
        CursoModel c = this.cursoRepository.findById(id).get();
        c.addAluno(a);
        this.cursoRepository.save(c);
    }

    public List<CursoModel> findAll(){
        return this.cursoRepository.findAll();
    }

    public Optional<CursoModel> findById(Long id){
        return this.cursoRepository.findById(id);
    }

    public Optional<CursoModel> update(Long id, CursoModel cursoNovo){
        return this.cursoRepository.findById(id)
                .map(cursoModel -> {
                    cursoModel.setNome(cursoNovo.getNome());
                    cursoModel.setCargaHoraria(cursoNovo.getCargaHoraria());
                    cursoModel.setAlunos(cursoNovo.getAlunos());
                    return this.save(cursoModel);
                });
    }

    public Optional<CursoModel> delete(Long id){
        return this.cursoRepository.findById(id)
                .map(self -> {
                    this.cursoRepository.deleteById(id);
                    return self;
                });
    }


}
