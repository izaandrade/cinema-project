import java.util.ArrayList;

import javax.swing.JComboBox;

public class GestaoAluno {
	private static ArrayList<Aluno> listaDeAlunos = new ArrayList<Aluno> ();
	
	public static void adicionarAluno (Aluno aluno) {
		listaDeAlunos.add(aluno);
	}

	public static ArrayList<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}

	public static void setListaDeAluno(ArrayList<Aluno> listaDeAluno) {
		GestaoAluno.listaDeAlunos = listaDeAluno;
	}
	
	public static Aluno retornarAluno (int posicaoAlunoEscolhido) {
		return listaDeAlunos.get(posicaoAlunoEscolhido);
	}
	
	
public static JComboBox retornarAlunos() {
		
		JComboBox<String> alunos = new JComboBox<String>();
		if(listaDeAlunos.isEmpty()==false) {				
			for(Aluno a : listaDeAlunos) {			
				alunos.addItem((a.getNome()));
			}
		
		}
		
		return alunos;			
	}
	
	
	
}
