package anonymizer;

public interface AnonimizerImpl
{
    /**
     * encrypt the caller id
     * set it in the mappings
     * @return encrypted text
     */
    public String encryptId(String id);

}
