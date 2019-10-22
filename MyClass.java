public class MyClass implements Comparable<MyClass>
{
    double myValue = 0;

    MyClass(double myValue)
    {
        this.myValue = myValue;
    }

    @Override
    public int compareTo(MyClass other)
    {
        return Double.compare(myValue,other.myValue);
    }

    @Override
    public String toString()
    {
        return Double.toString(myValue);
    }
}
