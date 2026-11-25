Documentação de projeto

# **🖨️ Sistema de Controle de Impressora Elgin**

## **📘 Sobre o Projeto**

Esse projeto foi desenvolvido para realizar a comunicação com as impressoras térmicas **Elgin i8/i9**, utilizando a biblioteca `E1_Impressora01.dll`. O sistema conta com autenticação por login, permitindo até 3 tentativas, além de um menu interativo com 12 funcionalidades de impressão e gerenciamento da impressora.

O desenvolvimento  foi realizado como atividade prática da disciplina de **Programação Orientada a Objetos**, aplicando conceitos de Java e integração com bibliotecas externas.

## **🧰 Tecnologias Utilizadas**

- **Java 17**
- **IntelliJ IDEA**
- **JNA 5.15.0** (integração entre Java e DLL)
- **DLL E1_Impressora01** (biblioteca de comunicação da Elgin)
- **Impressora térmica Elgin i8 ou i9**

## **📁 Estrutura do Projeto**

```
/src
   Main.java          → Inicialização do sistema, login e menu principal
   Usuario.java       → Armazena e valida as credenciais de acesso
   Impressora.java    → Gerencia a conexão e executa os comandos da impressora
   ImpressoraDLL.java → Interface JNA disponibilizada pela Elgin
/Bibliotecas E1 Impressora → Bibliotecas DLL da Elgin (x64 e x86)
/libs Java                  → jna-5.15.0.jar
XMLSAT.xml                  → Arquivo XML de exemplo para venda
CANC_SAT.xml                → Arquivo XML de exemplo para cancelamento
```

## **⚙️ Instalação e Execução**

### **1. Baixar o projeto**

1. Entre no repositório do GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia os arquivos para uma pasta de sua preferência.

### **2. Executar pelo IntelliJ IDEA**

1. Acesse **File → Open** e selecione a pasta do projeto.
2. Em **File → Project Structure → Libraries**, verifique se o arquivo `jna-5.15.0.jar` está configurado.
3. Em **Run → Edit Configurations**, confira se o *Working directory* aponta para a pasta principal do projeto.
4. Ligue e conecte a impressora ao computador.
5. Abra o arquivo `Main.java` e pressione ▶️ **Run**.

### **Abrir pelo Visual Studio Code**

1. Abra a pasta raiz do projeto, onde estão localizadas as pastas `src`, `libs Java` e `Bibliotecas E1 Impressora`.
2. Instale as extensões **Extension Pack for Java** e **Debugger for Java**.
3. O JNA é configurado pelo arquivo `.vscode/settings.json`. Caso necessário, utilize o comando **Java: Clean Java Language Server Workspace** e abra novamente a pasta.
4. Acesse `src/Main.java` e clique em **Run**.

## **🔐 Login**

- Usuário: `admin`
- Senha: `1234`
- Limite de 3 tentativas de acesso.

## **📋 Funcionalidades do Menu**

| Opção | Descrição                                                             |
| ----- |-----------------------------------------------------------------------|
| 1     | Definir as configurações de conexão (tipo, modelo, porta e parâmetro) |
| 2     | Abrir conexão com a impressora                                        |
| 3     | Fechar a conexão com a impressora                                     |
| 4     | Impressão de textos                                                   |
| 5     | Gerar e imprimir QR Codes                                             |
| 6     | Imprimir códigos de barras                                            |
| 7     | Imprimir XML SAT (cupom de venda)                                     |
| 8     | Imprimir XML de cancelamento SAT                                      |
| 9     | Abertura da gaveta                                                    |
| 10    | Emitir sinal sonoro (bip)                                             |
| 0     | Encerrar o programa                                                   |

Caso a conexão não esteja ativa, as opções de 3 a 12 exibem a mensagem "Conexão fechada. Abra a conexão antes." e retornam ao menu principal sem solicitar informações adicionais.

## **🧪 Testes Realizados**

- Verificação do bloqueio do sistema após 3 tentativas de login incorretas.
- Validação do acesso com credenciais corretas na primeira e na segunda tentativa.
- Teste de execução das funcionalidades sem conexão ativa, verificando a exibição da mensagem de aviso.
- Tratamento de entradas inválidas, como letras em campos que exigem valores numéricos, evitando o encerramento inesperado do programa.
- Testes práticos de abertura e fechamento da conexão.
- Testes de impressão de textos, QR Codes, códigos de barras e arquivos XML.
- Verificação do funcionamento do bip e da abertura da gaveta diretamente na impressora.

## **📚 Documentação Adicional**

- Manual de utilização da impressora Elgin.
- [Documentação oficial do SDK E1_Impressora](https://elgindevelopercommunity.github.io/group___m1.html?utm_source=chatgpt.com).

## **👥 Autores**

- Arthur Ulloa
- Felipe Rocha
- Gustavo Batista
- Gustavo Pereira
- Samuel Carvalho

