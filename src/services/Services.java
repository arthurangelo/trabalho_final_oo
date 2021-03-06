package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultTextUI;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import DAO.DefaultDAO;
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
	
	public static void save(DefaultDAO dao,ImportacaoDefault importacao) {
		try {
			dao.save(importacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
