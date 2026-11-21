public class BstAsserts {
    
    public void testIsEmpty() {
        BST bst = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;
        assert bst.height() == -1;
        
        bst.add(1);
        assert !bst.isEmpty();
        bst.add(2);
        assert !bst.isEmpty();
        bst.remove(2);
        assert !bst.isEmpty();
        bst.remove(1);
        assert bst.isEmpty();
    }

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

    public void testSearch() {
        BST bst  = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;
        assert bst.height() == -1;

        assert bst.search(10) == null;
        
        bst.add(10);
        assert bst.search(10).value == 10;

        bst.add(20);
        bst.add(5);
        assert bst.search(20).value == 20;
        assert bst.search(5).value == 5;
    }

    public static void main(String[] args) {
        BstAsserts t = new BstAsserts();
        // t.testIsEmpty();
        t.testHeight();
        t.testAdd();
        t.testSearch();
        System.out.println("Todos os testes passaram.");
    }

}
