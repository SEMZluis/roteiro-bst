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
    
    public void testMin() {
        BST bst = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;
        
        assert bst.min() == null;

        bst.add(10);
        assert bst.min().value == 10;

        bst.add(20);
        assert bst.min().value == 10;

        bst.add(5);
        assert bst.min().value == 5;

        bst.add(1);
        assert bst.min().value == 1;

        bst.add(3);
        assert bst.min().value == 1;
    }

    public void testMax() {
        BST bst = new BST();
        assert bst.isEmpty();
        assert bst.size() == 0;

        assert bst.max() == null;

        bst.add(10);
        assert bst.max().value == 10;

        bst.add(5);
        assert bst.max().value == 10;

        bst.add(20);
        assert bst.max().value == 20;

        bst.add(30);
        assert bst.max().value == 30;

        bst.add(25);
        assert bst.max().value == 30;
    }

    public void testSucessor() {
        BST bst = new BST();
        assert bst.isEmpty();

        assert bst.sucessor(null) == null;

        bst.add(15);
        bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(12);
        bst.add(17);
        bst.add(25);

        assert bst.sucessor(bst.search(15)).value == 17; 
        assert bst.sucessor(bst.search(10)).value == 12; 
        assert bst.sucessor(bst.search(20)).value == 25;  

        assert bst.sucessor(bst.search(12)).value == 15;  
        assert bst.sucessor(bst.search(5)).value == 10;  
        assert bst.sucessor(bst.search(17)).value == 20;  

        assert bst.sucessor(bst.search(25)) == null;

        assert bst.search(100) == null;
        assert bst.sucessor(bst.search(100)) == null;
    }

    public void testPredecessor() {
        BST bst = new BST();
        assert bst.isEmpty();

        assert bst.predecessor(null) == null;

        bst.add(15);
        bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(12);
        bst.add(17);
        bst.add(25);

        assert bst.predecessor(bst.search(15)).value == 12; 
        assert bst.predecessor(bst.search(10)).value == 5;  
        assert bst.predecessor(bst.search(20)).value == 17; 

        assert bst.predecessor(bst.search(12)).value == 10;
        assert bst.predecessor(bst.search(17)).value == 15;
        assert bst.predecessor(bst.search(25)).value == 20; 

        assert bst.predecessor(bst.search(5)) == null;

        assert bst.search(100) == null;
        assert bst.predecessor(bst.search(100)) == null;
    }

    public void testRemove() {
        BST bst = new BST();

        bst.remove(10);
        assert bst.isEmpty();
        assert bst.size() == 0;

        bst.add(10);
        bst.remove(10);
        assert bst.isEmpty();
        assert bst.size() == 0;
        assert bst.search(10) == null;

        bst.add(15);
        bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(12);
        bst.add(17);
        bst.add(25);
        bst.add(30);

        assert bst.size() == 8;

        bst.remove(5);
        assert bst.search(5) == null;
        assert bst.size() == 7;
        assert bst.search(10) != null; 

        bst.remove(25);
        assert bst.search(25) == null;
        assert bst.size() == 6;
        assert bst.search(30) != null; 
        assert bst.search(20) != null; 

        bst.remove(20);
        assert bst.search(20) == null;
        assert bst.size() == 5;
        assert bst.search(17) != null; 
        assert bst.search(30) != null; 

        bst.remove(15);
        assert bst.search(15) == null;
        assert bst.size() == 4;
        assert bst.search(17) != null;
        assert bst.search(10) != null;
        assert bst.search(30) != null;
        
        assert bst.search(12) != null;

        bst.remove(100);
        assert bst.size() == 4;
    }

    public static void main(String[] args) {
        BstAsserts t = new BstAsserts();
        t.testIsEmpty();
        t.testHeight();
        t.testAdd();
        t.testSearch();
        t.testMin();
        t.testMax();
        t.testSucessor();
        t.testPredecessor();
        t.testRemove();
        System.out.println("Todos os testes passaram.");
    }

}
