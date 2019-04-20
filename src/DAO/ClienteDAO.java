package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.domain.ClienteImportacao;
import model.domain.ImportacaoDefault;

public class ClienteDAO {

	private static PreparedStatement dao;

	public static void save(ImportacaoDefault importacao) throws SQLException {
		String sql = "INSERT INTO tbcliente (cpfcli,nomcli,endcli,baicli,cidcli,sigest,datcad) values (?,?,?,?,?,?,?)";
		dao = Conexao.getStatement(sql);
		try {

			ClienteImportacao importacao1 = (ClienteImportacao) importacao;

			dao.setString(1, importacao1.getCpf());
			dao.setString(2, importacao1.getNome());
			dao.setString(3, importacao1.getEndereco());
			dao.setString(4, importacao1.getBairro());
			dao.setString(5, importacao1.getCidade());
			dao.setString(6, importacao1.getEstado());

			java.util.Date data = importacao1.getDataHoraCadastro();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			dao.setString(7, dateFormat.format(data));

			dao.executeUpdate();
			System.out.println("Cliente salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
