import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Principal {

	public static void main(String[] args) {
		int resposta;
		String[] usuario = {"ADMINISTRADOR", "ALUNO", "SAIR"};
		JComboBox opcoes = new JComboBox (usuario);
		
		do {
			JOptionPane.showMessageDialog(null, opcoes, "Identificação de Usuário", 1);
			resposta = opcoes.getSelectedIndex();
			
			switch (resposta) {
			case 0:
				MenuAdm.exibirMenu();
				break;
			
			case 1:
				MenuAluno.exibirMenu();
				break;
			}
		}while(resposta != 2);
	}
}
