package services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReaderService
{
    private XMLReaderService instance = null;
    private NodeList nodeList;

    private XMLReaderService() throws IOException, SAXException, ParserConfigurationException {
        setNodeList();
    }

    public XMLReaderService getInstance() throws ParserConfigurationException, SAXException, IOException {
        if (instance == null)
            instance = new XMLReaderService();
        return instance;
    }

    private NodeList setNodeList() throws ParserConfigurationException, IOException, SAXException {

        String filePath = "C:\\Users\\Sankaja\\IdeaProjects\\Middleware\\resources\\properties.xml";
        File file = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        NodeList nodeList = document.getElementsByTagName("attribute");

        return nodeList;
    }

    public String[] getFields()
    {
        int fieldCount = this.nodeList.getLength();
        String[] fields = new String[fieldCount];
        Element e;

        for (int i = 0 ; i <= fieldCount ; i++)
        {
            e = (Element) this.nodeList.item(i);
            fields[i] = e.getAttribute("value");
        }
        return fields;
    }

    public NodeList getNodeList() {
        return nodeList;
    }
}
