package edu.neumont;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Database<T extends ISerializable>
{
    private final String filePath;
    private final Class<T> targetType;
    List<T> items;

    public Database(String filePath, Class<T> targetType)
    {
        this.filePath = filePath;
        this.targetType = targetType;
        deserialize();
    }

    private void serialize()
    {
        try {
            FileWriter fileOut = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileOut);
            for(T item: items) {
                writer.write(item.serialize());
                writer.write("\n");
            }
            writer.flush();
            writer.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserialize()
    {
        items = new ArrayList<>();

        try {
            FileReader inFile = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(inFile);

            //this is used to build the object that are to be serialized
            Class<?> builder = Class.forName(targetType.getName());

            String json = reader.readLine();

            while(json != null)
            {
                //create the object (bean)
                T item = (T) builder.newInstance();
                //deserialize it
                item.deserialize(json);

                //check if it should be added? does it match?
                items.add(item);

                json = reader.readLine();
            }
            reader.close();
            inFile.close();

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void add(T item)
    {
        if(items == null){
            deserialize();
        }

        items.add(item);
    }

    public void add(List<T> items)
    {
        if(items == null){
            deserialize();
        }

        this.items.addAll(items);
    }

    public void remove(T item)
    {
        items.remove(item);
    }

    public void save()
    {
        serialize();
    }

    public List<T> get()
    {
        return items;
    }

    public List<T> search(Predicate<T> criteria)
    {
        return items.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }


}
