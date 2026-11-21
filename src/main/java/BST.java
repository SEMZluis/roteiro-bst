import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        // Crio o meu nó logo de cara (considerando que não haverá elementos repetidos na árvore)
        Node newNode = new Node(element);
        this.size++;

        // Tenho que verificar se já tem algum elemento na árvore. Se não tiver, o que tá chegando vai ser minha raiz.
        
        if (isEmpty()) {
            this.root = newNode;
        } else {

            // Como não tá vazio, preciso procurar um canto pra botar esse número.
            // Vou percorrer minha árvore.
            Node aux = this.root;

            while (aux != null) {
            
                // Vejo primeiro se o número deve estar a esquerda do meu nó. Se não tiver ninguém na esquerda, já boto ele lá.
                if (element < aux.value) {
                    if (aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    // Tendo esquerda, vou ver se meu número é maior ou menor do que este nó.
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }

        }
    }

    /**
     * Implementação da remoção de um elemento de uma árvore binária de pesquisa.
     * @param element o valor a ser removido da árvore.
     */
    public void remove(int element) {

    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        return null;
    }
    
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    private int height(Node current) {
        if (current == null) return -1;
        int esq = height(current.left) + 1;
        int dir = height(current.right) + 1;
        
        if (esq > dir) return esq;
        return dir;
    }

    public boolean equals(BST outra) {
        return false;
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return -1;
    }

    

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }
    
}
