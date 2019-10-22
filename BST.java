public class BST <T extends Comparable<T>>
{
    public Node<T> root;

    public enum TraversalType {ROOTLEFTRIGHT, LEFTROOTRIGHT, LEFTRIGHTROOT};
    public TraversalType traversalType = TraversalType.LEFTRIGHTROOT;

    private Node<T> insert(Node<T> node, T value)
    {
        if (node == null)
            return new Node<T>(value);
        if (value.compareTo(node.value)<0)
        {
            node.left = insert(node.left, value);
            node.left.parent = node;
        }
        else if (value.compareTo(node.value)>0)
        {
            node.right = insert(node.right, value);
            node.right.parent = node;
        }
        else
            node.value = value;
        return node;
    }

    public void insert(T value)
    {
           root = insert(root,value);
    }

    private Node<T> search(Node<T> p, T value)
    {
        if (p == null)
            return null;
        else
        if (value.compareTo(p.value) == 0)
            return p;
        else
        if (value.compareTo(p.value) < 0)
            return search(p.left, value);
        else
            return search(p.right, value);
    }

    public Node<T> search(T value)
    {
        return search(root, value);
    }

    private T retrieveData(Node<T> node)
    {
        while (node.right != null)
            node = node.right;
        return node.value;
    }

    private Node<T> delete(Node<T> p, T value)
    {
        if (p == null)
            throw new RuntimeException("Deletion is impossible.");
        else if (value.compareTo(p.value) < 0)
        {
            p.left = delete (p.left, value);
            if(p.left != null)
                p.left.parent = p;
        }
        else if (value.compareTo(p.value)  > 0)
        {
            p.right = delete (p.right, value);
            if(p.right != null)
                p.right.parent = p;
        }
        else
        {
            if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;
            else
            {
                //поллучить значение самого правого узла в левом поддереве
                p.value = (T)retrieveData(p.left);
                //удалить тот узел, значение которого взяли
                p.left =  delete(p.left, p.value) ;
                if(p.left != null)
                    p.left.parent = p;
            }
        }
        return p;
    }

    public void delete(T value)
    {
        root = delete(root, value);
    }

    private void rootLeftRight(Node<T> node, Function<T> func)
    {
        if (node == null)
            return;
        func.function(node);
        rootLeftRight(node.left,func);
        rootLeftRight(node.right,func);
    }

    private void leftRootRight(Node<T> node, Function<T> func)
    {
        if (node == null)
            return;
        leftRootRight(node.left,func);
        func.function(node);
        leftRootRight(node.right,func);
    }

    private void leftRightRoot(Node<T> node, Function<T> func)
    {
        if (node == null)
            return;
        leftRightRoot(node.left,func);
        leftRightRoot(node.right,func);
        func.function(node);
    }

    private void traversal(Node<T> node, Function<T> func)
    {
        if(traversalType == TraversalType.LEFTRIGHTROOT)
            leftRightRoot(node,func);
        else if (traversalType == TraversalType.LEFTROOTRIGHT)
            leftRootRight(node, func);
        else
            rootLeftRight(node, func);
    }

    private void printFromNode(Node<T> node)
    {
        traversal(node, new Print<T>());
        System.out.println();
    }

    public void print()
    {
        printFromNode(root);
    }

    public int nodeNumber()
    {
        NodeCount<T> count = new NodeCount<T>();
        traversal(root, count);
        return count.getN();
    }

    public double sum()
    {
        Sum<T> sum = new Sum<T>();
        traversal(root, sum);
        return sum.getSum();
    }

    public int leavesNumber()
    {
        LeavesCount<T> count = new LeavesCount<T>();
        traversal(root, count);
        return count.getN();
    }

    public double leavesSum()
    {
        LeavesSum<T> sum = new LeavesSum<T>();
        traversal(root, sum);
        return sum.getSum();
    }

    private Node<T> closestAncestor(Node<T> node1, Node<T> node2)
    {
        if(node1 == null || node2 == null)
            return null;
        if(node1.value == node2.value)
            return node1;
        else
        {
            IsDescendant<T> isDescendant = new IsDescendant<T>(node1);
            traversal(node2, isDescendant);
            if(isDescendant.isDescendant)
                return node2;
            else return closestAncestor(node1, node2.parent);
        }
    }

    public Node<T> closestCommonAncestor(Node<T> node1, Node<T> node2)
    {
        Node<T> ancestor = closestAncestor(node1, node2);
        printFromNode(ancestor);
        return ancestor;
    }

    //копирование без parent
//    private Node<T> copy(Node<T> nodeToCopy)
//    {
//        if(nodeToCopy == null)
//            return null;
//        Node<T> node = new Node<T>(nodeToCopy.value);
//        node.left = copy(nodeToCopy.left);
//        node.right = copy(nodeToCopy.right);
//        return node;
//    }
//
//    public BST<T> copy()
//    {
//        BST<T> newTree = new BST();
//        newTree.root=copy(this.root);
//        return newTree;
//    }
}
