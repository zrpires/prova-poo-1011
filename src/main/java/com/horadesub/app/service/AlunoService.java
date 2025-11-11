package com.horadesub.app.service;

import com.horadesub.app.model.AlunoModel;
import com.horadesub.app.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel save(AlunoModel aluno){
        return this.alunoRepository.save(aluno);
    }


    public List<AlunoModel> findAll(){
        return this.alunoRepository.findAll();
    }

    public Optional<AlunoModel> findById(Long id){
        return this.alunoRepository.findById(id);
    }

    public Optional<AlunoModel> update(Long id, AlunoModel alunoNovo){
        return this.alunoRepository.findById(id).map(alunoModel -> {
            alunoModel.setNome(alunoNovo.getNome());
            alunoModel.setCurso(alunoNovo.getCurso());
            alunoModel.setMatricula(alunoNovo.getMatricula());
            alunoModel.setStatus(alunoNovo.getStatus());
            return this.alunoRepository.save(alunoModel);
        });

    }

    public Optional<AlunoModel> delete(Long id){
        return this.alunoRepository.findById(id)
                .map(alunoModel -> {
                    this.alunoRepository.deleteById(id);
                    return alunoModel;
                });
    }

}
