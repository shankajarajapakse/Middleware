package services;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReaderService
{
    private XMLReaderService instance = null;

    private XMLReaderService() {}

    public XMLReaderService getInstance() {
        if (instance == null)
            instance = new XMLReaderService();
        return instance;
    }

    public String getValue(String field, int valueIndex) throws ParserConfigurationException, IOException, SAXException {
        String filePath = "C:\\Users\\Sankaja\\IdeaProjects\\Middleware\\resources\\properties.xml";
        File file = new File("userdata.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        String value = document.getElementsByTagName(field).item(valueIndex).getTextContent();

        return value;
    }
}
