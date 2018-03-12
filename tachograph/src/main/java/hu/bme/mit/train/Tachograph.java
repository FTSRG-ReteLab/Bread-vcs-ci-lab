package hu.bme.mit.train;

import com.google.common.collect.HashBasedTable;

public class Tachograph {

    private HashBasedTable<String, String, String> tab;

    public Tachograph() {
        tab = tab.create();
    }

    public HashBasedTable<String, String, String> getTab() {
        return tab;
    }

    public void setTab(final HashBasedTable<String, String, String> tab) {
        this.tab = tab;
    }

    public void addToTable(String date, String pos, String ref) {
        tab.put(ref, pos, date);
    }
}
