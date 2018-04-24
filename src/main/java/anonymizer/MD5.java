package anonymizer;

import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component("md5")
public class MD5 implements AnonimizerImpl {

    @Override
    public String encryptId(String id)
    {
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("MD5");
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
