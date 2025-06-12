import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SelecPoltrona extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton[] botoes;
    private int lotacaoMax = 50;
    private boolean poltronaReservada = false;
    private Aluno alunoSelecionado;
    private int poltronaEscolhida = -1;

    public SelecPoltrona(JFrame parent, Aluno alunoSelecionado, List<Integer> poltronasReservadas) {
        super(parent, "Seleção de Poltrona", true); // true indica que é um diálogo modal
        this.alunoSelecionado = alunoSelecionado;
        int largura = 50;
        int altura = 30;
        int x = 50;
        int y = 50;

        setSize(700, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // fechar apenas a janela de diálogo
        setResizable(false);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(Color.gray);

        setLayout(null);

        botoes = new JButton[lotacaoMax];
        for (int i = 0; i < lotacaoMax; i++) {
            botoes[i] = new JButton("P" + (i + 1));
            botoes[i].setBounds(x + (i % 10) * (largura + 10), y + (i / 10) * (altura + 10), largura, altura);
            botoes[i].setFont(new Font("Arial", Font.PLAIN, 8));
            if (poltronasReservadas.contains(i)) {
                botoes[i].setBackground(Color.red);
                botoes[i].setEnabled(false);
            } else {
                botoes[i].setBackground(Color.green);
                botoes[i].addActionListener(this);
            }
            add(botoes[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        for (int i = 0; i < lotacaoMax; i++) {
            if (clickedButton == botoes[i]) {
                if (!poltronaReservada) {
                    clickedButton.setBackground(Color.red);
                    clickedButton.setEnabled(false);
                    clickedButton.setText("OK");
                    poltronaReservada = true;
                    poltronaEscolhida = i;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Já existe uma poltrona reservada!");
                    break;
                }
            }
        }
    }

    public int getPoltronaReservada() {
        return poltronaEscolhida;
    }
}