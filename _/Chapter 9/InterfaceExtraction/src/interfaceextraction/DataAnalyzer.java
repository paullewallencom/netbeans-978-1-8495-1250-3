package interfaceextraction;

import java.util.ArrayList;

public class DataAnalyzer implements IDataAnalyzerDB {

    ArrayList<String> data;
    static final boolean CORRECT = true;
    static final boolean INCORRECT = false;

    private void fetchData() {
        //code
    }

    public void saveData() {
        //code
    }

    public boolean parseData() {
        return CORRECT;
    }

    public String analyzeData(ArrayList<String> data, int offset) {
        //code
        return "";
    }
}
