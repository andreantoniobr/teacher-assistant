package view.panel;
import controller.Applicantion;
import view.components.*;
import view.components.TextField;
import view.constants.ViewConstants;
import view.frame.EditarAlunoFrame;
import view.frame.VisualizarNotasPeriodoFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AlunoPainel extends JPanel {
    private JTextField nome;
    private JTextField email;

    private JButton adicionar, excluir, editar, editarNotas, verNotas;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public AlunoPainel() {
        criarInterfaceAluno();
        adicionarListenersBotoes();
    }

    public String getNome() {
        return nome.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    private void criarInterfaceAluno() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new TitledBorder(ViewConstants.ALUNO), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel painelAluno = new JPanel(new GridBagLayout());
        painelAluno.add(new JLabel(ViewConstants.CAMPONOMEDOALUNO), gbc);
        gbc.gridy++;
        painelAluno.add(new JLabel(ViewConstants.CAMPOEMAIL), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelAluno.add((nome = new TextField()), gbc);
        gbc.gridy++;
        painelAluno.add((email = new TextField()), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelAluno.add(adicionar = new AddButton("Adicionar Aluno"), gbc);
        add(painelAluno, BorderLayout.PAGE_START);

        criaTabela();
        preencheTabela();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(GridBagConstraints.HORIZONTAL, 500);
        painelFundo.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(editar = new SaveButtom("Editar Aluno"));
        painelBotoes.add(editarNotas = new SaveButtom("Acompanhar Notas"));
        painelBotoes.add(verNotas = new SaveButtom("Visualizar Notas por Período"));
        painelBotoes.add(excluir = new DeleteButtom("Excluir Aluno"));
        painelFundo.add(painelBotoes, BorderLayout.PAGE_END);
        add(painelFundo, BorderLayout.CENTER);
    }

    private void adicionarListenersBotoes() {
        adicionar.addActionListener(e -> adicionarAluno());
        excluir.addActionListener(e -> excluirAluno());
        editar.addActionListener(e -> editarAluno());
        verNotas.addActionListener(e -> verNotasAluno());
    }

    private void adicionarAluno() {
        try {
            Applicantion.controladorAluno.inserirAluno(getNome(), getEmail());
            atualizaTabela();
        } catch (Exception e){
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void excluirAluno() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                Applicantion.controladorAluno.excluirAluno(id);
                atualizaTabela();
                Mensagem.showMensagem("Aluno: " + nome + " com Id: " + id + " foi excluido com sucesso!");
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarAluno() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                editarAlunoNovoFrame(id);
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarAlunoNovoFrame(int id) {
        try {
            Object[] dadoAluno = Applicantion.controladorAluno.getDadosAlunoPorId(id);
            EditarAlunoFrame editarAlunoFrame = new EditarAlunoFrame(dadoAluno);
            editarAlunoFrame.getSalvar().addActionListener(e -> {
                try {
                    String novoNome = editarAlunoFrame.getNome();
                    String novoEmail = editarAlunoFrame.getEmail();
                    Object item = editarAlunoFrame.getComboBox().getSelectedItem();
                    int idTurma = ((ComboItem)item).getId();
                    Applicantion.controladorAluno.editarAluno(id, novoNome, novoEmail, idTurma);
                    editarAlunoFrame.dispose();
                    atualizaTabela();
                    Mensagem.showMensagem("Aluno: " + novoNome + " com Id: " + id + " foi alterado com sucesso!");
                } catch (Exception ex) {
                    Mensagem.showMensagem(ex.getMessage());
                }
            });
        } catch (Exception ex) {
            Mensagem.showMensagem(ex.getMessage());
        }
    }

    private void verNotasAluno() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                try {
                    VisualizarNotasPeriodoFrame visualizarNotasPeriodoFrame = new VisualizarNotasPeriodoFrame();
                    ArrayList<Object[]> dadosNotas = Applicantion.controladorAluno.getNotasAlunoPorId(id);
                    visualizarNotasPeriodoFrame.atualizaTabela(dadosNotas);
                } catch (Exception ex) {
                    Mensagem.showMensagem(ex.getMessage());
                }
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void criaTabela() {
        String [] colunas = {ViewConstants.ID, ViewConstants.NOME, ViewConstants.EMAIL, "Turma"};
        modelo.setColumnIdentifiers(colunas);
        tabela = new CustomJTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    private void preencheTabela(){
        for (Object[] dadoAluno: Applicantion.controladorAluno.getDadosAlunos()){
            modelo.addRow(dadoAluno);
        }
    }

    private void atualizaTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }
}
