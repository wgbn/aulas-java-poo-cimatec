import java.util.ArrayList;
import java.util.Collection;

public class AgendaList implements IF_Agenda {
	
	private Collection<IF_Contato> contatos;
	
	public AgendaList(){
		this.contatos = new ArrayList<IF_Contato>();
	}
	
	public static void prln(String _txt){
		System.out.println(_txt);
	}
	
	private int getIndicePorTelefone(String _telefone){
		IF_Contato c = new Contato();
		c.setTelefone(_telefone);
		return ((ArrayList<IF_Contato>)this.contatos).indexOf(c);
	}

	public boolean adicionaContato(IF_Contato _contato) {
		if (!this.contatos.contains(_contato)){
			this.contatos.add(_contato);
			return true;
		}
		return false;
	}

	public IF_Contato getContatoPorTelefone(String _telefone) {
		int i = this.getIndicePorTelefone(_telefone);
		if (i > -1){
			return ((ArrayList<IF_Contato>)this.contatos).get(i);
		}
		return null;
	}

	public ArrayList getContatoPorIniciaisNome(String _iniciais) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeContato(String _telefone) {
		//((ArrayList<IF_Contato>)this.contatos).remove(this.getIndicePorTelefone(_telefone));
		return this.contatos.remove(this.getContatoPorTelefone(_telefone));
	}

	public Collection listContato() {
		return this.contatos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IF_Agenda agenda = new AgendaList();
		
		// cria primeiro contato
		IF_Contato c1 = new Contato("Eduardo","9999-0000");
		
		if (agenda.adicionaContato(c1))
			prln("Contato adicionado com sucesso");
		else
			prln("Contato já existe");
		
		// cria segundo contato
		IF_Contato c2 = new Contato("Walter","8888-0000");
		
		if (agenda.adicionaContato(c2))
			prln("Contato adicionado com sucesso");
		else
			prln("Contato já existe");

		// tenta repetir um numero
		IF_Contato c3 = new Contato("Jose","9999-0000");
		
		if (agenda.adicionaContato(c3))
			prln("Contato adicionado com sucesso");
		else
			prln("Contato já existe\n");
		
		prln("Buscando por 9999-0001....");
		prln(agenda.getContatoPorTelefone("9999-0001") != null ? agenda.getContatoPorTelefone("9999-0001").toString() : "Contato não encontrado");
		
		prln("Buscando por 9999-0000....");
		prln(agenda.getContatoPorTelefone("9999-0000").toString());
		
		prln(agenda.removeContato("9999-0000") ? "Contato removido com sucesso":"Contato não removido");
		prln(agenda.removeContato("9999-0500") ? "Contato removido com sucesso":"Contato não removido");
	}
}
