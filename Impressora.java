public class Impressora {

    private String tipoConexao;
    private String modelo;
    private String conexao;
    private int parametro;

    private boolean conexaoAberta = false;

    public void configurarConexao(String tipoConexao, String modelo, String conexao, int parametro) {
        this.tipoConexao = tipoConexao;
        this.modelo = modelo;
        this.conexao = conexao;
        this.parametro = parametro;

        System.out.println("Configurações da conexão salvas!");
    }

    public void AbreConexaoImpressora() {
        System.out.println("Abrindo conexão com a impressora");
    }

    public void FechaConexaoImpressora() {
        System.out.println("Fechando conexão com a impressora");
    }

    public void ImpressaoTexto(String texto) {
        System.out.println("Preparando impressão de texto");
    }

    public void ImpressaoQRCode(String dados) {
        System.out.println("Preparando impressão do QR Code");
    }

    public void ImpressaoCodigoBarras(String dados) {
        System.out.println("Preparando impressão do código de barras");
    }

    public void ImprimeXMLSAT(String caminho) {
        System.out.println("Preparando impressão do XML SAT");
    }

    public void ImprimeXMLCancelamentoSAT(String caminho) {
        System.out.println("Preparando impressão do XML de cancelamento SAT");
    }

    public void AbreGaveta() {
        System.out.println("Abrindo gaveta");
    }

    public void SinalSonoro() {
        System.out.println("Emitindo sinal sonoro");
    }
}