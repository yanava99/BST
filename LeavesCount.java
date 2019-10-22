public class LeavesCount<T> implements Function<T>
{
    private int n = 0;
    public void function(Node<T> node)
    {
        if(node.left == null && node.right == null)
            ++n;
    }

    public int getN()
    {
        return n;
    }
}
