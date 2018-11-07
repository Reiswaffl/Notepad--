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
     * @brief returns all ChildNodes of a Node
     * @param tagname tagname of the Nodes
     * @return NodeList: ChildNodes
     */
    public NodeList getNodes(String tagname){
        return doc.getElementsByTagName(tagname);
    }

    /**
     * @brief allows it to add a Node
     * @param parent parent, the Node will be the child from
     * @param identifier identifier (tag) of the new Node
     * @return
     */
    public Node setNode(Node parent, String identifier){
        Element element = doc.createElement(identifier);
        parent.appendChild(element);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
        }catch (Exception e){}
        return (Node) element;
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

    /**
     * @brief allows to set a TextContent to a Node
     * @param node Node to add the TextContent
     * @param content
     */
    public void setContent(Node node, String content){
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            element.setTextContent(content);
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

    /**
     * @brief makes it possible to delete a Node
     * @param parent parent to delete the Node from
     * @param node Node to delete
     */
    public void deleteNode(Node parent, Node node){
        parent.removeChild(node);
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
