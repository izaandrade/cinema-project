import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuAluno {
    public static void exibirMenu() {

        int resposta;
        String[] reserva = {"Cadastrar Aluno", "Reservar ingresso", "Cancelar ingresso", "Consultar ingresso", "Sair"};
        JComboBox<String> opcoes = new JComboBox<>(reserva);

        do {
            JOptionPane.showMessageDialog(null, opcoes, "Opções de Reserva", 1);
            resposta = opcoes.getSelectedIndex();

            switch (resposta) {
                case 0:
                    cadastrarAluno();
                    break;

                case 1:
                    reservarIngresso();
                    break;
                case 2:
                    cancelarIngresso();
                    break;
                case 3:
                    consultarIngresso();
                    break;
            }
        } while (resposta != 4);
    }

    private static void cadastrarAluno() {
        String matriculaStr = EntradaSaidaDados.retornarTexto("Matrícula do Aluno: ");
        String nome = EntradaSaidaDados.retornarTexto("Nome do Aluno: ");
        String email = EntradaSaidaDados.retornarTexto("Email do Aluno: ");

        int matricula;
        try {
            matricula = Integer.parseInt(matriculaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Matrícula inválida. Deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido. Deve ser uma string não vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluno a1 = new Aluno(matricula, nome, email);
        GestaoAluno.adicionarAluno(a1);

        JOptionPane.showMessageDialog(null, "MATRÍCULA: " + matricula + "\nNOME: " + nome + "\nEMAIL: "
                + email, "ALUNO", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "ALUNO", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void reservarIngresso() {
        try {
            if (!GestaoAluno.getListaDeAlunos().isEmpty()) {
                JComboBox<String> cbAlunos = GestaoAluno.retornarAlunos();
                int posicaoAluno = EntradaSaidaDados.escolherAluno(cbAlunos);
                Aluno alunoSelecionado = GestaoAluno.getListaDeAlunos().get(posicaoAluno);

                JComboBox<String> cbFilmes = GestaoFilme.retornarFilmes();
                int posicaoFilme = EntradaSaidaDados.escolherFilme(cbFilmes);
                Filme filmeSelecionado = GestaoFilme.retornarFilme(posicaoFilme);

                JComboBox<String> cbSessoes = GestaoSessao.retornarSessoes();
                int posicaoSessao = EntradaSaidaDados.escolherSessao(cbSessoes);
                Sessao sessaoSelecionada = GestaoSessao.retornarSessao(posicaoSessao);

                int combo = JOptionPane.showConfirmDialog(null, "Deseja adicionar um combo?", "Combo", JOptionPane.YES_NO_OPTION);

                List<Integer> poltronasReservadas = new ArrayList<>();
                for (Ingresso ingresso : GestaoIngresso.getListaDeIngressos()) {
                    poltronasReservadas.add(ingresso.getPosicaoPoltrona());
                }

                JFrame frame = new JFrame();
                SelecPoltrona selecPoltrona = new SelecPoltrona(frame, alunoSelecionado, poltronasReservadas);
                selecPoltrona.setVisible(true);

                int poltronaReservada = selecPoltrona.getPoltronaReservada();

                if (poltronaReservada != -1) {
                    Ingresso ingresso = new Ingresso(alunoSelecionado,filmeSelecionado, sessaoSelecionada, poltronaReservada, combo);
                    GestaoIngresso.adicionarIngresso(ingresso);
                    JOptionPane.showMessageDialog(null, "Poltrona " + (poltronaReservada + 1) + " reservada. Confirmado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma poltrona foi reservada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao reservar o ingresso: " + e.getMessage());
        }
    }

    private static void cancelarIngresso() {
        try {
            if (!GestaoIngresso.getListaDeIngressos().isEmpty()) {
                JComboBox<String> cbIngressos = new JComboBox<>();
                for (Ingresso ingresso : GestaoIngresso.getListaDeIngressos()) {
                    cbIngressos.addItem("Poltrona " + ingresso.getPosicaoPoltrona() + (ingresso.isCombo() == 1 ? " com combo" : " sem combo"));
                }

                int opcao = JOptionPane.showOptionDialog(null, cbIngressos, "Selecione o ingresso a ser cancelado",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (opcao == JOptionPane.OK_OPTION) {
                    int opcaoSelecionada = cbIngressos.getSelectedIndex();

                    if (opcaoSelecionada != -1) {
                        GestaoIngresso.getListaDeIngressos().remove(opcaoSelecionada);
                        JOptionPane.showMessageDialog(null, "Ingresso cancelado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada, nenhum ingresso excluído.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada, nenhum ingresso excluído.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há ingressos reservados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar o ingresso: " + e.getMessage());
        }
    }

    
    private static void consultarIngresso() {
        try {
            if (!GestaoIngresso.getListaDeIngressos().isEmpty()) {
                StringBuilder ingressosInfo = new StringBuilder();
                for (Ingresso ingresso : GestaoIngresso.getListaDeIngressos()) {
                    String nomePessoa = ingresso.getAluno().getNome();
                    String nomeFilme = ingresso.getFilme().getTitulo();
                    
                    ingressosInfo.append("Nome: ").append(nomePessoa).append("\n")
                                 .append("Filme: ").append(nomeFilme).append("\n")
                                 .append("Poltrona ").append(ingresso.getPosicaoPoltrona() + 1)
                                 .append(ingresso.isCombo() == 1 ? " com combo\n" : " sem combo\n")
                                 .append("\n");
                }
                JOptionPane.showMessageDialog(null, ingressosInfo.toString(), "Ingressos Reservados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não há ingressos reservados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar os ingressos: " + e.getMessage());
        }
    }
}