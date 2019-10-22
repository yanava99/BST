public class NodeCount<T> implements Function<T>
{
    private int n = 0;
    public void function(Node<T> node)
    {
        ++n;
    }

    public int getN()
    {
        return n;
    }
}
