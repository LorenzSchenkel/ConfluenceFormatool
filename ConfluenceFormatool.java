package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfluenceFormatool extends JFrame {

   public ConfluenceFormatool() {

       Function myFunction = new Function();

       // GUI
       setTitle("Confulence Formatool");
       setSize(1170,750 );
       setMinimumSize(new Dimension(1145,450));
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       //Contianer
       Container container = getContentPane();
       container.setLayout(new BorderLayout());


       // Declare Checkboxen
       final JCheckBox AbsätzeCheckobx = new JCheckBox("Delete paragraphs");
       final JCheckBox KlammernCheckbox = new JCheckBox("„\\[…\\]“ turns into „[…]“ ");
       final JCheckBox DurchgestrichenerTextCheckbox = new JCheckBox("Strikethrough text becomes normal");
       final JCheckBox SternCheckbox = new JCheckBox("(*) remains unchanged and does not become a star");
       final JCheckBox PfeilCheckbox = new JCheckBox("\uF0E8 change to -->");
       final JCheckBox BackslashCheckbox = new JCheckBox("Double backslash will be deleted");
       final JCheckBox wikiMarkupCheckbox = new JCheckBox("Unmigrated-wiki-markup will be deletet and will be replaced by <p></p>");
       final JCheckBox wikiMarkupTableCheckbox = new JCheckBox("Unmigrated-wiki-markup will be deletet in a table");

       // Set Checkbox true
       AbsätzeCheckobx.setSelected(true);
       KlammernCheckbox.setSelected(true);
       DurchgestrichenerTextCheckbox.setSelected(true);
       SternCheckbox.setSelected(true);
       PfeilCheckbox.setSelected(true);
       wikiMarkupCheckbox.setSelected(true);
       BackslashCheckbox.setSelected(true);
       wikiMarkupTableCheckbox.setSelected(true);

       // Panel for the Chekbox with all checkboxes
       final JPanel panelCheckbox = new JPanel();
       final BoxLayout boxLayoutCheckboxen = new BoxLayout(panelCheckbox, BoxLayout.Y_AXIS);
       panelCheckbox.setLayout(boxLayoutCheckboxen);

       // add all Checkboxen
       panelCheckbox.add(DurchgestrichenerTextCheckbox);
       panelCheckbox.add(AbsätzeCheckobx);
       panelCheckbox.add(SternCheckbox);
       panelCheckbox.add(PfeilCheckbox);
       panelCheckbox.add(wikiMarkupCheckbox);
       panelCheckbox.add(BackslashCheckbox);
       panelCheckbox.add(KlammernCheckbox);
       panelCheckbox.add(wikiMarkupTableCheckbox);


       // Declare labelDeveloper
       final JLabel labelDeveloper = new JLabel("Developed by Lorenz Schenkel");
       labelDeveloper.setPreferredSize(new Dimension(178,20));
       labelDeveloper.setHorizontalAlignment(JLabel.CENTER);
       labelDeveloper.setForeground(Color.GRAY);

       // Panel for labelDeveloper
       final JPanel panelDeveloper =  new JPanel();
       panelDeveloper.add(labelDeveloper);


       // TextArea1
       final JTextArea textArea1 = new JTextArea(20,50);
       final JScrollPane scrollPane1 = new JScrollPane(textArea1);

       // set
       //textArea1.setPreferredSize(new Dimension(500,400));
       // textArea1.requestFocus();
       //textArea1.setWrapStyleWord(true);
       //textArea1.setLineWrap(true);
       textArea1.setText("Put confluence HTML code inside.");


       // TextArea2
       final JTextArea textArea2 = new JTextArea(20,50);
       final JScrollPane scrollPane2 = new JScrollPane(textArea2);

       // set
       //textArea2.setPreferredSize(new Dimension(500,400));
       /*
       textArea2.setWrapStyleWord(true);
       textArea2.setLineWrap(true);
       textArea2.setDisabledTextColor(Color.blue);

        */
       textArea2.setText("New formatet text.");

       // panel for Textare 1 & 2
       final JPanel panelTextarea = new JPanel();
       final GridLayout gridLayoutTextarea = new GridLayout(2,1, 10 ,10);
       panelTextarea.setLayout(gridLayoutTextarea);
       panelTextarea.add(scrollPane1);
       panelTextarea.add(scrollPane2);

       // buttonFormat
       final JButton buttonFormat = new JButton("format");
       buttonFormat.setText("Format the text");

       // check which checkbox is true and change the text
       buttonFormat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               String txt = textArea1.getText();
               if(AbsätzeCheckobx.isSelected()) {
                   //Absätze werden entfernt
                   txt = myFunction.absätzeEntfernen(txt);
               }
               if (KlammernCheckbox.isSelected()) {
                   //Wenn im Word „[…]“ gibst ist in confluence „\[…\]“
                   txt = myFunction.backslashKlammerEntfernen(txt);
               }
               if (DurchgestrichenerTextCheckbox.isSelected()) {
                   //Durchgestrichener text: wieder normal ( nicht durchgestrichen)
                   txt = myFunction.duchgestrichenerTextEntfernen(txt);
               }
               if (SternCheckbox.isSelected()) {
                   //(*) soll nicht stern werden/ sein
                   txt = myFunction.sternEntfernen(txt);
               }
               if (PfeilCheckbox.isSelected()) {
                   // soll zu ->
                   txt = myFunction.pfeilVerbessern(txt);
               }
               if (BackslashCheckbox.isSelected()) {
                   //Entfernen von \\
                   txt = myFunction.backslahsEntfernen(txt);
               }
               if (wikiMarkupTableCheckbox.isSelected()) {
                   //Entfernt wikiMarkups in einer tabelle
                   txt = myFunction.wikiMarkupTableEntfernen(txt);
               }
               if (wikiMarkupCheckbox.isSelected()) {
                   //Entfernt den Anfang des Markup und die ID muss noch durch ein
                   txt = myFunction.wikiMarkupEntfernen(txt);
               }

               textArea2.setText(txt);
           }
       });

       // buttonCopy
       final JButton buttonCopy = new JButton("Copy to clipboard");
       Clipboard systemClip = Toolkit.getDefaultToolkit().getSystemClipboard();

       // copy the new Text
       buttonCopy.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               systemClip.setContents(new StringSelection(textArea2.getText()), null);
           }
       });

       // panel for buttonCopy and buttonFormat
       final JPanel panelButton = new JPanel();
       final BoxLayout boxLayoutButton = new BoxLayout(panelButton, BoxLayout.Y_AXIS);
       panelButton.setLayout(boxLayoutButton);
       panelButton.add(buttonFormat);
       panelButton.add(Box.createVerticalStrut(307));
       panelButton.add(buttonCopy);


       // panelEast includes Buttons
       final JPanel panelEast = new JPanel();
       panelEast.add(panelButton);

       // panelCenter includes Textareas
       final JPanel panelCenter = new JPanel();
       panelCenter.add(panelTextarea);

       // panelSouth includes Jlabel Developer
       final JPanel panelSouth = new JPanel();
       panelSouth.add(panelDeveloper);

       // panelWest includes all Checkboxes
       final JPanel panelWest = new JPanel();
       panelWest.add(panelCheckbox);


       // Add panels to container
       container.add(panelEast, BorderLayout.EAST);
       container.add(panelCenter, BorderLayout.CENTER);
       container.add(panelSouth, BorderLayout.SOUTH);
       container.add(panelWest, BorderLayout.WEST);

       // set Containers/ window visible
       setVisible(true);
   }
}
