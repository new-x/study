package ru.job4j.magnit;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

import static ru.job4j.magnit.ParserMagnit.IN_FILE;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.magnit
 * Create data: 08.07.2018 21:08
 */

public class ConvertXSQT {
    private final String XSLT_CONFIG = "C:\\Storage\\Java\\study\\chapter_005\\src\\main\\resources\\transformer.xsl";
    private final String OUT_FILE = "C:\\Storage\\Java\\study\\chapter_005\\src\\main\\resources\\output.xml";
    public void convertToXSLT() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(XSLT_CONFIG));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File(IN_FILE));
        transformer.transform(xml, new StreamResult(new File(OUT_FILE)));
    }
}
