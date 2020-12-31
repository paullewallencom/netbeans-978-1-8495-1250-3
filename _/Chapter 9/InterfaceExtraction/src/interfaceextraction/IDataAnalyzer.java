package interfaceextraction;

import java.util.ArrayList;

public interface IDataAnalyzer {

    String analyzeData(ArrayList<String> data, int offset);

    boolean parseData();

}
