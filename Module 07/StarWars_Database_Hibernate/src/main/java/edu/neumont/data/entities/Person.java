package edu.neumont.data.entities;

import javax.persistence.*;

@Entity
@Table(name="Person",
 uniqueConstraints = {@UniqueConstraint(columnNames = "url")})
public class Person
{
    private String url;
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String created;
    private String edited;

    public Person(){}

    public Person(String url, String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeWorld, String created, String edited)
    {
        this.url = url;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.created = created;
        this.edited = edited;
    }

    @Id
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

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getMass()
    {
        return mass;
    }

    public void setMass(String mass)
    {
        this.mass = mass;
    }

    @Column(name="hair_color")
    public String getHairColor()
    {
        return hairColor;
    }

    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    @Column(name="skin_color")
    public String getSkinColor()
    {
        return skinColor;
    }

    public void setSkinColor(String skinColor)
    {
        this.skinColor = skinColor;
    }

    @Column(name="eye_color")
    public String getEyeColor()
    {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    @Column(name="birth_year")
    public String getBirthYear()
    {
        return birthYear;
    }

    public void setBirthYear(String birthYear)
    {
        this.birthYear = birthYear;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Column(name="homeworld")
    public String getHomeWorld()
    {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld)
    {
        this.homeWorld = homeWorld;
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
