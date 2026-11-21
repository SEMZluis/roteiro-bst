public class BstAsserts {

    public void testHeight() {
        BST bst = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;
        assert bst.height() == -1;

        bst.add(10);
        assert !bst.isEmpty();
        assert bst.size() == 1;
        assert bst.height() == 0;

        bst.add(20);
        assert bst.height() == 1;

        bst.add(30);
        assert bst.height() == 2;
        bst.add(5);
        assert bst.height() == 2;
        bst.add(6);
        assert bst.height() == 2;
        bst.add(1);
        assert bst.height() == 3;
    }
    
    public void testIsEmpty() {
        BST bst = new BST();
        assert bst.isEmpty();
        
        bst.add(1);
        assert !bst.isEmpty();
        bst.add(2);
        assert !bst.isEmpty();
        bst.remove(2);
        assert !bst.isEmpty();
        bst.remove(1);
        assert bst.isEmpty();
    }

    public void testAdd() {
        BST bst = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;

        bst.add(10);
        assert !bst.isEmpty();
        assert bst.size() == 1;

        bst.add(15);
        assert !bst.isEmpty();
        assert bst.size() == 2; 
    }

    public static void main(String[] args) {
        BstAsserts t = new BstAsserts();
        // t.testIsEmpty();
        t.testAdd();
        t.testHeight();
        System.out.println("Todos os testes passaram.");
    }

}
