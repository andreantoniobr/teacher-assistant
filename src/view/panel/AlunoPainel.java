package view.panel;
import model.Aluno;
import controller.Applicantion;
import view.Mensagem;
import view.constant.ViewConstants;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AlunoPainel extends JPanel {
    private JTextField nome;
    private JTextField email;

    private JButton adicionar;
    private JButton excluir;
    private JButton editar;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public AlunoPainel() {
        criarInterfaceAluno();
        adicionarListenersBotoes();
    }

    private void criarInterfaceAluno() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new TitledBorder(ViewConstants.ALUNO), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel painelAluno = new JPanel(new GridBagLayout());
        painelAluno.add(new JLabel(ViewConstants.CAMPONOMEDOALUNO), gbc);
        gbc.gridy++;
        painelAluno.add(new JLabel(ViewConstants.CAMPOEMAIL), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelAluno.add((nome = new JTextField(10)), gbc);
        gbc.gridy++;
        painelAluno.add((email = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelAluno.add(adicionar = new JButton(ViewConstants.ADICIONAR), gbc);
        add(painelAluno, BorderLayout.PAGE_START);

        criaTabela();
        preencheTabela();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(GridBagConstraints.HORIZONTAL, 500);
        painelFundo.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(editar = new JButton(ViewConstants.EDITAR));
        painelBotoes.add(excluir = new JButton(ViewConstants.EXCLUIR));
        painelFundo.add(painelBotoes, BorderLayout.PAGE_END);
        add(painelFundo, BorderLayout.CENTER);
    }

    private void adicionarListenersBotoes() {
        adicionar.addActionListener(e -> adicionarAluno());
        excluir.addActionListener(e -> excluirAluno());
        editar.addActionListener(e -> editarAluno());
    }

    private void adicionarAluno() {

        if(getNome() == null || getNome().isEmpty() ){
            Mensagem.showMensagem("Campo \"Nome do Aluno\" é obrigatorio o preenchimento!");
        } else {
            //Todo: remover model da interface
            Aluno aluno = new Aluno(getNome(), getEmail());
            Applicantion.ControladorAluno.inserirAluno(aluno);
            inserirDadosAlunoTabela(aluno);
        }
    }

    private void excluirAluno() {
        int linha = -1;
        linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
            String nome = tabela.getValueAt(linha, 1).toString();
            if(Applicantion.ControladorAluno.excluirAluno(id)){
                updateTabela();
                Mensagem.showMensagem("Aluno: " + nome + " com Id: " + id + " foi excluido com sucesso!");
            }
        } else {
            Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
        }
    }

    private void editarAluno() {
        int linha = -1;
        linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
            String nome = tabela.getValueAt(linha, 1).toString();
            String email = tabela.getValueAt(linha, 2).toString();
            if(Applicantion.ControladorAluno.editarAluno(id, nome, email)){
                updateTabela();
                Mensagem.showMensagem("Aluno: " + nome + " com Id: " + id + " foi alterado com sucesso!");
            }
        } else {
            Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
        }
    }

    private void criaTabela() {
        String [] colunas = {ViewConstants.ID, ViewConstants.NOME, ViewConstants.EMAIL};
        modelo.setColumnIdentifiers(colunas);
        tabela = new JTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
    }

    private void preencheTabela(){
        //Todo:remover Model da view
        for (Aluno aluno: Applicantion.ControladorAluno.getAlunos()){
            inserirDadosAlunoTabela(aluno);
        }
    }

    private void updateTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }

    private void inserirLinhaTabela(String id, String nome, String email){
        modelo.addRow(new Object[] {id, nome, email});
    }

    private void inserirDadosAlunoTabela(Aluno aluno){
        inserirLinhaTabela(Integer.toString(aluno.getId()), aluno.getNome(), aluno.getEmail());
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String email) {
        this.nome.setText(email);
    }
}
