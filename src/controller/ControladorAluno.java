package controller;

import model.Aluno;
import model.MetodologiaNota;
import model.Periodo;
import model.Turma;
import model.valuable.IValuable;

import java.util.ArrayList;

public class ControladorAluno {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public ControladorAluno() {
        addStartContent();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Object[]> getDadosAlunos() {
        ArrayList<Object[]> dadosAlunos = new ArrayList<>();
        for (Aluno aluno: alunos){
            String turmaNome = "";
            Turma turma = aluno.getTurma();
            if (turma != null){
                turmaNome = turma.getNome();
            }
            Object[] dadoAluno = {aluno.getId(), aluno.getNome(), aluno.getEmail(), turmaNome};
            dadosAlunos.add(dadoAluno);
        }
        return dadosAlunos;
    }

    public Object[] getDadosAlunoPorId(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        int idTurma = -1;
        if(aluno.getTurma() != null){
            idTurma = aluno.getTurma().getId();
        }
        Object[] dadoAluno = {aluno.getNome(), aluno.getEmail(), idTurma};
        return dadoAluno;
    }

    public ArrayList<Object[]> getNotasAlunoPorId(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        ArrayList<Object[]> notas = new ArrayList<>();
        for (Periodo periodo: aluno.getPeriodos()) {
            for(MetodologiaNota metodologiaNota: periodo.getNotas()){
                Object[] nota = {periodo.getNome() + " " + periodo.getHashCode(), metodologiaNota.getNome() + " " + metodologiaNota.getHashCode(), metodologiaNota.valorTotal()};
                notas.add(nota);
            }
        }
        return notas;
    }

    public ArrayList<Object[]> getMetodosAvaliativosAlunoPorId(int idAluno, int idPeriodo, int idMetodologia, String metodologiaHashCode) throws Exception {
        Periodo periodo = getPeriododoDoAlunoPorId(idAluno, idPeriodo);
        System.out.println("Periodo Clone Pegar dados Pra Edicao: " + periodo.toString());
        MetodologiaNota metodologiaNota = periodo.getMetodologiaPorHashCode(metodologiaHashCode);
        ArrayList<Object[]> metodosAvaliativos = new ArrayList<>();
        if(metodologiaNota != null){
            for (IValuable avaliavel: metodologiaNota.getAvaliaveis()) {
                Object[] metodosAvaliativo = {avaliavel.getId(), avaliavel.getNome(), avaliavel.getValor(), avaliavel.getHashCode()};
                metodosAvaliativos.add(metodosAvaliativo);
            }
        }

        /*
        Aluno aluno = getAlunoPorId(idAluno);
        Periodo periodo = Applicantion.controladorPeriodo.getPeriodoPorId(idPeriodo);
        MetodologiaNota metodologiaNota = Applicantion.controlladorMetodologiaNota.getCloneMetodologiaPorId(idMetodologia);
        ArrayList<Object[]> metodosAvaliativos = new ArrayList<>();
        for (IValuable avaliavel: metodologiaNota.getAvaliaveis()) {
            Object[] metodosAvaliativo = {avaliavel.getId(), avaliavel.getNome(), avaliavel.getValor(), avaliavel.getHashCode()};
            metodosAvaliativos.add(metodosAvaliativo);
        }
        */
        return metodosAvaliativos;
    }

    public Periodo getPeriododoDoAlunoPorId(int idAluno, int idPeriodo) throws Exception {
        Aluno aluno = getAlunoPorId(idAluno);
        Periodo periodo = aluno.getPeriodoPorId(idPeriodo);
        if(periodo == null){
            periodo = Applicantion.controladorPeriodo.getClonePeriodoPorId(idPeriodo);
            aluno.adicionarPeriodo(periodo);
        }
        return periodo;
    }

    public void setMetodosAvaliativosAluno(int idAluno, int idPeriodo, int idMetodologia, String metodologiaHashCode, ArrayList<Object[]> metodosAvaliativos) throws Exception {
        Periodo periodo = getPeriododoDoAlunoPorId(idAluno, idPeriodo);
        System.out.println("Periodo Clone setar Dados: " + periodo.toString());
        MetodologiaNota metodologiaNota = periodo.getMetodologiaPorHashCode(metodologiaHashCode);
        if(metodologiaNota != null){
            for (Object[] metodosAvaliativo: metodosAvaliativos) {
                double valor = Double.parseDouble(metodosAvaliativo[2].toString());
                String metodosAvaliativosHashCode = metodosAvaliativo[3].toString();
                IValuable avaliavel = metodologiaNota.getMetodoAvaliativoPorHashCode(metodosAvaliativosHashCode);
                if(avaliavel != null){
                    avaliavel.setValor(valor);
                }
            }
        }
    }

    public void inserirAluno(String nome, String email) throws Exception {
        validarNomeAluno(nome);
        validarEmail(email);
        Aluno aluno = new Aluno(nome, email);
        inserirAluno(aluno);
        Applicantion.fileIO.salvarAluno(aluno);
    }

    public void inserirAluno(Aluno aluno) throws Exception {
        if(aluno == null){
            throw new Exception("Objeto aluno não existe!");
        }
        alunos.add(aluno);
    }

    public void excluirAluno(int id) throws Exception {
        Aluno aluno = getAlunoPorId(id);
        alunos.remove(aluno);
        Applicantion.fileIO.excluiAluno(aluno);
    }

    public void editarAluno(int id, String nome, String email, int idTurma) throws Exception {
        validarNomeAluno(nome);
        validarEmail(email);
        Aluno aluno = getAlunoPorId(id);
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTurma(Applicantion.controladorTurma.getTurmaPorId(idTurma));
        Applicantion.fileIO.editaAluno(aluno);
    }

    private static void validarNomeAluno(String nome) throws Exception {
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome de aluno não pode ser vazio!");
        }
    }

    private void validarEmail(String email) throws Exception {
        if(email != null && !email.isEmpty() && !email.contains("@")){
            throw new Exception("Email inválido!");
        }
    }

    private Aluno getAlunoPorId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id de aluno inválido!");
        }
        Aluno aluno = null;
        for(Aluno a: alunos){
            if(a.getId() == id){
                aluno = a;
                break;
            }
        }
        if(aluno == null){
            throw new Exception("Aluno não encontrado!");
        }
        return aluno;
    }

    public void addStartContent(){
        try {
            Aluno a1 = new Aluno("Andre Antonio Bezerra");
            Aluno a2 = new Aluno("Paulo Kaike");
            Aluno a3 = new Aluno("Junior Silva");
            inserirAluno(a1);
            inserirAluno(a2);
            inserirAluno(a3);
            this.alunos.addAll(Applicantion.fileIO.getAlunosSalvos());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
