package xml;

import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Created by ³¾¶« on 2015/4/14.
 */
public class XPathTest {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(inputStream));
        XPathFactory xPathFactory = XPathFactory.newInstance();

        XPath xpath = xPathFactory.newXPath();
        Object config = xpath.evaluate("/configuration",doc, XPathConstants.NODE);
        Node node = (Node) config;
        System.out.println(node);*/

        System.out.println(XPathTest.class.getSimpleName().toLowerCase(Locale.ENGLISH));


    }
}
