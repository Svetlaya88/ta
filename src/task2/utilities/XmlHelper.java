package task2.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task2.utilities.exceptions.ParsingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlHelper extends Utilities{

    public File getFile(final String filename) {
        return new File(getDefaultFilePath(filename));
    }

    public void parseCandiesXml(final String filename) throws ParsingException {
        File xmlFile = getFile(filename);

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            NodeList nodes = doc.getElementsByTagName("candy");

            System.out.println(">>> PARSED XML " + xmlFile.getName() +  ": <<<");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    printTypedXmlNode(element, AvailableXmlNodes.TYPE);
                    printXmlNode(element, getAvailableChildNodes());
                    printLineSeparator();
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            throw new ParsingException(ex.toString());
        }
    }

    private void printTypedXmlNode(Element element, AvailableXmlNodes xmlTag) {
        System.out.println(xmlTag.getNodeName().toUpperCase() + ": "
                + element.getAttribute(xmlTag.getNodeName()).toUpperCase());
    }

    private void printXmlNode(Element element, List<AvailableXmlNodes> nodes) {
        nodes.forEach(n -> {
            NodeList nodesList = element.getElementsByTagName(n.getNodeName());
            String value = nodesList.item(0).getTextContent();
            if (!value.equals(""))
            System.out.println(n.getNodeName().toUpperCase() + ": " + value);
        });
    }

    private List<AvailableXmlNodes> getAvailableChildNodes() {
        List<AvailableXmlNodes> nodesList = new ArrayList<>();
        nodesList.add(AvailableXmlNodes.NAME);
        nodesList.add(AvailableXmlNodes.WEIGHT_IN_GRAM);
        nodesList.add(AvailableXmlNodes.MANUFACTURER);
        nodesList.add(AvailableXmlNodes.FILLING);
        nodesList.add(AvailableXmlNodes.TASTE);
        nodesList.add(AvailableXmlNodes.WITH_STICK);
        return nodesList;
    }
}
