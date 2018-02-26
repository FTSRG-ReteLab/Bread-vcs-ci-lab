package hu.bme.mit.train;

import com.google.common.collect.HashBasedTable;

public class Tachograph {

    public HashBasedTable<String, String, String> tab;

    public Tachograph() {
        tab.create();
    }

    public void addToTable(String date, String pos, String ref) {
        tab.put(ref, pos, date);
    }
}
