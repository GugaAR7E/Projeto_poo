public class Main {

    public static void main(String[] args) {

        Usuario usuario = new Usuario("admin", "1234");

        if (usuario.fazerLogin()) {

            Menu menu = new Menu();

            menu.executarMenu();

        } else {

            System.out.println("Programa encerrado");

        }
    }
}