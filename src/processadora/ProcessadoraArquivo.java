package processadora;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import leitura.LeituraArquivo;
import model.domain.ClienteImportacao;
import model.domain.ImportacaoDefault;
import model.domain.LoteImportacao;
import model.domain.PlasticoImportacao;


	public class ProcessadoraArquivo{

		private IProcessadoraDefault  processadora;
		
		public ProcessadoraArquivo(IProcessadoraDefault processadora) {
			this.processadora = processadora;
		}
		
		public LoteImportacao getLoteProcessado() {
			return this.processadora.getLote();
		}
		
		public List<ImportacaoDefault> processaArquivo(String arquivo) throws IOException, ParseException, FileNotFoundException {
			
			List<String> listaString = lerArquivo(arquivo);
			
			List<ImportacaoDefault> lista = new ArrayList<>();
			processadora.processaLote(listaString,arquivo);
			for (String linha : listaString) {
				lista.add(processadora.getLinha(linha));
			}
			return lista;
		}

		private List<String> lerArquivo(String arquivo) throws FileNotFoundException, IOException {
			LeituraArquivo leitura = new LeituraArquivo();
			List<String> listaString = leitura.lerArquivo(arquivo);
			return listaString;
		}

	
}
