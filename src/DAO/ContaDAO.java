package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.domain.ClienteImportacao;
import model.domain.ContaImportacao;
import model.domain.ImportacaoDefault;

public class ContaDAO extends DefaultDAO {
	private static PreparedStatement dao;

	public  void save(ImportacaoDefault importacao) throws SQLException {
		String sql = "	INSERT INTO dbimportacao.tbconta (nrocta,cpfcli,vlrlim,diaven) VALUES (?,?,?,?)";
		dao = Conexao.getStatement(sql);
		try {

			ContaImportacao importacao1 = (ContaImportacao) importacao;

			dao.setInt(1, importacao1.getNumercoConta());
			dao.setString(2, importacao1.getCpf());
			dao.setDouble(3, importacao1.getValorLimite());
			dao.setInt(4, importacao1.getDtVencimento());
			
			dao.executeUpdate();
			System.out.println("Cartao salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
