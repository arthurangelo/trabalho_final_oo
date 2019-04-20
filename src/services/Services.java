package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import DAO.IDAO;
import DAO.LoteDAO;
import DAO.PlasticoDAO;
import DAO.TransacaoDAO;
import model.domain.ClienteImportacao;
import model.domain.ContaImportacao;
import model.domain.ImportacaoDefault;
import model.domain.LoteImportacao;
import model.domain.PlasticoImportacao;
import model.domain.TransacaoImportacao;

public class Services {
	
	public static List<String> getArquivosProcessar(){
		List<String> arquivos = new ArrayList<>();
		String dir = System.getProperty("user.dir") + "/arquivos/";
		
		arquivos.add(dir + "Cliente_20140220.txt");
		arquivos.add(dir + "Conta_20140220.txt");
		arquivos.add(dir + "Plastico_20140220.txt");
		arquivos.add(dir + "Transacao_20140220.txt");
		
		return arquivos;
	}
	
	public static void save(ImportacaoDefault importacao) {
		try {
			if(importacao instanceof ClienteImportacao) {
				ClienteDAO.save(importacao);
			}
			else if(importacao instanceof TransacaoImportacao) {
				TransacaoDAO.save(importacao);
			}
			else if(importacao instanceof ContaImportacao) {
				ContaDAO.save(importacao);
			}
			else if(importacao instanceof PlasticoImportacao) {
				PlasticoDAO.save(importacao);
			}
			else if(importacao instanceof LoteImportacao) {
				LoteDAO.save(importacao);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
