package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.domain.ClienteImportacao;
import model.domain.ImportacaoDefault;
import model.domain.TransacaoImportacao;

public class TransacaoDAO extends DefaultDAO {
private static PreparedStatement dao;
	
	public  void save(ImportacaoDefault importacao) throws SQLException {
		
		String sql = "INSERT INTO tbtransacao (nrocta,nropla,vlrtra,dattra,codloj) values (?,?,?,?,?)";
		dao = Conexao.getStatement(sql);
		try {
			
			TransacaoImportacao importacao1 = (TransacaoImportacao) importacao;
			
			dao.setInt(1, importacao1.getNumeroConta());
			dao.setInt(2, importacao1.getNumeroPlastico());
			dao.setDouble(3, importacao1.getValorTransacao());
			
			java.util.Date data = importacao1.getDataTransacao();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			dao.setString(4, dateFormat.format(data));
			
			dao.setInt(5, importacao1.getCodigoEstabelecimento());


			dao.executeUpdate();
			System.out.println("Transacao salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
