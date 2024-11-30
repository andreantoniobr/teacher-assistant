package view.frame;

import controller.Applicantion;
import view.components.*;
import view.components.TextField;
import view.constants.ViewConstants;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class EditarMetodologiaNotaFrame extends DependentFrame {
    private JTextField nome;
    private JButton adicionar, salvar, excluir;
    private JPanel painelMetodologia;

    private JComboBox metodosAvaliativos;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public EditarMetodologiaNotaFrame(String nome) {
        super("Editar Metodologia de Nota", 500, 450);
        criarInterface();
        setNome(nome);
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public JButton getBotaoAdicionar() {
        return adicionar;
    }

    public JButton getBotaoSalvar() {
        return salvar;
    }

    public JButton getBotaoExcluir() {
        return this.excluir;
    }

    public JTable getTabela() {
        return this.tabela;
    }

    public JComboBox getMetodosAvaliativos() {
        return metodosAvaliativos;
    }

    private void criarInterface() {
        setLayout(new GridBagLayout());

        painelMetodologia = new JPanel(new GridBagLayout());
        painelMetodologia.setBorder(new CompoundBorder(new TitledBorder("Metodologia de Nota"), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbcPainelMetodologia = new GridBagConstraints();
        gbcPainelMetodologia.gridx = 0;
        gbcPainelMetodologia.gridy = 0;
        gbcPainelMetodologia.weightx = 1;
        gbcPainelMetodologia.gridwidth = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.fill = GridBagConstraints.HORIZONTAL;

        addTextPanel(gbcPainelMetodologia);
        addComboBoxPanel(gbcPainelMetodologia);
        addTablePanel(gbcPainelMetodologia);



        gbcPainelMetodologia.gridy++;
        gbcPainelMetodologia.weighty = 0;
        gbcPainelMetodologia.gridheight = GridBagConstraints.PAGE_END;
        gbcPainelMetodologia.fill = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.anchor = GridBagConstraints.PAGE_END;
        painelMetodologia.add(salvar = new SaveButtom("Salvar"), gbcPainelMetodologia);


        gbcPainelMetodologia.gridx = 0;
        gbcPainelMetodologia.gridy = 0;
        gbcPainelMetodologia.weightx = 1;
        gbcPainelMetodologia.weighty = 1;
        gbcPainelMetodologia.gridwidth = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.gridheight = GridBagConstraints.VERTICAL;
        gbcPainelMetodologia.fill = GridBagConstraints.BOTH;
        gbcPainelMetodologia.insets = new Insets(10, 10, 10, 10);
        add(painelMetodologia, gbcPainelMetodologia);
    }

    private void addTextPanel(GridBagConstraints gbcPainelMetodologia ) {
        JPanel painelText = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 0);
        painelText.add(new JLabel("Nome da Metodologia: "), gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelText.add((nome = new TextField()), gbc);

        gbcPainelMetodologia.gridy++;
        gbcPainelMetodologia.weightx = 1;
        gbcPainelMetodologia.fill = GridBagConstraints.HORIZONTAL;
        painelMetodologia.add(painelText, gbcPainelMetodologia);
    }

    private void addComboBoxPanel(GridBagConstraints gbcPainelMetodologia) {
        JPanel painelComboBox = new JPanel(new BorderLayout(10, 10));
        metodosAvaliativos = new JComboBox<>();

        popularComboBox();

        painelComboBox.add(metodosAvaliativos, BorderLayout.LINE_START);
        painelComboBox.add(adicionar = new AddButton("Adicionar Metodo Avaliativo"), BorderLayout.LINE_END);

        gbcPainelMetodologia.gridy++;
        gbcPainelMetodologia.weightx = 1;
        gbcPainelMetodologia.gridwidth = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.fill = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.insets = new Insets(10, 0, 10, 0);
        painelMetodologia.add(painelComboBox, gbcPainelMetodologia);
    }

    private void addTablePanel(GridBagConstraints gbcPainelMetodologia){
        criaTabela();

        gbcPainelMetodologia.gridy++;
        gbcPainelMetodologia.weighty = 1;
        //gbcPainelMetodologia.gridheight = GridBagConstraints.VERTICAL;
        gbcPainelMetodologia.fill = GridBagConstraints.BOTH;
        gbcPainelMetodologia.anchor = GridBagConstraints.PAGE_START;
        gbcPainelMetodologia.insets = new Insets(10, 0, 10, 0);
        painelMetodologia.add(new JScrollPane(tabela), gbcPainelMetodologia);


        gbcPainelMetodologia.gridy++;
        gbcPainelMetodologia.gridwidth = GridBagConstraints.REMAINDER;
        gbcPainelMetodologia.anchor = GridBagConstraints.PAGE_START;
        gbcPainelMetodologia.fill = GridBagConstraints.HORIZONTAL;
        gbcPainelMetodologia.insets = new Insets(0, 0, 0, 0);
        painelMetodologia.add(excluir = new DeleteButtom("Excluir Método Avaliativo"), gbcPainelMetodologia);


    }

    private void popularComboBox() {
        try
        {
            for(Object[] object : Applicantion.controladorMetodoAvaliativo.getDadosMetodosAvaliativos()){
                int id = (int) object[0];
                String tipoAvaliacao = object[1].toString();
                metodosAvaliativos.addItem(new ComboItem(id, tipoAvaliacao));
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void criaTabela() {
        String [] colunas = {"Id do Método Avaliativo", "Nome", "Identificador"};
        modelo.setColumnIdentifiers(colunas);
        tabela = new CustomJTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(170);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
    }

    private void preencheTabela(ArrayList<Object[]> dadosMetodosAvaliativos){
        for (Object[] dadosMetodoAvaliativo: dadosMetodosAvaliativos){
            modelo.addRow(dadosMetodoAvaliativo);
        }
    }

    public void atualizaTabela(ArrayList<Object[]> dadosMetodosAvaliativos){
        modelo.setRowCount(0);
        preencheTabela(dadosMetodosAvaliativos);
    }
}
