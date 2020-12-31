/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superclassextraction;

import java.util.ArrayList;

/**
 *
 * @author dantas
 */
public abstract class Analyzer {
    static final boolean CORRECT = true;
    static final boolean INCORRECT = false;
    ArrayList<String> data;

    public Analyzer() {
    }

    public abstract String analyzeData(ArrayList<String> data, int offset);

    public void fetchData() {
        //code
    }

    public boolean parseData() {
        return DataAnalyzer.CORRECT;
    }

    public void clearData(){
        data.clear();
    }
}
