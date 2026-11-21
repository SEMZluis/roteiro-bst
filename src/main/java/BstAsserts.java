public class BstAsserts {
    
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

    public static void main(String[] args) {
        BstAsserts t = new BstAsserts();
        t.testIsEmpty();
    }

}
