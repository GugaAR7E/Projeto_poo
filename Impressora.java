
public class Impressora {

    private String tipoConexao;
    private String modelo;
    private String conexao;
    private int parametro;

    private boolean conexaoAberta = false;

    private static final String ASSINATURA_QR_CODE =
            "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQsE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDdGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+ZfO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

    public void configurarConexao(String tipoConexao, String modelo, String conexao, int parametro) {

        this.tipoConexao = tipoConexao;
        this.modelo = modelo;
        this.conexao = conexao;
        this.parametro = parametro;

        System.out.println("Configurações salvas com sucesso!");
    }

    public void AbreConexaoImpressora() {

        try {

            int ret = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(
                    Integer.parseInt(tipoConexao),
                    modelo,
                    conexao,
                    parametro
            );

            if (ret == 0) {
                conexaoAberta = true;
                System.out.println("Conexão aberta com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Retorno: " + ret);
            }

        } catch (LinkageError e) {
            System.out.println("Erro: não foi possível carregar a DLL da impressora.");
        } catch (Exception e) {
            System.out.println("Erro ao abrir conexão: " + e.getMessage());
        }
    }

    public void FechaConexaoImpressora() {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

                if (ret == 0) {
                    conexaoAberta = false;
                    System.out.println("Conexão fechada com sucesso!");
                } else {
                    System.out.println("Erro ao fechar conexão. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void ImpressaoTexto(String texto) {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.ImpressaoTexto(texto, 0, 0, 0);

                if (ret >= 0) {
                    ImpressoraDLL.INSTANCE.Corte(5);
                    System.out.println("Texto impresso com sucesso!");
                } else {
                    System.out.println("Erro ao imprimir texto. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void ImpressaoQRCode(String dados) {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.ImpressaoQRCode(dados, 4, 2);

                if (ret == 0) {
                    ImpressoraDLL.INSTANCE.Corte(5);
                    System.out.println("QR Code impresso com sucesso!");
                } else {
                    System.out.println("Erro ao imprimir QR Code. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void ImpressaoCodigoBarras(String dados) {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, dados, 100, 2, 4);

                if (ret == 0) {
                    ImpressoraDLL.INSTANCE.Corte(5);
                    System.out.println("Código de barras impresso com sucesso!");
                } else {
                    System.out.println("Erro ao imprimir código de barras. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void ImprimeXMLSAT(String caminho) {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.ImprimeXMLSAT("path=" + caminho, 0);

                if (ret == 0) {
                    System.out.println("XML SAT impresso com sucesso!");
                } else {
                    System.out.println("Erro ao imprimir XML SAT. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void ImprimeXMLCancelamentoSAT(String caminho) {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(
                        "path=" + caminho,
                        ASSINATURA_QR_CODE,
                        0
                );

                if (ret == 0) {
                    System.out.println("XML de cancelamento impresso com sucesso!");
                } else {
                    System.out.println("Erro ao imprimir XML de cancelamento. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void AbreGaveta() {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.AbreGavetaElgin(0, 1, 5);

                if (ret == 0) {
                    System.out.println("Gaveta aberta com sucesso!");
                } else {
                    System.out.println("Erro ao abrir gaveta. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }

    public void SinalSonoro() {

        if (conexaoAberta == true) {

            try {

                int ret = ImpressoraDLL.INSTANCE.SinalSonoro(1, 50, 5);

                if (ret == 0) {
                    System.out.println("Sinal sonoro emitido com sucesso!");
                } else {
                    System.out.println("Erro ao emitir sinal sonoro. Retorno: " + ret);
                }

            } catch (LinkageError e) {
                System.out.println("Erro: não foi possível carregar a DLL.");
            }

        } else {
            System.out.println("Não existe uma conexão em aberto.");
        }
    }
}
