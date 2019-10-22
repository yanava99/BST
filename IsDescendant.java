public class IsDescendant<T> implements Function<T>
{
    public Node<T> descendant = null;
    public boolean isDescendant = false;
    public IsDescendant(Node<T> descendant)
    {
        this.descendant=descendant;
    }
    public void function(Node<T> node)
    {
        if(node.value == descendant.value)
            isDescendant = true;
    }
}
