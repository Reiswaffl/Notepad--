package main.java.com.Notepad.XML;

//imports
import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 * @brief this class is to get or create Node-Elements into the XML-File
 */
public class XMLReader {
    Document doc;
    String filepath;

    /**
     * brief setup, loading XML-File
     * @param filepath path to the XML-File with the saves
     */
    public XMLReader(String filepath){
        this.filepath = filepath;
        Update();
    }

    /**
     * @brief loads the Document (doc) to get Nodes from is later
     */
    public void Update(){
        try {
            File inputFile = new File(filepath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();}
    }

    /**
     * brief returns the root-Element as Node
     * @param rootname name of the root-Element
     * @return Node: root-Element
     */
    public Node getRoot(String rootname){
        return doc.getElementsByTagName(rootname).item(0);
    }

    /**
     * @brief returns all ChildNodes of a Node
     * @param tagname tagname of the Nodes
     * @return NodeList: ChildNodes
     */
    public NodeList getNodes(String tagname){
        return doc.getElementsByTagName(tagname);
    }

    /**
     * @brief adds an attribute to an Element
     * @param node Node, to add the attribute to
     * @param attName name of the attribute
     * @param attValue value of the attribute
     */
    public void setAtt(Node node, String attName, String attValue){
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            element.setAttribute(attName,attValue);
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filepath));
                transformer.transform(source, result);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
