import java.util.ArrayList;

import javax.swing.JComboBox;

public class GestaoFilme {
	
	private static ArrayList<Filme> listaDeFilmes = new ArrayList<Filme> ();
	
	public static void adicionarFilme (Filme filme) {
		listaDeFilmes.add(filme);
	}

	public static ArrayList<Filme> getListaDeFilme() {
		return listaDeFilmes;
	}

	public static void setListaDeFilme(ArrayList<Filme> listaDeFilme) {
		GestaoFilme.listaDeFilmes = listaDeFilme;
	}
	
	public static JComboBox retornarFilmes() {
		
		JComboBox<String> filmes = new JComboBox<String>();
		if(listaDeFilmes.isEmpty()==false) {				
			for(Filme f : listaDeFilmes) {			
				filmes.addItem(f.getTitulo());
			}
		
		}
		
		return filmes;			
	}
	public static Filme retornarFilme (int posicaoFilmeEscolhido) {
		return listaDeFilmes.get(posicaoFilmeEscolhido);
	}
	
	

}
