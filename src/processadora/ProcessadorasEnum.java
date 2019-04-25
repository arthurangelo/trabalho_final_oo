package processadora;

import DAO.ClienteDAO;
import DAO.DefaultDAO;
import DAO.*;

public enum ProcessadorasEnum {
	CLIENTE("Cliente", new ProcessadoraCliente(), new ClienteDAO()),
	CONTA("Conta", new ProcessadoraConta(), new ContaDAO()), 
	TRANSACAO("Transacao", new ProcessadoraTransacao(),new TransacaoDAO()),
	PLASTICO("Plastico", new ProcessadoraPlastico(),new PlasticoDAO());

	private String arquivo;
	private IProcessadoraDefault processadora;
	private DefaultDAO dao;

	ProcessadorasEnum(String arquivo, IProcessadoraDefault processadora, DefaultDAO dao) {
		this.arquivo = arquivo;
		this.processadora = processadora;
		this.dao = dao;
	}

	public static IProcessadoraDefault getProcessadoraByArquivo(String arquivo) {
		for (ProcessadorasEnum processadoraEnum : ProcessadorasEnum.values()) {
			if (arquivo.contains(processadoraEnum.arquivo)) {
				return processadoraEnum.processadora;
			}
		}

		return null;
	}

	public static DefaultDAO getDAObyArquivo(String arquivo) {
		for (ProcessadorasEnum processadoraEnum : ProcessadorasEnum.values()) {
			if (arquivo.contains(processadoraEnum.arquivo)) {
				return processadoraEnum.dao;
			}
		}

		return null;
	}

}
