package processadora;
import java.text.ParseException;
import java.util.List;
import model.domain.ImportacaoDefault;
import model.domain.LoteImportacao;

public interface IProcessadoraDefault {
	public ImportacaoDefault getLinha(String linha) throws ParseException;
	public List<String> processaLote(List<String> linhas,String arquivo);
	public LoteImportacao getLote();
	public void setLoteImportacao(LoteImportacao lote);
}
