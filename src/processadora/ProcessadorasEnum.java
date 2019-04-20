package processadora;

public enum ProcessadorasEnum {
	CLIENTE("Cliente",new ProcessadoraCliente()), CONTA("Conta",new ProcessadoraConta()), TRANSACAO("Transacao",new ProcessadoraTransacao()),
	PLASTICO("Plastico",new ProcessadoraPlastico());

	private String arquivo;
	private IProcessadoraDefault processadora;

	ProcessadorasEnum(String arquivo,IProcessadoraDefault processadora) {
		this.arquivo = arquivo;
		this.processadora = processadora;
	}
	
	public static IProcessadoraDefault getProcessadoraByArquivo(String arquivo) {
		for(ProcessadorasEnum processadoraEnum : ProcessadorasEnum.values()) {
			if(arquivo.contains(processadoraEnum.arquivo)) {
				return processadoraEnum.processadora;
			}
		}
		
		return null;
	}

}
