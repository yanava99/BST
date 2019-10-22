public class Node<T>
{
    public T value;
    public Node left;
    public Node right;
    public Node parent;

    public Node(T value, Node left, Node right, Node parent)
    {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Node(T value, Node parent)
    {
        this(value,null,null,parent);
    }

    public Node(T value)
    {
        this(value,null,null,null);
    }

    @Override
    public String toString()
    {
        return value.toString()+"\n";
    }
}
