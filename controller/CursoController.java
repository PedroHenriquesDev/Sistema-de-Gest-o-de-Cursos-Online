package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private List<Curso> cursos;

    public CursoController() {
        this.cursos = new ArrayList<>();
    }

    public void cadastrarCurso(String nome, String descricao, int cargaHoraria, Instrutor instrutor) 
            throws CampoObrigatorioException {
        if (nome == null || nome.isEmpty()) {
            throw new CampoObrigatorioException("O nome do curso é obrigatório");
        }
        if (instrutor == null) {
            throw new CampoObrigatorioException("O instrutor do curso é obrigatório");
        }
        
        Curso novoCurso = new Curso(nome, descricao, cargaHoraria, instrutor);
        cursos.add(novoCurso);
    }

    public void adicionarAulaAoCurso(String nomeCurso, String nomeAula, String descricaoAula, int duracaoAula) 
            throws CursoNaoEncontradoException, CampoObrigatorioException {
        if (nomeAula == null || nomeAula.isEmpty()) {
            throw new CampoObrigatorioException("O nome da aula é obrigatório");
        }
        
        Curso curso = buscarCursoPorNome(nomeCurso);
        Aula novaAula = new Aula(nomeAula, descricaoAula, duracaoAula);
        curso.adicionarAula(novaAula);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorNome(String nome) throws CursoNaoEncontradoException {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        throw new CursoNaoEncontradoException("Curso não encontrado: " + nome);
    }

    public void removerCurso(String nome) throws CursoNaoEncontradoException {
        Curso curso = buscarCursoPorNome(nome);
        cursos.remove(curso);
    }
}
