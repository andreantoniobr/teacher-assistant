package view.panel;

import controller.Applicantion;
import view.Mensagem;
import view.constant.ViewConstants;
import view.frame.EditarMetodologiaNotaFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MetodologiaNotaPainel extends JPanel {
    private JTextField nome;

    private JButton adicionar;
    private JButton excluir;
    private JButton editar;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public MetodologiaNotaPainel() {
        criarInterfaceMetodologia();
        adicionarListenersBotoes();
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    private void criarInterfaceMetodologia() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new TitledBorder("Metodologia de Nota"), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel painelMetodologia = new JPanel(new GridBagLayout());
        painelMetodologia.add(new JLabel("Nome da Metodologia: "), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelMetodologia.add((nome = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelMetodologia.add(adicionar = new JButton(ViewConstants.ADICIONAR), gbc);
        add(painelMetodologia, BorderLayout.PAGE_START);

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
        adicionar.addActionListener(e -> adicionarMetodologia());
        excluir.addActionListener(e -> excluirMetodologia());
        editar.addActionListener(e -> editarMetodologia());
    }

    private void adicionarMetodologia() {
        try {
            Applicantion.controlladorMetodologiaNota.inserirMetodologia(getNome());
            atualizaTabela();
        } catch (Exception e){
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void excluirMetodologia() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                Applicantion.controlladorMetodologiaNota.excluirMedotologia(id);
                atualizaTabela();
                Mensagem.showMensagem("Metodologia: " + nome + " com Id: " + id + " foi excluida com sucesso!");
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarMetodologia() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                editaMetodologiaNovoFrame(nome, id);
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editaMetodologiaNovoFrame(String nome, int id) {
        EditarMetodologiaNotaFrame editarMetodologiaNotaFrame = new EditarMetodologiaNotaFrame(nome);
        editarMetodologiaNotaFrame.getSalvar().addActionListener(e -> {
            try {
                String novoNome = editarMetodologiaNotaFrame.getNome();
                Applicantion.controlladorMetodologiaNota.editarMetodologia(id, novoNome);
                editarMetodologiaNotaFrame.dispose();
                atualizaTabela();
                Mensagem.showMensagem("Metodologia: " + novoNome + " com Id: " + id + " foi alterada com sucesso!");
            } catch (Exception ex) {
                Mensagem.showMensagem(ex.getMessage());
            }
        });
    }

    private void criaTabela() {
        String [] colunas = {ViewConstants.ID, ViewConstants.NOME};
        modelo.setColumnIdentifiers(colunas);
        tabela = new JTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
    }

    private void preencheTabela(){
        for (Object[] dadoMetodologia: Applicantion.controlladorMetodologiaNota.getDadosMetodologias()){
            modelo.addRow(dadoMetodologia);
        }
    }

    private void atualizaTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }
}
