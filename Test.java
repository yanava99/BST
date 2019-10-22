public class Test
{
    public static void main(String[] args)
    {
        BST<Double> treeOfDouble = new BST<Double>();
        treeOfDouble.insert(1.);
        treeOfDouble.insert(2.);
        treeOfDouble.insert(0.);
        treeOfDouble.insert(-2.5);
        treeOfDouble.insert(1.4);
        treeOfDouble.insert(50.);
        treeOfDouble.insert(60.);
        //treeOfDouble.delete(2.);

        treeOfDouble.traversalType = BST.TraversalType.LEFTRIGHTROOT;
        System.out.println("ЛПК:");
        treeOfDouble.print();
        treeOfDouble.traversalType = BST.TraversalType.ROOTLEFTRIGHT;
        System.out.println("КЛП:");
        treeOfDouble.print();
        treeOfDouble.traversalType = BST.TraversalType.LEFTROOTRIGHT;
        System.out.println("ЛКП:");
        treeOfDouble.print();

        System.out.println("Количество вершин дерева: " + treeOfDouble.nodeNumber());
        System.out.println("Сумма значений всех вершин дерева: " + treeOfDouble.sum());
        System.out.println("Количество листьев дерева: " + treeOfDouble.leavesNumber());
        System.out.println("Сумма значений всех листьев: " + treeOfDouble.leavesSum());

        System.out.println("Поддерево, вершиной которого является ближайший общий предок для вершин со значениями 2 и 0:");
        treeOfDouble.closestCommonAncestor(treeOfDouble.search(2.),treeOfDouble.search(0.));
        System.out.println("Поддерево, вершиной которого является ближайший общий предок для вершин со значениями 50 и 60:");
        treeOfDouble.closestCommonAncestor(treeOfDouble.search(50.),treeOfDouble.search(60.));
        System.out.println("Поддерево, вершиной которого является ближайший общий предок для вершин со значениями 1.4 и 60:");
        treeOfDouble.closestCommonAncestor(treeOfDouble.search(1.4),treeOfDouble.search(60.));



        BST<MyClass> treeOfMyClass = new BST<MyClass>();
        MyClass my1 = new MyClass(1.);
        treeOfMyClass.insert(my1);
        MyClass my2 = new MyClass(2.);
        treeOfMyClass.insert(my2);
        MyClass my3 = new MyClass(0.);
        treeOfMyClass.insert(my3);
        MyClass my4 = new MyClass(-2.5);
        treeOfMyClass.insert(my4);
        MyClass my5 = new MyClass(1.4);
        treeOfMyClass.insert(my5);
        MyClass my6 = new MyClass(50.);
        treeOfMyClass.insert(my6);
        MyClass my7 = new MyClass(60.);
        treeOfMyClass.insert(my7);

        System.out.println("\n");
        treeOfMyClass.traversalType = BST.TraversalType.ROOTLEFTRIGHT;
        System.out.println("КЛП:");
        treeOfMyClass.print();

        System.out.println("Поддерево, вершиной которого является ближайший общий предок для вершин со значениями -2.5 и 1.4:");
        treeOfMyClass.closestCommonAncestor(treeOfMyClass.search(my4),treeOfMyClass.search(my5));

//        System.out.println("\n");
//        BST<Double> treeOfDoubleCopy=treeOfDouble.copy();
//        treeOfDouble.print();
//        treeOfDoubleCopy.traversalType = BST.TraversalType.LEFTROOTRIGHT;
//        treeOfDoubleCopy.print();
    }

}
