package view.frame;

import view.components.SaveButtom;
import view.components.TextField;
import view.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class EditarAvaliaveisFrame extends DependentFrame {
    private JButton salvar;
    private JPanel painel;

    private int gridy = 0;
    private ArrayList<JTextField> avaliaveisTextFilds = new ArrayList<>();
    private ArrayList<Object[]> metodosAvaliativos;

    public EditarAvaliaveisFrame() {
        super("Editar Notas Aluno", ViewConstants.dependentFrameWidth, 450);
        criarInterface();
    }

    public JButton getSalvar() {
        return salvar;
    }

    private void criarInterface() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        painel = new JPanel(new GridBagLayout());
        painel.setBorder(new CompoundBorder(new TitledBorder("Editar Notas Aluno"), new EmptyBorder(10, 10, 10, 10)));
        add(painel, gbc);

        gbc.gridy++;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 20, 20);
        add(salvar = new SaveButtom("Salvar"), gbc);
    }

    private void inserirLinhaAvaliavel(String label, JTextField avaliavel){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.weightx = 0.3;
        painel.add(new JLabel(label), gbc);

        gbc.gridx++;
        gbc.weightx = 0.7;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(avaliavel, gbc);

        gridy++;
    }

    public void alualizaMetodosAvaliativos(ArrayList<Object[]> metodosAvaliativos) {
        this.metodosAvaliativos = metodosAvaliativos;

        for (int i = 0; i < metodosAvaliativos.size(); i++) {
            Object[] metodosAvaliativo = metodosAvaliativos.get(i);
            if(metodosAvaliativo != null) {
                if(metodosAvaliativo[1] != null){
                    String nome = metodosAvaliativo[1].toString();
                    String valor = "0.0";
                    if(metodosAvaliativo[2] != null) {
                        valor = metodosAvaliativo[2].toString();
                    }
                    avaliaveisTextFilds.add(i, new TextField());
                    avaliaveisTextFilds.get(i).setText(valor);
                    inserirLinhaAvaliavel(nome, avaliaveisTextFilds.get(i));
                }
            }
        }
    }

    public ArrayList<Object[]> getValoresMetodosAvaliativos(){
        for (int i = 0; i < metodosAvaliativos.size(); i++) {
            Object[] metodosAvaliativo = metodosAvaliativos.get(i);
            if(metodosAvaliativo != null) {
                double valor = Double.parseDouble(avaliaveisTextFilds.get(i).getText());
                if(metodosAvaliativo[2] != null){
                    metodosAvaliativo[2] = valor;
                }
            }
        }
        return metodosAvaliativos;
    }
}
