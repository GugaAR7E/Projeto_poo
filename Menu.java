import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;


public class Menu {

    Scanner entrada = new Scanner(System.in);
    Impressora impressora = new Impressora();

    public void executarMenu() {

        int opcao;

        do {
            System.out.println("\n SISTEMA IMPRESSORA ELGIN ");
            System.out.println("1 - Configurar conexão");
            System.out.println("2 - Abrir conexão");
            System.out.println("3 - Fechar conexão");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir código de barras");
            System.out.println("7 - Imprimir XML SAT");
            System.out.println("8 - Imprimir XML de cancelamento SAT");
            System.out.println("9 - Abrir gaveta");
            System.out.println("10 - Sinal sonoro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Tipo de conexão:");
                    System.out.println("1 - USB");
                    System.out.println("2 - Serial");
                    System.out.println("3 - Rede");
                    System.out.println("4 - Bluetooth");

                    System.out.print("Escolha: ");
                    String tipo = entrada.nextLine();

                    System.out.print("Modelo da impressora (i8 ou i9): ");
                    String modelo = entrada.nextLine();

                    System.out.print("Conexão (USB, COM2 ou IP): ");
                    String conexao = entrada.nextLine();

                    System.out.print("Parâmetro: ");
                    int param = entrada.nextInt();
                    entrada.nextLine();

                    impressora.configurarConexao(tipo, modelo, conexao, param);
                    break;
                case 2:
                    impressora.AbreConexaoImpressora();
                    break;

                case 3:
                    impressora.FechaConexaoImpressora();
                    break;

                case 4:
                    if (impressora.verificarConexao()) {
                        System.out.print("Digite o texto: ");
                        impressora.ImpressaoTexto(entrada.nextLine());
                    }
                    break;

                case 5:
                    if (impressora.verificarConexao()) {
                        System.out.print("Digite os dados do QR Code: ");
                        impressora.ImpressaoQRCode(entrada.nextLine());
                    }
                    break;

                case 6:
                    if (impressora.verificarConexao()) {
                        impressora.ImpressaoCodigoBarras();
                    }
                    break;

                case 7:
                    if (impressora.verificarConexao()) {
                        imprimirXML();
                    }
                    break;

                case 8:
                    if (impressora.verificarConexao()) {
                        imprimirXMLCancelamento();
                    }
                    break;

                case 9:
                    impressora.AbreGaveta();
                    break;

                case 10:
                    impressora.SinalSonoro();
                    break;

                case 0:
                    System.out.println("encerrando o sistema...");
                    break;

                default:
                    System.out.println("opção inválida");
            }

        } while (opcao != 0);
    }

    private void imprimirXML() {

        String caminho = "XMLSAT.xml";

        try (FileInputStream arquivo = new FileInputStream(caminho)) {

            impressora.ImprimeXMLSAT(caminho);

        } catch (FileNotFoundException e) {
            System.out.println("Erro: arquivo XML SAT não encontrado!");

        } catch (Exception e) {
            System.out.println("Erro ao acessar o arquivo XML SAT.");
        }
    }

    private void imprimirXMLCancelamento() {

        String caminho = "CANC_SAT.xml";

        try (FileInputStream arquivo = new FileInputStream(caminho)) {

            impressora.ImprimeXMLCancelamentoSAT(caminho);

        } catch (FileNotFoundException e) {
            System.out.println("Erro: arquivo XML de cancelamento não encontrado!");

        } catch (Exception e) {
            System.out.println("Erro ao acessar o arquivo XML de cancelamento.");
        }
    }
}
