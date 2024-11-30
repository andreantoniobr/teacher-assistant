package view.panel;

import controller.Applicantion;
import view.components.*;
import view.components.TextField;
import view.constants.ViewConstants;
import view.frame.EditarMetodologiaNotaFrame;
import view.frame.EditorPeriodoFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PeriodoPainel extends JPanel {
    private JTextField nome;

    private JButton adicionar;
    private JButton excluir;
    private JButton editar;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public PeriodoPainel() {
        criarInterface();
        adicionarListenersBotoes();
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    private void criarInterface() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new TitledBorder("Período"), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel painelPeriodo = new JPanel(new GridBagLayout());
        painelPeriodo.add(new JLabel("Nome do Período: "), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPeriodo.add((nome = new TextField()), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelPeriodo.add(adicionar = new AddButton(ViewConstants.ADICIONAR), gbc);
        add(painelPeriodo, BorderLayout.PAGE_START);

        criaTabela();
        preencheTabela();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(GridBagConstraints.HORIZONTAL, 500);
        painelFundo.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(editar = new SaveButtom(ViewConstants.EDITAR));
        painelBotoes.add(excluir = new DeleteButtom(ViewConstants.EXCLUIR));
        painelFundo.add(painelBotoes, BorderLayout.PAGE_END);
        add(painelFundo, BorderLayout.CENTER);
    }

    private void adicionarListenersBotoes() {
        adicionar.addActionListener(e -> adicionarPeriodo());
        excluir.addActionListener(e -> excluirPeriodo());
        editar.addActionListener(e -> editarPeriodo());
    }

    private void adicionarPeriodo() {
        try {
            Applicantion.controladorPeriodo.inserirPeriodo(getNome());
            atualizaTabela();
        } catch (Exception e){
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void excluirPeriodo() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                Applicantion.controladorPeriodo.excluirPeriodo(id);
                atualizaTabela();
                Mensagem.showMensagem("Período: " + nome + " com Id: " + id + " foi excluido com sucesso!");
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarPeriodo() {
        try
        {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
                String nome = tabela.getValueAt(linha, 1).toString();
                editarPeriodoNovoFrame(id, nome);
            } else {
                Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void editarPeriodoNovoFrame(int id, String nome) {
        try {
            EditorPeriodoFrame editorPeriodoFrame = new EditorPeriodoFrame(nome);
            atualizarMetodologias(id, editorPeriodoFrame);
            adicionarListenerBotaoAdicionar(id, editorPeriodoFrame);
            adicionarListenerBotaoExcluir(id, editorPeriodoFrame);
            adicionarListenerBotaoSalvar(id, editorPeriodoFrame);
        } catch (Exception ex) {
            Mensagem.showMensagem(ex.getMessage());
        }
    }

    private void adicionarListenerBotaoAdicionar(int id, EditorPeriodoFrame editorPeriodoFrame) {
        editorPeriodoFrame.getBotaoAdicionar().addActionListener(e -> {
            try {
                Object item = editorPeriodoFrame.getMetodologiasComboBox().getSelectedItem();
                int idMetodologia = ((ComboItem)item).getId();
                Applicantion.controladorPeriodo.inserirMetodologiaPorID(id, idMetodologia);
                atualizarMetodologias(id, editorPeriodoFrame);
            } catch (Exception ex) {
                Mensagem.showMensagem(ex.getMessage());
            }
        });
    }

    private void adicionarListenerBotaoExcluir(int id, EditorPeriodoFrame editorPeriodoFrame) {
        editorPeriodoFrame.getBotaoExcluir().addActionListener(e -> {
            try {
                int linha = editorPeriodoFrame.getTabela().getSelectedRow();
                if (linha >= 0) {
                    String nome = editorPeriodoFrame.getTabela().getValueAt(linha, 1).toString();
                    String hashCode = editorPeriodoFrame.getTabela().getValueAt(linha, 2).toString();
                    Applicantion.controladorPeriodo.removerMetodologiaPorHashCode(id, hashCode);
                    atualizarMetodologias(id, editorPeriodoFrame);
                    Mensagem.showMensagem("Metodologia: " + nome + " com Hash Code: " + hashCode + " foi excluída com sucesso!");
                } else {
                    Mensagem.showMensagem(ViewConstants.NECESSARIOSELECIONARLINHA);
                }
            } catch (Exception ex) {
                Mensagem.showMensagem(ex.getMessage());
            }
        });
    }

    private void atualizarMetodologias(int id, EditorPeriodoFrame editorPeriodoFrame) throws Exception {
        ArrayList<Object[]> dadosMetodosAvaliativos = Applicantion.controladorPeriodo.getMetodologiasPorId(id);
        editorPeriodoFrame.atualizaTabela(dadosMetodosAvaliativos);
    }

    private void adicionarListenerBotaoSalvar(int id, EditorPeriodoFrame editorPeriodoFrame) {
        editorPeriodoFrame.getBotaoSalvar().addActionListener(e -> {
            try {
                String novoNome = editorPeriodoFrame.getNome();
                Applicantion.controladorPeriodo.editarPeriodo(id, novoNome);
                editorPeriodoFrame.dispose();
                atualizaTabela();
                Mensagem.showMensagem("Período: " + novoNome + " com Id: " + id + " foi alterado com sucesso!");
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
        for (Object[] dadoPeriodo: Applicantion.controladorPeriodo.getDadosPeriodos()){
            modelo.addRow(dadoPeriodo);
        }
    }

    private void atualizaTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }
}
