import java.util.ArrayList;
import java.util.Collection;

public interface IF_Agenda {
	public boolean adicionaContato(IF_Contato _contato);
	public IF_Contato getContatoPorTelefone(String _telefone);
	public ArrayList<IF_Contato> getContatoPorIniciaisNome(String _iniciais);
	public boolean removeContato(String _telefone);
	public Collection<IF_Contato> listContato();
	
	// diagrama http://yuml.me/edit/1da01c78
}
