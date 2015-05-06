import java.util.*;

public class AgendaList implements IF_Agenda {
	
	// lista de contatos
	private Collection<IF_Contato> contatos;
	
	/**
	 * Métododo construtor
	 * Cria uma instancia da lista de contatos
	 */
	public AgendaList(){
		this.contatos = new ArrayList<IF_Contato>();
	}
	
	/**
	 * Um atalho para System.out.println para imprimir Strings
	 * @param _txt A String a ser impressa
	 */
	public static void prln(String _txt){
		System.out.println(_txt);
	}
	
	/**
	 * Método que devolve o índice de um telefone na lista
	 * @param _telefone A String do número de telefone a ser procurado
	 * @return O índice do telefone
	 */
	private int getIndicePorTelefone(String _telefone){
		IF_Contato c = new Contato();
		c.setTelefone(_telefone);
		return ((ArrayList<IF_Contato>)this.contatos).indexOf(c);
	}

	/**
	 * Método que adiciona um contato à lista
	 * @param _contato O contato a ser adicionado
	 * @return TRUE se foi adicionado, FALSE se o contato já existia na lista
	 */
	public boolean adicionaContato(IF_Contato _contato) {
		if (!this.contatos.contains(_contato)){
			this.contatos.add(_contato);
			return true;
		}
		return false;
	}

	/**
	 * Método que retorna um contato buscado por seu telefone
	 * @param _telefone A String do número de telefone a ser buscado
	 * @return O contato encontrado ou NULL caso não encontre
	 */
	public IF_Contato getContatoPorTelefone(String _telefone) {
		int i = this.getIndicePorTelefone(_telefone);
		if (i > -1){
			return ((ArrayList<IF_Contato>)this.contatos).get(i);
		}
		return null;
	}

	/**
	 * Método que retorna uma lista de contatos cujos nomes iniciem com as iniciais passadas
	 * @param _iniciais String das iniciais a serem buscadas
	 * @return Lista de contatos encontrados
	 */
	public ArrayList<IF_Contato> getContatoPorIniciaisNome(String _iniciais) {
		ArrayList<IF_Contato> tmp = new ArrayList<IF_Contato>();
		
		Iterator<IF_Contato> it = this.contatos.iterator();
		
		while(it.hasNext()){		
			IF_Contato contato = (IF_Contato)it.next();
			if (contato.getNome().toLowerCase().startsWith(_iniciais.toLowerCase()))
				tmp.add(contato);
		}
		
		return tmp;
	}

	/**
	 * Método que remove um contato da lista através do seu telefone
	 * @param _telefone String do telefone a ser buscado
	 * @return TRUE caso seja removido com sucesso ou FALSE caso o contato não exista
	 */
	public boolean removeContato(String _telefone) {
		return this.contatos.remove(this.getContatoPorTelefone(_telefone));
	}

	/**
	 * Método que retorna a lista de contatos
	 * @return Lista com todos os contatos
	 */
	public Collection<IF_Contato> listContato() {
		return this.contatos;
	}

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		// cria a agenda
		IF_Agenda agenda = new AgendaList();
		
		// cria primeiro contato
		IF_Contato c1 = new Contato("Eduardo","9999-0000");
		prln(agenda.adicionaContato(c1) ? "Contato adicionado com sucesso\n" : "Contato já existe\n");
		
		// cria segundo contato
		IF_Contato c2 = new Contato("Walter","8888-0000");
		prln(agenda.adicionaContato(c2) ? "Contato adicionado com sucesso\n" : "Contato já existe\n");

		// tenta repetir um numero
		IF_Contato c3 = new Contato("Jose","9999-0000");
		prln(agenda.adicionaContato(c3) ? "Contato adicionado com sucesso\n" : "Contato já existe\n");
		
		// adiciona mais contatos
		agenda.adicionaContato(new Contato("Pedro", "8712-9898"));
		agenda.adicionaContato(new Contato("Paulo", "8712-2214"));
		agenda.adicionaContato(new Contato("Natalia", "9965-9898"));
		agenda.adicionaContato(new Contato("Beatriz", "9255-3056"));
		
		// busca um numero não existente
		prln("Buscando por 9999-0001....");
		prln(agenda.getContatoPorTelefone("9999-0001") != null ? agenda.getContatoPorTelefone("9999-0001").toString()+"\n" : "Contato não encontrado\n");
		
		// busca um contato existente
		prln("Buscando por 9999-0000....");
		prln(agenda.getContatoPorTelefone("9999-0000").toString()+"\n");
		
		// remove um contato existente
		prln(agenda.removeContato("9999-0000") ? "Contato removido com sucesso\n":"Contato não removido\n");
		// remove um contato não existente
		prln(agenda.removeContato("9999-0500") ? "Contato removido com sucesso\n":"Contato não removido\n");
		
		// busca por iniciais
		ArrayList<IF_Contato> iniciais = agenda.getContatoPorIniciaisNome("p");
		System.out.println(iniciais+"\n");
		
		// retorna a lista
		Collection<IF_Contato> lista = agenda.listContato();		
		Iterator<IF_Contato> it = lista.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
