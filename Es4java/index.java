import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class index {

  public static void main(String[] args) {

    String xmlutenti = "./utenti.xml";
    String xsdutenti = "./utente.xsd";

    String xmllibri = "./libri.xml";
    String xsdlibri = "./libro.xsd";

    String xmlprestiti = "./prestiti.xml";
    String xsdprestiti = "./prestito.xsd";
    String xmlbiblioteche = "./biblioteche.xml";
    String xsdbiblioteche = "./biblioteca.xsd";

    try {
      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = factory.newSchema(new File(xsdutenti));
      Validator validator = schema.newValidator();
      Source source = new StreamSource(new File(xmlutenti));

      validator.validate(source);
      System.out.println(xmlutenti + " is valid.");

    } catch (Exception e) {
      System.out.println(xmlutenti + " is not valid because: " + e.getMessage());
    }

    try {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdlibri));
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new File(xmllibri));
  
        validator.validate(source);
        System.out.println(xmllibri + " is valid.");
  
      } catch (Exception e) {
        System.out.println(xmllibri + " is not valid because: " + e.getMessage());
      }

      try {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdprestiti));
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new File(xmlprestiti));
  
        validator.validate(source);
        System.out.println(xmlprestiti + " is valid.");
  
      } catch (Exception e) {
        System.out.println(xmlprestiti + " is not valid because: " + e.getMessage());
      }

      try {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdbiblioteche));
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new File(xmlbiblioteche));
  
        validator.validate(source);
        System.out.println(xmlbiblioteche + " is valid.");
  
      } catch (Exception e) {
        System.out.println(xmlbiblioteche + " is not valid because: " + e.getMessage());
      }
  }
}

