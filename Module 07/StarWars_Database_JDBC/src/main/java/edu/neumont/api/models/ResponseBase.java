package edu.neumont.api.models;

public abstract class ResponseBase
{
    String count;
    String next;
    String previous;

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public String getNext()
    {
        return next;
    }

    public void setNext(String next)
    {
        this.next = next;
    }

    public String getPrevious()
    {
        return previous;
    }

    public void setPrevious(String previous)
    {
        this.previous = previous;
    }
}
