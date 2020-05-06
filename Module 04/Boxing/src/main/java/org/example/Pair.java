package org.example;

public class Pair<T>
{
    T left;
    T right;

    public T getLeft()
    {
        return left;
    }

    public void setLeft(T left)
    {
        this.left = left;
    }

    public T getRight()
    {
        return right;
    }

    public void setRight(T right)
    {
        this.right = right;
    }

    public Pair(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public void swap()
    {
        T temp = left;
        left = right;
        right = temp;
    }
}
