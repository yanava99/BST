public class Print<T> implements Function<T>
{
    public void function(Node<T> node)
    {
        System.out.print(node.value + " ");
    }
}
