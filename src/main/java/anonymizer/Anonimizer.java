package anonymizer;

import middleware.Mappings;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Anonimizer
{
    private String anonMethod;

    public Anonimizer(String method)
    {
        this.anonMethod = method;
    }

    private Anonimizer() {}

    public String encryptField(String id)
    {
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance(this.anonMethod);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.toString());
        }
        md.update(id.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        Mappings.getInstance().setAMapping(id,hash);
        return hash;
    }
}
