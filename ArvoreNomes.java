// Classe que representa um nó da árvore
class No {
    String nome;
    No esquerda, direita;
    int repeticoes; // desafio extra: contar nomes repetidos

    No(String nome) {
        this.nome = nome;
        this.repeticoes = 1;
    }
}

// Classe principal da árvore de nomes
class ArvoreNomes {
    No raiz;

    // Inserir nome na árvore
    void inserir(String nome) {
        raiz = inserirRecursivo(raiz, nome);
    }

    private No inserirRecursivo(No atual, String nome) {
        if (atual == null) {
            return new No(nome);
        }

        int comparacao = nome.compareToIgnoreCase(atual.nome);

        if (comparacao < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, nome);
        } else if (comparacao > 0) {
            atual.direita = inserirRecursivo(atual.direita, nome);
        } else {
            // nome igual → soma repetição
            atual.repeticoes++;
        }

        return atual;
    }

    // Listar nomes em ordem alfabética (in-order)
    void listarEmOrdem() {
        System.out.println("\nNomes em ordem alfabética (A → Z):");
        listarEmOrdemRec(raiz);
        System.out.println();
    }

    private void listarEmOrdemRec(No atual) {
        if (atual != null) {
            listarEmOrdemRec(atual.esquerda);
            System.out.println(atual.nome + " (" + atual.repeticoes + ")");
            listarEmOrdemRec(atual.direita);
        }
    }

    // Listar nomes em ordem decrescente (reversa)
    void listarReversa() {
        System.out.println("\nNomes em ordem decrescente (Z → A):");
        listarReversaRec(raiz);
        System.out.println();
    }

    private void listarReversaRec(No atual) {
        if (atual != null) {
            listarReversaRec(atual.direita);
            System.out.println(atual.nome + " (" + atual.repeticoes + ")");
            listarReversaRec(atual.esquerda);
        }
    }

    // Buscar um nome na árvore
    boolean buscar(String nome) {
        return buscarRec(raiz, nome);
    }

    private boolean buscarRec(No atual, String nome) {
        if (atual == null) {
            return false;
        }

        int comparacao = nome.compareToIgnoreCase(atual.nome);

        if (comparacao == 0) {
            return true;
        } else if (comparacao < 0) {
            return buscarRec(atual.esquerda, nome);
        } else {
            return buscarRec(atual.direita, nome);
        }
    }

    // Contar quantos nomes estão armazenados (somando repetições)
    int contarNomes() {
        return contarRec(raiz);
    }

    private int contarRec(No atual) {
        if (atual == null) return 0;
        return atual.repeticoes + contarRec(atual.esquerda) + contarRec(atual.direita);
    }
}
