package DAO;

import java.sql.SQLException;

import model.domain.ImportacaoDefault;

 public abstract class DefaultDAO  {
	public  abstract  void save(ImportacaoDefault importacao)throws SQLException;
}
