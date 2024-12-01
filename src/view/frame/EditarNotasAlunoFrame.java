package view.frame;

import controller.Applicantion;
import view.components.*;
import view.components.TextField;
import view.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class EditarNotasAlunoFrame extends DependentFrame {
    private JTextField nome;
    private JButton editarNotas;
    private JComboBox periodoComboBox, metodologiasComboBox;

    public EditarNotasAlunoFrame(Object[] dadoAluno) {
        super("Editar Notas Aluno", ViewConstants.dependentFrameWidth, 300);
        criarInterface();
        setDadosAluno(dadoAluno);
        popularPeriodoComboBox();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public JButton getEditarNotas() {
        return editarNotas;
    }

    public JComboBox getPeriodoComboBoxComboBox(){
        return this.periodoComboBox;
    }

    public JComboBox getMetodologiasComboBox(){
        return this.metodologiasComboBox;
    }

    private void criarInterface() {
        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel painelAluno = new JPanel(new GridBagLayout());
        painelAluno.setBorder(new CompoundBorder(new TitledBorder("Notas"), new EmptyBorder(10, 10, 10, 10)));

        painelAluno.add(new JLabel(ViewConstants.CAMPONOMEDOALUNO), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelAluno.add((nome = new TextField()), gbc);
        nome.setEditable(false);


        gbc.gridx = 0;
        gbc.gridy++;
        painelAluno.add(new JLabel("Período: "), gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        painelAluno.add(periodoComboBox = new CustomComboBox(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        painelAluno.add(new JLabel("Metodologia: "), gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        painelAluno.add(metodologiasComboBox = new CustomComboBox(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelAluno.add(editarNotas = new AddButton("Adicionar Notas"), gbc);
        add(painelAluno, BorderLayout.CENTER);
    }

    private void popularPeriodoComboBox() {
        try
        {
            periodoComboBox.addItem(new ComboItem(-1, "Nenhum Periodo Selecionado"));
            for(Object[] object : Applicantion.controladorPeriodo.getDadosPeriodos()){
                int id = (int) object[0];
                String nome = object[1].toString();
                ComboItem item = new ComboItem(id, nome);
                periodoComboBox.addItem(item);
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    public void popularMetodologiasComboBox(ArrayList<Object[]> metodologias) {
        try
        {
            removerTodasMetodologias();
            for(Object[] object : metodologias){
                int id = (int) object[0];
                String nomeMetodologia = object[1].toString();
                metodologiasComboBox.addItem(new ComboItem(id, nomeMetodologia));
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    public void removerTodasMetodologias(){
        metodologiasComboBox.removeAllItems();
    }

    private void setDadosAluno(Object[] dadoAluno) {
        if(dadoAluno[0] != null) {
            String nome = dadoAluno[0].toString();
            setNome(nome);
        }
    }
}
