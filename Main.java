public class Main {
    public static void main(String[] args) {
        ArvoreNomes arvore = new ArvoreNomes();

        // Inserir nomes
        arvore.inserir("Maria");
        arvore.inserir("Ana");
        arvore.inserir("João");
        arvore.inserir("Pedro");
        arvore.inserir("Bruno");
        arvore.inserir("Carla");
        arvore.inserir("João"); // nome repetido

        // Listar nomes em ordem alfabética
        arvore.listarEmOrdem();

        // Listar nomes em ordem decrescente
        arvore.listarReversa();

        // Buscar nomes
        System.out.println("\nBusca de nomes:");
        System.out.println("João existe? " + arvore.buscar("João"));
        System.out.println("Lucas existe? " + arvore.buscar("Lucas"));

        // Contar quantos nomes foram inseridos (com repetições)
        System.out.println("\nTotal de nomes armazenados (contando repetições): " + arvore.contarNomes());
    }
}

