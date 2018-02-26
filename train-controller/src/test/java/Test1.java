import hu.bme.mit.train.controller.TrainControllerImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Test1 {

    @Test
    public void tester(){
        TrainControllerImpl trainController = new TrainControllerImpl();

        assertEquals(0, trainController.getReferenceSpeed());
    }
}
