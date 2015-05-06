public class Contato implements IF_Contato {
	
	// atributos
	private String nome;
	private String telefone;

	/**
	 * Método construtor simples
	 */
	public Contato(){
		this.nome 		= null;
		this.telefone 	= null;
	}
	
	/**
	 * Método construtor completo
	 * @param _nome String do nome do contato
	 * @param _telefone String do telefone do contato
	 */
	public Contato(String _nome, String _telefone) {
		this.nome 		= _nome;
		this.telefone 	= _telefone;
	}

	/**
	 * Método que devolve o nome do contato
	 * @return Nome do contato
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Método que devolve o telefone do contato
	 * @return Telefone do contato
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Método que seta o nome do contato
	 * @param _nome String do nome do contato
	 */
	public void setNome(String _nome) {
		this.nome = _nome;
	}

	/**
	 * Método que seta o telefone do contato
	 * @param _telefone String do telefone do contato
	 */
	public void setTelefone(String _telefone) {
		this.telefone = _telefone;
	}

	/**
	 * Método toString
	 * @return String
	 */
	public String toString() {
		return "Contato nome: " + nome + ", telefone: " + telefone;
	}

	/**
	 * Método equals
	 * @return boolean
	 */
	public boolean equals(Object obj){
		return ((IF_Contato)obj).getTelefone().equals(this.telefone);
	}
	
	/*public static void main(String args[]){
		IF_Contato[] c = new IF_Contato[3];
		
		c[0] = new Contato();
		c[0].setNome("Eduardo");
		c[0].setTelefone("9999-0000");
		
		c[1] = new Contato();
		c[1].setNome("Camila");
		c[1].setTelefone("8888-0000");
		
		c[2] = new Contato();
		c[2].setNome("Edu");
		c[2].setTelefone("9999-0000");
		
		System.out.println(c[0].equals(c[1]));
		System.out.println(c[0].equals(c[2]));
	}*/
}
