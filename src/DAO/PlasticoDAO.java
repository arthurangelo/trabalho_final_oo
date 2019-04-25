package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.domain.ImportacaoDefault;
import model.domain.PlasticoImportacao;

public class PlasticoDAO extends DefaultDAO{
	private static PreparedStatement dao;

	public  void save(ImportacaoDefault importacao) throws SQLException {
		String sql = "INSERT INTO tbplastico (nropla,nompla,cpfpla,nrocta) VALUES (?,?,?,?)";
		dao = Conexao.getStatement(sql);
		try {

			PlasticoImportacao importacao1 = (PlasticoImportacao) importacao;

			dao.setString(1, importacao1.getNumeroPlasticoGerado());
			dao.setString(2, importacao1.getNomeCartao());
			dao.setString(3, importacao1.getCpf());
			dao.setInt(4, importacao1.getConta());
			
			dao.executeUpdate();
			System.out.println("Plastico salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
