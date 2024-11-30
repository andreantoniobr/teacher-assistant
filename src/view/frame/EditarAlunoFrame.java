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

public class EditarAlunoFrame extends DependentFrame {
    private JTextField nome;
    private JButton salvar;
    private JTextField email;
    private JComboBox turmaComboBox;
    private int turmaComboBoxSelectedItemId;

    public EditarAlunoFrame(Object[] dadoAluno) {
        super("Editar Aluno", ViewConstants.dependentFrameWidth, 300);
        criarInterface();
        setDadosAluno(dadoAluno);
        popularComboBox();
    }
    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String email) {
        this.email.setText(email);
    }

    public JButton getSalvar() {
        return salvar;
    }

    public JComboBox getComboBox(){
        return this.turmaComboBox;
    }

    private void criarInterface() {
        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel painelAluno = new JPanel(new GridBagLayout());
        painelAluno.setBorder(new CompoundBorder(new TitledBorder(ViewConstants.ALUNO), new EmptyBorder(10, 10, 10, 10)));

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
        painelAluno.add(new JLabel("Turma: "), gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        painelAluno.add(turmaComboBox = new JComboBox<>(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelAluno.add(salvar = new SaveButtom("Salvar"), gbc);
        add(painelAluno, BorderLayout.CENTER);
    }



    private void popularComboBox() {
        try
        {
            for(Object[] object : Applicantion.ControladorTurma.getDadosTurmas()){
                int id = (int) object[0];
                String nomeTurma = object[1].toString();
                ComboItem item = new ComboItem(id, nomeTurma);
                turmaComboBox.addItem(item);
                if(id == turmaComboBoxSelectedItemId){
                    turmaComboBox.setSelectedItem(item);
                }
            }
        } catch (Exception e) {
            Mensagem.showMensagem(e.getMessage());
        }
    }

    private void setDadosAluno(Object[] dadoAluno) {
        if(dadoAluno[0] != null) {
            String nome = dadoAluno[0].toString();
            setNome(nome);
        }

        if(dadoAluno[1] != null){
            String email = dadoAluno[1].toString();
            setEmail(email);
        }

        if(dadoAluno[2] != null){
            turmaComboBoxSelectedItemId = Integer.parseInt(dadoAluno[2].toString());
            System.out.println(turmaComboBoxSelectedItemId);
        }
    }
}
