/*
 * Main.fx
 *
 * Created on Aug 29, 2010, 2:27:20 PM
 */

package desktopdbjavafxapp;

/**
 * @author dantas
 */
public class Main {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:main
    public-read def formTitlesVBox: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        spacing: 6.0
    }
    
    public-read def formValuesVBox: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        spacing: 6.0
    }
    
    public-read def formContainerHBox: javafx.scene.layout.HBox = javafx.scene.layout.HBox {
        layoutX: 6.0
        layoutY: 6.0
        content: [ formTitlesVBox, formValuesVBox, ]
        spacing: 6.0
    }
    
    public-read def phonetitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "PHONE:"
    }
    
    public-read def statetitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "STATE:"
    }
    
    public-read def nametitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "NAME:"
    }
    
    public-read def ziptitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "ZIP:"
    }
    
    public-read def addressline1titleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "ADDRESSLINE1:"
    }
    
    public-read def addressline2titleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "ADDRESSLINE2:"
    }
    
    public-read def credit_limittitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "CREDIT LIMIT:"
    }
    
    public-read def emailtitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "EMAIL:"
    }
    
    public-read def customer_idtitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "CUSTOMER ID:"
    }
    
    public-read def citytitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "CITY:"
    }
    
    public-read def faxtitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "FAX:"
    }
    
    public-read def discount_codetitleLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: "DISCOUNT CODE:"
    }
    
    public-read def formTitlesVBox2: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        content: [ phonetitleLabel, statetitleLabel, nametitleLabel, ziptitleLabel, addressline1titleLabel, addressline2titleLabel, credit_limittitleLabel, emailtitleLabel, customer_idtitleLabel, citytitleLabel, faxtitleLabel, discount_codetitleLabel, ]
        spacing: 6.0
    }
    
    public-read def phonevalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("PHONE")}"
    }
    
    public-read def statevalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("STATE")}"
    }
    
    public-read def namevalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("NAME")}"
    }
    
    public-read def zipvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("ZIP")}"
    }
    
    public-read def addressline1valueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("ADDRESSLINE1")}"
    }
    
    public-read def addressline2valueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("ADDRESSLINE2")}"
    }
    
    public-read def credit_limitvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("CREDIT_LIMIT")}"
    }
    
    public-read def emailvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("EMAIL")}"
    }
    
    public-read def customer_idvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("CUSTOMER_ID")}"
    }
    
    public-read def cityvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("CITY")}"
    }
    
    public-read def faxvalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("FAX")}"
    }
    
    public-read def discount_codevalueLabel: javafx.scene.control.Label = javafx.scene.control.Label {
        text: bind "{jdbcdataSource.getRecordSet().currentString("DISCOUNT_CODE")}"
    }
    
    public-read def formValuesVBox2: javafx.scene.layout.VBox = javafx.scene.layout.VBox {
        content: [ phonevalueLabel, statevalueLabel, namevalueLabel, zipvalueLabel, addressline1valueLabel, addressline2valueLabel, credit_limitvalueLabel, emailvalueLabel, customer_idvalueLabel, cityvalueLabel, faxvalueLabel, discount_codevalueLabel, ]
        spacing: 6.0
    }
    
    def __layoutInfo_formContainerHBox2: javafx.scene.layout.LayoutInfo = javafx.scene.layout.LayoutInfo {
        width: 456.0
        height: 246.0
    }
    public-read def formContainerHBox2: javafx.scene.layout.HBox = javafx.scene.layout.HBox {
        layoutX: 12.0
        layoutY: 14.0
        layoutInfo: __layoutInfo_formContainerHBox2
        content: [ formTitlesVBox2, formValuesVBox2, ]
        spacing: 6.0
    }
    
    def __layoutInfo_indexPreviousButton: javafx.scene.layout.LayoutInfo = javafx.scene.layout.LayoutInfo {
        hfill: true
    }
    public-read def indexPreviousButton: javafx.scene.control.Button = javafx.scene.control.Button {
        disable: bind not jdbcdataSource.getRecordSet().hasPrev()
        layoutInfo: __layoutInfo_indexPreviousButton
        text: "Previous"
        action: function ():Void { jdbcdataSource.getRecordSet().prev(); }
    }
    
    public-read def tile: javafx.scene.layout.Tile = javafx.scene.layout.Tile {
        layoutX: 172.0
        layoutY: 266.0
        content: [ indexPreviousButton, ]
        columns: 2
        hgap: 6.0
        vgap: 6.0
    }
    
    public-read def scene: javafx.scene.Scene = javafx.scene.Scene {
        width: 480.0
        height: 320.0
        content: getDesignRootNodes ()
        camera: null
        cursor: null
        fill: javafx.scene.paint.Color.WHITE
    }
    
    public-read def color: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 0.9647059
        green: 0.972549
        blue: 0.98039216
    }
    
    public-read def color2: javafx.scene.paint.Color = javafx.scene.paint.Color {
        red: 0.2
        green: 0.49411765
        blue: 0.972549
    }
    
    public-read def color3: javafx.scene.paint.Color = javafx.scene.paint.Color {
    }
    
    public-read def jdbcdataSource: org.netbeans.javafx.datasrc.DbDataSource = org.netbeans.javafx.datasrc.DbDataSource {
        connectionString: "jdbc:derby://localhost:1527/sample"
        user: "app"
        password: "app"
        query: "select * from CUSTOMER"
    }
    
    public-read def currentState: org.netbeans.javafx.design.DesignState = org.netbeans.javafx.design.DesignState {
        names: [ "First", "Second", ]
        actual: 0
        timelines: [
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            scene.fill = javafx.scene.paint.Color.WHITE;
                        }
                    }
                ]
            }
            javafx.animation.Timeline {
                keyFrames: [
                    javafx.animation.KeyFrame {
                        time: 0ms
                        action: function() {
                            scene.fill = color2;
                        }
                    }
                ]
            }
        ]
    }
    
    public function getDesignRootNodes (): javafx.scene.Node[] {
        [ formContainerHBox, formContainerHBox2, tile, ]
    }
    
    public function getDesignScene (): javafx.scene.Scene {
        scene
    }
    // </editor-fold>//GEN-END:main

    function indexNextButtonAction (): Void {
        jdbcdataSource.getRecordSet().next();
        currentState.nextWrapped();
    }

}

function run (): Void {
    var design = Main {};

    javafx.stage.Stage {
        title: "Main"
        scene: design.getDesignScene ()
    }
}
