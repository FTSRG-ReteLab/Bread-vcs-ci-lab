import org.junit.Test;

import hu.bme.mit.train.Tachograph;

import static org.junit.Assert.assertFalse;


public class test2 {

    @Test
    public void TestTachograph(){
        Tachograph tachograph = new Tachograph();
        tachograph.addToTable("elem","elem", "elem");
        assertFalse(tachograph.getTab().isEmpty());
    }
}
