package view.frame;

import controller.Applicantion;
import view.ComboItem;
import view.Mensagem;
import view.constant.ViewConstants;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EditarMetodologiaNotaFrame extends DependentFrame {
    private JTextField nome;
    private JButton adicionar, salvar;
    private JComboBox metodosAvaliativos;
    private JPanel painelMetodologia;

    public EditarMetodologiaNotaFrame(String nome) {
        super("Editar Metodologia de Nota", ViewConstants.dependentFrameWidth, 400);
        view();
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

    public JComboBox getMetodosAvaliativos() {
        return metodosAvaliativos;
    }

    private void view() {
        setLayout(new BorderLayout());
        painelMetodologia = new JPanel(new BorderLayout());
        painelMetodologia.setBorder(new CompoundBorder(new TitledBorder("Metodologia de Nota"), new EmptyBorder(10, 10, 10, 10)));
        addTextPanel();
        addComboBoxPanel();
        add(painelMetodologia, BorderLayout.PAGE_START);

        painelMetodologia.add(salvar = new JButton("Salvar"), BorderLayout.PAGE_END);
    }

    private void addTextPanel() {
        JPanel painelText = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        painelText.add(new JLabel("Nome da Metodologia: "), gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelText.add((nome = new JTextField(10)), gbc);

        painelMetodologia.add(painelText, BorderLayout.PAGE_START);
    }

    private void addComboBoxPanel() {
        JPanel painelComboBox = new JPanel(new BorderLayout(10, 10));
        //String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        metodosAvaliativos = new JComboBox<>();

        popularComboBox();

        painelComboBox.add(metodosAvaliativos, BorderLayout.LINE_START);
        painelComboBox.add(adicionar = new JButton("Adicionar Metodo Avaliativo"), BorderLayout.LINE_END);

        painelMetodologia.add(painelComboBox, BorderLayout.CENTER);
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
}
