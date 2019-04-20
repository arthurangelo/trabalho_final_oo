package DAO;

import java.sql.SQLException;

import model.domain.ImportacaoDefault;

public abstract class IDAO {
	public abstract void save(ImportacaoDefault importacao) throws SQLException ;
}
