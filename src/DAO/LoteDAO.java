package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.domain.ImportacaoDefault;
import model.domain.LoteImportacao;

public class LoteDAO extends DefaultDAO {
	private static PreparedStatement dao;
	public  void save(ImportacaoDefault importacao) throws SQLException {
	String sql = "INSERT INTO tbcontrolerecebimento (tiparq,numlot,dathraprc) values (?,?,?)";
	
	dao = Conexao.getStatement(sql);
	try {
	
		LoteImportacao importacao1 = (LoteImportacao) importacao;
		
		dao.setString(1, importacao1.getArquivo().substring(0,2));
		dao.setInt(2, importacao1.getNumeroLote());

		java.util.Date data = importacao1.getDataImportacao();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		dao.setString(3, dateFormat.format(data));
		



		dao.executeUpdate();
		System.out.println("Lote salvo com sucesso");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
