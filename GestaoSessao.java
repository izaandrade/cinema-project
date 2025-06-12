import java.util.ArrayList;

import javax.swing.JComboBox;

public class GestaoSessao {
	
	private static ArrayList<Sessao> listaDeSessoes = new ArrayList<Sessao>();
	private static ArrayList<Local> listaDeLocais = new ArrayList<Local>();
	
	public static void adicionarSessao (Sessao sessao) {
		listaDeSessoes.add(sessao);
	}
	
	public static ArrayList<Sessao> getListaDeSessao() {
		return listaDeSessoes;
	}

	public static void setListaDeSessao(ArrayList<Sessao> listaDeSessao) {
		GestaoSessao.listaDeSessoes = listaDeSessao;
	}
	
	public static void adicionarLocal (Local local) {
		listaDeLocais.add(local);
	}
	
	public static ArrayList<Local> getListaDeLocais(){
		return listaDeLocais;
	}
	
	public static JComboBox retornarLocais() {
		
		JComboBox<String> locais = new JComboBox<String>();
		if(listaDeLocais.isEmpty()==false) {				
			for(Local l : listaDeLocais) {			
				locais.addItem(l.getBloco());
			}
		
		}
		
		return locais;			
	}
	public static Local retornarLocal (int posicaoLocalEscolhido) {
		return listaDeLocais.get(posicaoLocalEscolhido);
	}
	
	
	
	public static JComboBox retornarSessoes() {
		
		JComboBox<String> sessoes = new JComboBox<String>();
		if(listaDeSessoes.isEmpty()==false) {				
			for(Sessao s : listaDeSessoes) {			
				sessoes.addItem(s.getHora());
			}
		
		}
		
		return sessoes;			
	}
	
	public static Sessao retornarSessao (int posicaoSessaoEscolhida) {
		return listaDeSessoes.get(posicaoSessaoEscolhida);
	}
	
	
}
