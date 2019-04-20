package processadora;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.domain.ContaImportacao;
import model.domain.LoteImportacao;
import model.domain.PlasticoImportacao;

public class ProcessadoraPlastico implements IProcessadoraDefault {
	
	private LoteImportacao loteImportacao;

	@Override
	public PlasticoImportacao getLinha(String linha) throws ParseException {
		PlasticoImportacao plastico = new PlasticoImportacao();
		plastico.setConta(new Integer(linha.substring(1,8)));
		plastico.setCpf(linha.substring(38,49));
		plastico.setNomeCartao(linha.substring(8,37));
		plastico.setNumeroPlasticoGerado(linha.substring(49,56));
		return plastico;
	}
	
	@Override
	public List<String> processaLote(List<String> linhas, String arquivo) {
		loteImportacao = new LoteImportacao(linhas.get(0), arquivo );
		linhas.remove(0);
		return linhas;
	}

	@Override
	public LoteImportacao getLote() {
		return this.loteImportacao;
	}

	@Override
	public void setLoteImportacao(LoteImportacao lote) {
		this.loteImportacao = lote;
		
	}
}
