import Main.parser.Translator;
import org.junit.Assert;
import org.junit.Test;

public class CountryServiceTest {
    Translator translator = new Translator();
    @Test
public void translate() {
    String translation = translator.getTranslate("Hello");
    Assert.assertEquals("привет", translation);


}
}
