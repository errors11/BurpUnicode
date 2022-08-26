package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BurpGUI {


    public JPanel root;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JButton button2;
    public String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\(?i)u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }
    public String unicodeEncode(String string)
    {
        char[] String_char = string.toCharArray();
        String unicodeBytes="";
        for(int i=0;i<String_char.length;i++)
        {
            String hexB = Integer.toHexString(String_char[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }
    public BurpGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unicode_str = textField1.getText();
                String str_decode = unicodeDecode(unicode_str.trim());
                textField2.setText(str_decode);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zhongwen = textField1.getText();
                String unicode = unicodeEncode(zhongwen);
                textField2.setText(unicode);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
