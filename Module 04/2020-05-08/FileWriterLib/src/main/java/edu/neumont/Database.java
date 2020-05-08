package edu.neumont;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database<T>
{

    public void serialize(String filePath, List<ISerializable<T>> items)
    {
        try {
            FileWriter fileOut = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileOut);
            for(ISerializable<T> item: items) {
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

    public List<ISerializable<T>> deserialize(String filePath, Class<?> target)
    {
        List<ISerializable<T>> items = new ArrayList<>();

        try {
            FileReader inFile = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(inFile);

            //this is used to build the object that are to be serialized
            Class<?> builder = Class.forName(target.getName());

            String json = reader.readLine();


            while(json != null)
            {
                //create the object (bean)
                ISerializable<T> item = (ISerializable<T>) builder.newInstance();
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

        return items;
    }


}
