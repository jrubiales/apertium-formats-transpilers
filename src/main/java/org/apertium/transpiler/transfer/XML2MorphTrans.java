
package org.apertium.transpiler.transfer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author juanfran
 */
public class XML2MorphTrans {
        
    private static void help(){
        System.out.println("No arguments were given.");
    }
        
    public static void main(String[] args) {
        if (args.length == 0) {
            help();
        } else {
            String filePath = args[0];
            System.out.println("File: " + filePath);
            System.out.println("Parsing...");
            try {
                XMLReader reader = XMLReaderFactory.createXMLReader();
                reader.setContentHandler(new TransferSaxHandler());
                reader.parse(new InputSource(MorphTrans2XML.class.getResource(filePath).getFile()));
            } catch (SAXException | IOException ex) {
                Logger.getLogger(XML2MorphTrans.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Finished.");
        }
    }    
}