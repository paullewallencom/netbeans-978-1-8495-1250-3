/*
 * Main.fx
 *
 * Created on Aug 28, 2010, 3:46:40 PM
 */

package javafxapp;

/**
 * @author dantas
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    def __layoutInfo_listView: javafx.scene.layout.LayoutInfo = javafx.scene.layout.LayoutInfo {
        width: 293.0
        height: 384.0
    }
    public-read def listView: javafx.scene.control.ListView = javafx.scene.control.ListView {
        layoutX: 6.0
        layoutY: 63.0
        layoutInfo: __layoutInfo_listView
        items: bind httpdataSource.getDataSource("message").getRecordSet().all()
        cellFactory: listCellFactory
    }
    
    def __layoutInfo_listViewStream: javafx.scene.layout.LayoutInfo = javafx.scene.layout.LayoutInfo {
        width: 290.0
        height: 384.0
    }
    public-read def listViewStream: javafx.scene.control.ListView = javafx.scene.control.ListView {
        layoutX: 341.0
        layoutY: 63.0
        layoutInfo: __layoutInfo_listViewStream
        items: bind for(record in httpdataSource2.getDataSource("posts").getRecordSet().all()) record.getString("message")
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 640.0
        height: 480.0
        content: getDesignRootNodes ()
    }
    
    public-read def httpdataSource: org.netbeans.javafx.datasrc.HttpDataSource = org.netbeans.javafx.datasrc.HttpDataSource {
        url: "https://api.facebook.com/method/status.get?access_token=2227470867|2.kSnngaOxkEeKrAdVXV_iWg__.3600.1283004000-730419477|ukcK-OUQniPK_pIi8oyGkZ_2Dbc.&format=json"
        user: "dantas@live.com"
        password: ""
        parser: org.netbeans.javafx.datasrc.Parsers.JSON_PARSER
    }
    
    public-read def httpdataSource2: org.netbeans.javafx.datasrc.HttpDataSource = org.netbeans.javafx.datasrc.HttpDataSource {
        url: "https://api.facebook.com/method/stream.get?access_token=2227470867|2.V2JgA6k7R9GqJtaFY7J5dw__.3600.1283007600-730419477|HfWVbf8AaLYrSz5J4NtVC1YmyhU.&format=json"
        user: "dantas@live.com"
        password: ""
        parser: org.netbeans.javafx.datasrc.Parsers.JSON_PARSER
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
    }
    
    function listCellFactory(): javafx.scene.control.ListCell {
        var listCell: javafx.scene.control.ListCell;
        
        def label: javafx.scene.control.Label = javafx.scene.control.Label {
            visible: bind not listCell.empty
            text: bind (listCell.item as org.netbeans.javafx.datasrc.Record).getString("message")
        }
        
        listCell = javafx.scene.control.ListCell {
            node: label
        }
        
        return listCell
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ listView, listViewStream, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

}

function run (): Void {
    var design = Main {};

    javafx.stage.Stage {
        title: "Main"
        scene: design.getDesignScene ()
    }
}
