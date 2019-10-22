public class LeavesSum<T> implements Function<T>
{
    private double sum=0;
    public void function(Node<T> node)
    {
        if(node.left==null && node.right==null)
            sum += (Double)node.value;
    }

    public double getSum()
    {
        return sum;
    }
}
