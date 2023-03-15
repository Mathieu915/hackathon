import org.junit.Assert;
import org.junit.Assert.*;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class testTesseract {
    public void main(String[] args){
        File image = new File("src/main/resources/images/TEST.png");
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("src/main/resources/tessdata");
            tesseract.setLanguage("fr");
            tesseract.setPageSegMode(1);
            tesseract.setOcrEngineMode(1);
            String result = tesseract.doOCR(image);
            Assert.assertTrue(result.contains(""));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
