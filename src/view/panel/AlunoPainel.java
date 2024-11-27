package view.panel;
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
        try {
            Applicantion.ControladorAluno.inserirAluno(getNome(), getEmail());
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
                Applicantion.ControladorAluno.excluirAluno(id);
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
                String nome = tabela.getValueAt(linha, 1).toString();
                String email = tabela.getValueAt(linha, 2).toString();
                Applicantion.ControladorAluno.editarAluno(id, nome, email);
                atualizaTabela();
                Mensagem.showMensagem("Aluno: " + nome + " com Id: " + id + " foi alterado com sucesso!");
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
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
        for (Object[] dadoAluno: Applicantion.ControladorAluno.getDadosAlunos()){
            modelo.addRow(dadoAluno);
        }
    }

    private void atualizaTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }
}
