package view.panel;
import controller.Applicantion;
import view.components.*;
import view.components.TextField;
import view.constants.ViewConstants;
import view.frame.EditarTurmaFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TurmaPainel extends JPanel {
    private JTextField nome;

    private JButton adicionar;
    private JButton excluir;
    private JButton editar;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public TurmaPainel() {
        criarInterfaceTurma();
        adicionarListenersBotoes();
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    private void criarInterfaceTurma() {
        setLayout(new BorderLayout());
        setBorder(new TextBubbleBorder(new Color(200, 200, 200),1,10,0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel painelTurma = new JPanel(new GridBagLayout());
        painelTurma.add(new JLabel(ViewConstants.CAMPONOMEDATURMA), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelTurma.add((nome = new TextField()), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelTurma.add(adicionar = new AddButton("Adicionar Turma"), gbc);
        add(painelTurma, BorderLayout.PAGE_START);

        criaTabela();
        preencheTabela();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(GridBagConstraints.HORIZONTAL, 500);
        painelFundo.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(editar = new SaveButtom("Editar Turma"));
        painelBotoes.add(excluir = new DeleteButtom("Excluir Turma"));
        painelFundo.add(painelBotoes, BorderLayout.PAGE_END);
        add(painelFundo, BorderLayout.CENTER);
    }

    private void adicionarListenersBotoes() {
        adicionar.addActionListener(e -> adicionarTurma());
        excluir.addActionListener(e -> excluirTurma());
        editar.addActionListener(e -> editarTurma());
    }

    private void adicionarTurma() {
        try {
            Applicantion.controladorTurma.inserirTurma(getNome());
            atualizaTabela();
        } catch (Exception e){
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void excluirTurma() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                Applicantion.controladorTurma.excluirTurma(id);
                atualizaTabela();
                Mensagem.showMensagem("Turma: " + nome + " com Id: " + id + " foi excluida com sucesso!");
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarTurma() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                editarTurmaNovoFrame(id, nome);
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarTurmaNovoFrame(int id, String nome) {
        EditarTurmaFrame editarTurmaFrame = new EditarTurmaFrame(nome);
        editarTurmaFrame.getSalvar().addActionListener(e -> {
            try {
                String novoNome = editarTurmaFrame.getNome();
                Applicantion.controladorTurma.editarTurma(id, novoNome);
                editarTurmaFrame.dispose();
                atualizaTabela();
                Mensagem.showMensagem("Turma: " + novoNome + " com Id: " + id + " foi alterada com sucesso!");
            } catch (Exception ex) {
                Mensagem.showMensagem(ex.getMessage());
            }
        });
    }

    private void criaTabela() {
        String [] colunas = {ViewConstants.ID, ViewConstants.NOME};
        modelo.setColumnIdentifiers(colunas);
        tabela = new CustomJTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
    }

    private void preencheTabela(){
        for (Object[] dadoTurma: Applicantion.controladorTurma.getDadosTurmas()){
            modelo.addRow(dadoTurma);
        }
    }

    private void atualizaTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }
}
