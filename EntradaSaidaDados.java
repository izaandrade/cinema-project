import java.util.ArrayList;

import javax.swing.JComboBox;
import  javax.swing.JOptionPane;

public class EntradaSaidaDados {
	public static String retornarTexto (String mensagem) {
		return JOptionPane.showInputDialog(null,mensagem, "Digite o que foi solicitado", 1);
	}

	public static int retornarInteiro (String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, "Digite o que foi solicitado", 1));
	}
	
	public static double retornarReal (String mensagem) {
		return Double.parseDouble(JOptionPane.showInputDialog(null,mensagem, "Digite o que foi solicitado", 1));
	}
	public static int  escolherLocal(JComboBox<String> listaDeLocais) {		
		JOptionPane.showInternalMessageDialog(null, listaDeLocais, "Lista de Locais", 1, null);
		return listaDeLocais.getSelectedIndex();
	}
	public static int  escolherFilme(JComboBox<String> listaDeFilmes) {		
		JOptionPane.showInternalMessageDialog(null, listaDeFilmes, "Lista de Filmes", 1, null);
		return listaDeFilmes.getSelectedIndex();
	}
	public static int  escolherSessao(JComboBox<String> listaDeSessoes) {		
		JOptionPane.showInternalMessageDialog(null, listaDeSessoes, "Lista de Sessões", 1, null);
		return listaDeSessoes.getSelectedIndex();
	}
	
	public static int escolherAluno (JComboBox<String> listaDeAlunos) {
		JOptionPane.showInternalMessageDialog(null, listaDeAlunos, "Lista de Alunos", 1, null);
		return listaDeAlunos.getSelectedIndex();
	}
	
	
}
