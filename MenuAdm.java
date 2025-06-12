import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MenuAdm {
	public static void exibirMenu() {
		
		
		int resposta;
		String[] gestao = {"Cadastrar filme", "Cadastrar sessão", "Excluir sessão", "Cadastrar local", "Sair"};
		JComboBox opcoes = new JComboBox(gestao);
		
		do {
		JOptionPane.showMessageDialog(null, opcoes, "Opções de Gestão", 1);
		resposta = opcoes.getSelectedIndex();
		
		switch (resposta) {
		case 0:
			cadastrarFilme();
			break;
		
		case 1:
			cadastrarSessao();
			break;
		case 2: 
			excluirSessao();
			break;
		case 3:
			cadastrarLocal();
		}
		}while (resposta != 4);
	
	}
	
	private static void cadastrarFilme() {
		String titulo = EntradaSaidaDados.retornarTexto("Título do filme");
		int duracao = EntradaSaidaDados.retornarInteiro("Duração (em minutos)");
		String genero = EntradaSaidaDados.retornarTexto("Gênero");
		int classificacao = EntradaSaidaDados.retornarInteiro("Informe a classificação");
		
		Filme f = new Filme(titulo, genero, duracao, classificacao);
		GestaoFilme.adicionarFilme(f);
		
		JOptionPane.showMessageDialog(null, "TÍTULO: "+titulo+"\nDURAÇÃO: "+duracao+" min\nCLASSIFICAÇÃO: "
		+classificacao+" anos", "FILME", 1);
		
		JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!", "FILME", 1);
		
	}
	
	private static void cadastrarSessao() {
		if (!GestaoSessao.getListaDeLocais().isEmpty() && !GestaoFilme.getListaDeFilme().isEmpty()) {
		
    	int posicaoLocal = EntradaSaidaDados.escolherLocal(GestaoSessao.retornarLocais());
		int posicaoFilme = EntradaSaidaDados.escolherFilme(GestaoFilme.retornarFilmes());
    	LocalDate data = solicitarData("Informe a data DD//MM/YYYY");
		String hora = EntradaSaidaDados.retornarTexto("Informe a hora que começará a sessão");
		
			
		Sessao s = new Sessao (data, hora, posicaoLocal, posicaoFilme);
		GestaoSessao.adicionarSessao(s);
		JOptionPane.showMessageDialog(null, "DATA: "+data+"\nHORA: "+hora+
				"h\nLOCAL: "+GestaoSessao.retornarLocal(posicaoLocal).getBloco()+GestaoSessao.retornarLocal(posicaoLocal).getSala()+
				"\nFILME: "+GestaoFilme.retornarFilme(posicaoFilme).getTitulo(),"SESSÃO", 1);   ///VALIDAR SOBRE O RETORNO DO NOME DO LOCAL E DO FILME
				
		JOptionPane.showMessageDialog(null, "Sessão cadastrado com sucesso!", "SESSÃO", 1);
				
		}else {
			JOptionPane.showMessageDialog(null, "Não há locais ou filmes cadastrados.\nCadastre antes de criar uma sessão.", null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static void excluirSessao() {
	    // Verifica se há sessões cadastradas antes de tentar excluí-las
	    if (GestaoSessao.getListaDeSessao().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Não há nenhuma sessão cadastrada.", null, JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    JComboBox<String> sessoes = new JComboBox<>();
	    for (Sessao sessao : GestaoSessao.getListaDeSessao()) {
	        sessoes.addItem(sessao.getHora());
	    }
	    
	    int opcao = JOptionPane.showOptionDialog(null, sessoes, "Selecione a sessão a ser excluída", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	    
	    // Verifica se o usuário selecionou uma sessão (o botão "OK" foi pressionado)
	    if (opcao == JOptionPane.OK_OPTION) {
	        int opcaoSelecionada = sessoes.getSelectedIndex();
	        
	        // Verifica se uma opção válida foi selecionada
	        if (opcaoSelecionada != -1) {
	            GestaoSessao.getListaDeSessao().remove(opcaoSelecionada);
	            JOptionPane.showMessageDialog(null, "Sessão excluída com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Operação cancelada, nenhuma sessão excluída.", null, JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Operação cancelada, nenhuma sessão excluída.", null, JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	
	private static LocalDate solicitarData(String mensagem) {
        LocalDate data = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        do {
            try {
                String userInput = EntradaSaidaDados.retornarTexto(mensagem);
                Date date = dateFormat.parse(userInput);
                data = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,"Formato de data inválido. Por favor, insira no formato DD/MM/YYYY.");
            }
        } while (data == null);

        return data;
    }
	
	private static void cadastrarLocal () {
		String bloco = EntradaSaidaDados.retornarTexto("Informe o bloco");
		int sala = EntradaSaidaDados.retornarInteiro("Digite o número da sala");
		int capacidade = EntradaSaidaDados.retornarInteiro("Digite a capacidade do local");
		
		
		Local l = new Local (capacidade, sala, bloco);
		GestaoSessao.adicionarLocal(l);
		
		JOptionPane.showMessageDialog(null, "BLOCO: "+bloco+"\nSALA: "+sala+"\nCAPACIDADE: "+capacidade+" pessoas","LOCAL", 1);
		
		JOptionPane.showMessageDialog(null, "Local cadastrado com sucesso!", "LOCAL", 1);
			
	}
}


