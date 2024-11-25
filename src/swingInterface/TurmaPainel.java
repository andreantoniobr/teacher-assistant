package swingInterface;
import app.Applicantion;
import app.Turma;

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

    private void criarInterfaceTurma() {
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new TitledBorder(InterfaceConstants.TURMA), new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JPanel painelTurma = new JPanel(new GridBagLayout());
        painelTurma.add(new JLabel(InterfaceConstants.CAMPONOMEDATURMA), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelTurma.add((nome = new JTextField(10)), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 20, 0);
        painelTurma.add(adicionar = new JButton(InterfaceConstants.ADICIONAR), gbc);
        add(painelTurma, BorderLayout.PAGE_START);

        criaTabela();
        preencheTabela();

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(GridBagConstraints.HORIZONTAL, 500);
        painelFundo.add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(editar = new JButton(InterfaceConstants.EDITAR));
        painelBotoes.add(excluir = new JButton(InterfaceConstants.EXCLUIR));
        painelFundo.add(painelBotoes, BorderLayout.PAGE_END);
        add(painelFundo, BorderLayout.CENTER);
    }

    private void adicionarListenersBotoes() {
        adicionar.addActionListener(e -> adicionarTurma());
        excluir.addActionListener(e -> excluirTurma());
        editar.addActionListener(e -> editarTurma());
    }

    private void adicionarTurma() {
        if(getNome() == null || getNome().isEmpty() ){
            Mensagem.showMensagem("Campo \"Nome da Turma\" é obrigatorio o preenchimento!");
        } else {
            Turma turma = new Turma(getNome());
            Applicantion.ControladorTurma.inserirTurma(turma);
            inserirDadosTurmaTabela(turma);
        }
    }

    private void excluirTurma() {
        int linha = -1;
        linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
            String nome = tabela.getValueAt(linha, 1).toString();
            if(Applicantion.ControladorTurma.excluirTurma(id)){
                updateTabela();
                Mensagem.showMensagem("Turma: " + nome + " com Id: " + id + " foi excluida com sucesso!");
            }
        } else {
            Mensagem.showMensagem(InterfaceConstants.NECESSARIOSELECIONARLINHA);
        }
    }

    private void editarTurma() {
        int linha = -1;
        linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int id = Integer.parseInt(tabela.getValueAt(linha, 0).toString());
            String nome = tabela.getValueAt(linha, 1).toString();
            if(Applicantion.ControladorTurma.editarTurma(id, nome)){
                updateTabela();
                Mensagem.showMensagem("Turma: " + nome + " com Id: " + id + " foi alterada com sucesso!");
            }
        } else {
            Mensagem.showMensagem(InterfaceConstants.NECESSARIOSELECIONARLINHA);
        }
    }

    private void criaTabela() {
        String [] colunas = {InterfaceConstants.ID, InterfaceConstants.NOME};
        modelo.setColumnIdentifiers(colunas);
        tabela = new JTable(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
    }

    private void preencheTabela(){
        for (Turma turma: Applicantion.ControladorTurma.getTurmas()){
            inserirDadosTurmaTabela(turma);
        }
    }

    private void updateTabela(){
        modelo.setRowCount(0);
        preencheTabela();
    }

    private void inserirLinhaTabela(String id, String nome){
        modelo.addRow(new Object[] {id, nome});
    }

    private void inserirDadosTurmaTabela(Turma turma){
        inserirLinhaTabela(Integer.toString(turma.getId()), turma.getNome());
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }
}
