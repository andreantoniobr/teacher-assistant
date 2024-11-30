package view.frame;

import controller.Applicantion;
import view.components.*;
import view.components.TextField;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VisualizarNotasPeriodoFrame extends DependentFrame {
    private JPanel painel;

    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();

    public VisualizarNotasPeriodoFrame() {
        super("Visualizar Notas por Período", 600, 450);
        criarInterface();
    }

    public JTable getTabela() {
        return this.tabela;
    }

    private void criarInterface() {
        setLayout(new GridBagLayout());

        painel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        add(painel, gbc);
        criaTabela();

        gbc.insets = new Insets(0, 0, 0, 0);
        painel.add(new JScrollPane(tabela), gbc);

    }

    private void criaTabela() {
        String [] colunas = {"Período", "Metodologia", "Notal Final"};
        modelo.setColumnIdentifiers(colunas);
        tabela = new CustomJTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
    }

    private void preencheTabela(ArrayList<Object[]> dadosNotas){
        for (Object[] dadoNota: dadosNotas){
            modelo.addRow(dadoNota);
        }
    }

    public void atualizaTabela(ArrayList<Object[]> dadosNotas){
        modelo.setRowCount(0);
        preencheTabela(dadosNotas);
    }
}
