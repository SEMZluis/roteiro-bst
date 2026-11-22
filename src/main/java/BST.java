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
        Node node = search(element);
        if (node != null) remove(node);
    }


    private void remove(Node toRemove) {
        if (toRemove == null) return;

        if (toRemove.isLeaf()) {
            if (this.root == toRemove) this.root = null;
            else {
                Node parent = toRemove.parent;
                if (toRemove.value < parent.value) parent.left = null;
                else parent.right = null;
            }
        } else if (toRemove.hasOnlyOneChild()) {
            if (toRemove == this.root) {
                if (toRemove.hasLeftChild()) this.root = toRemove.left;
                else this.root = toRemove.right;
                this.root.parent = null;
            } else {
                Node parent = toRemove.parent;

                if (toRemove.value < parent.value) {
                    if (toRemove.hasLeftChild()) parent.left = toRemove.left;
                    else parent.left = toRemove.right;
                    parent.left.parent = parent;
                } else {
                    if (toRemove.hasLeftChild()) parent.right = toRemove.left;
                    else parent.right = toRemove.right;
                    parent.right.parent = parent;
                }
            }
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        Node aux = this.root;
        
        while (aux != null) {
            if (aux.value == element) return aux;
            if (element < aux.value) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
        }
        
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

    /**
     * Implementa recursivamente a função que busca o menor valor da árvore.
     * @return o menor valor armazenado.
     */
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }

    private Node min(Node current) {
        if (current.left == null) return current;
        return min(current.left);
    }   

    /**
     * Implementa recursivamente a função que busca o menor valor da árvore
     * @return o maior valor armazenado.
     */
    public Node max() {
        if (isEmpty()) return null;
        return max(this.root);
    }

    private Node max(Node current) {
        if (current.right == null) return current;
        return max(current.right);
    }

    /**
     * Busca o menor valor imediatamente maior ao elemento passado.
     * @param element elemento a ser buscado na árvore e comparado em seguida.
     * @return o sucessor do elemento se houver e nulo se não.
     */
    public Node sucessor(Node node) {
        if (isEmpty() || node == null) return null;

        if (node.right != null) {
            return min(node.right);
        } else {
            Node aux = node.parent;

            while (aux.parent != null && aux.value < node.value) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public Node predecessor(Node node) {
        if (isEmpty() || node == null) return null;

        if (node.left != null) {
            return max(node.left);
        } else {
            Node aux = node.parent;

            while (aux != null && aux.value > node.value) {
                aux = aux.parent;
            }

            return aux;
        }
    }
    
}


class Node {
    int value;
    Node left;
    Node right;
    Node parent;
    
    public Node(int v) {
        this.value = v;
    }

    public boolean hasLeftChild() {
        return this.left != null;
    }

    public boolean hasRightChild() {
        return this.right != null;
    }

    public boolean isLeaf() {
        return !hasLeftChild() && !hasRightChild();
    }

    public boolean hasOnlyOneChild() {
        return (hasLeftChild() && !hasRightChild()) || (!hasLeftChild() && hasRightChild());
    }

}
