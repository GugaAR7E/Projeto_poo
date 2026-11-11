import java.util.Scanner;

public class Usuario {

    String login;
    String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean verificarLogin(String loginDigitado, String senhaDigitada) {
        return login.equals(loginDigitado) && senha.equals(senhaDigitada);
    }

    public boolean fazerLogin() {

        Scanner entrada = new Scanner(System.in);

        int tentativas = 3;

        while (tentativas > 0) {

            System.out.print("Digite seu login: ");
            String loginDigitado = entrada.nextLine();

            System.out.print("Digite sua senha: ");
            String senhaDigitada = entrada.nextLine();

            if (verificarLogin(loginDigitado, senhaDigitada)) {
                System.out.println("login realizado com sucesso");
                return true;
            } else {
                tentativas--;

                System.out.println("Login ou senha incorretos");

                if (tentativas > 0) {
                    System.out.println("tentativas restantes: " + tentativas);
                }
            }
        }

        System.out.println("numero máximo de tentativas atingido");
        return false;
    }
}