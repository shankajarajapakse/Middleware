package anonymizer;

import java.util.HashMap;
import java.util.Map;

public class Mappings
{
    private static Mappings instance = null;
    private Map<String,String> mappings;

    private Mappings()
    {
        mappings = new HashMap<String, String>();
    }

    public static Mappings getInstance()
    {
        if (instance == null)
            instance = new Mappings();
        return instance;
    }

    public boolean isAlreadyMapped(String id)
    {
        if (mappings.containsKey(id))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getMapping(String id)
    {
        if (isAlreadyMapped(id))
            return mappings.get(id);
        else
            return null;
    }

    public void setAMapping(String key, String value)
    {
        try
        {
            if (! mappings.containsKey(key))
                mappings.put(key,value);
        }
        catch (NullPointerException ex)
        {
            System.out.println(ex.toString());
        }
    }
}
