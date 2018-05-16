package middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API
{
    @Autowired
    private Connector connector;
    @RequestMapping("/sample")
    public String sampleEncryption(@RequestParam(value="number", defaultValue="0712904008") String number) {
        return "Original "+number+" -> hashed ";
    }

}
