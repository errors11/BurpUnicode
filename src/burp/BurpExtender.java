package burp;
import javax.swing.*;
import java.awt.*;
import ui.BurpGUI;

public class BurpExtender implements IBurpExtender,ITab{
    private JPanel jPanelMain;
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        callbacks.printError("Error Message!");
        callbacks.printOutput("Hello World");
        BurpGUI bg = new BurpGUI();
        jPanelMain = bg.root;
        callbacks.customizeUiComponent(jPanelMain);
        callbacks.addSuiteTab(this);
    }
    @Override
    public String getTabCaption()
    {
        return "Demotool";
    }
    @Override
    public Component getUiComponent()
    {
        return jPanelMain;
    }
}
