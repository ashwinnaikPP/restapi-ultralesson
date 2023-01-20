import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class SampleTests {

    @Test
    public void shouldTestSomething(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void secondSampleTest(){
        Assert.assertEquals(5.3,5.3);
    }
}
