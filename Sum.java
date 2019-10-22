public class Sum<T> implements Function<T>
{
    private double sum = 0;
    public void function(Node<T> node)
    {
        sum += (Double)node.value;
    }

    public double getSum()
    {
        return sum;
    }
}
