package edu.neumont.dtos;

import java.beans.JavaBean;
import java.util.List;

@JavaBean
public abstract class DtoBase
{
    String url;
    String name;
    String created;
    String edited;

    public DtoBase(){}

    public String getId()
    {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public String getEdited()
    {
        return edited;
    }

    public void setEdited(String edited)
    {
        this.edited = edited;
    }
}
