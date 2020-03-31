package com.company;

public class Function {

    public String absätzeEntfernen(String txt) {

        /*Absatz dynamisch entfernen Lösungsansätze( handybild)
                String absatzAnfang = "<p>";
                String absatzEnde = "</p>";

                int indexOfAbsatzAnfang = txt.indexOf(absatzAnfang);
                int indexOfabsatzEnde;

                if(indexOfAbsatzAnfang != -1) {
                    indexOfabsatzEnde = txt.indexOf(absatzEnde) + absatzEnde.length();
                }
                else {
                    indexOfabsatzEnde = -1;
                }
                String testIndexString = Character.toString(txt.charAt(1));
                System.out.println(testIndexString);



                    System.out.println("AbsatzAnfang:" + indexOfAbsatzAnfang);
                    System.out.println("AbsatzEnde:" + indexOfAbsatzAnfang);
                int userAbsatz = 1;
                int schleifenZählerWhile = 0;
                for (int schleifenzählerAbsatz = 0; schleifenzählerAbsatz < userAbsatz; schleifenzählerAbsatz++  ) {
                    while (schleifenZählerWhile != -1)
                    if (indexOfAbsatzAnfang > -1 && indexOfabsatzEnde > -1 && indexOfAbsatzAnfang < indexOfabsatzEnde) {
                        System.out.println("Absatz if");
                        StringBuffer sbAbsatz = new StringBuffer(txt);
                        sbAbsatz.delete(indexOfAbsatzAnfang, indexOfabsatzEnde);
                        txt = sbAbsatz.toString();
                        indexOfAbsatzAnfang = txt.indexOf(absatzAnfang);
                        indexOfabsatzEnde = txt.indexOf(absatzEnde) + absatzEnde.length();
                    }
                    else{
                        System.out.println("Absatz Else");
                        break;
                    }
                }
                */
        String txt_bedingung_absatz_0 = "<p>\n" + "  <br/>\n" + "</p>\n" + "<p>\n" + "  <br/>\n" + "</p>";
        String txt_bedingung_absatz_1 = "<p>\n" + "\t<br/> \n" + "</p>\n" + "<p>\n" + "\t<br/> \n" + "</p>";
        String txt_bedingung_absatz_2 = "  <p>\n" + "    <br/>\n" + "  </p>\n" + "  <p>\n" + "    <br/>\n" + "  </p>";
        String txt_bedingung_absatz_3 = "    <p>\n" + "      <br/>\n" + "    </p>\n" + "    <p>\n" + "      <br/>\n" + "    </p>";
        String txt_bedingung_absatz_4 = "      <p>\n" + "        <br/>\n" + "      </p>\n" + "      <p>\n" + "        <br/>\n" + "      </p>";
        String txt_bedingung_absatz_5 = "        <p>\n" + "          <br/>\n" + "        </p>\n" + "        <p>\n" + "          <br/>\n" + "        </p>";
        String txt_bedingung_absatz_6 = "          <p>\n" + "            <br/>\n" + "          </p>\n" + "           <p>\n" + "            <br/>\n" + "          </p>";
        String txt_bedingung_absatz_7 = "            <p>\n" + "              <br/>\n" + "            </p>\n" + "            <p>\n" + "              <br/>\n" + "            </p>";
        txt = txt.replaceAll(txt_bedingung_absatz_0, "");
        txt = txt.replaceAll(txt_bedingung_absatz_1, "");
        txt = txt.replaceAll(txt_bedingung_absatz_2, "");
        txt = txt.replaceAll(txt_bedingung_absatz_3, "");
        txt = txt.replaceAll(txt_bedingung_absatz_4, "");
        txt = txt.replaceAll(txt_bedingung_absatz_5, "");
        txt = txt.replaceAll(txt_bedingung_absatz_6, "");
        txt = txt.replaceAll(txt_bedingung_absatz_7, "");

        return txt;
    }

    public String backslashKlammerEntfernen(String txt) {

        String txt_hochkomma_0 = "\\\\\\[";
        String txt_hochkomma_1 = "\\\\]";
        txt = txt.replaceAll(txt_hochkomma_0, "[");
        txt = txt.replaceAll(txt_hochkomma_1, "]");
        return txt;
    }

    public String duchgestrichenerTextEntfernen(String txt) {

        String txt_durchgestrichen = "style=\"text-decoration: line-through;\"";
        txt = txt.replaceAll(txt_durchgestrichen, "");
        return txt;
    }

    public String sternEntfernen(String txt) {

        String txt_Stern = "<ac:emoticon ac:name=\"yellow-star\"/>";
        txt = txt.replaceAll(txt_Stern, "(*)");
        return txt;
    }

    public String pfeilVerbessern(String txt) {

        String txt_pfeil = "\uF0E8";
        txt = txt.replaceAll(txt_pfeil, "-->");
        return txt;
    }

    public String backslahsEntfernen(String txt) {

        String txt_markup_backslash = "\\\\\\\\";
        txt = txt.replaceAll(txt_markup_backslash, "");
        return txt;
    }

    public String wikiMarkupEntfernen(String txt) {

        // Bestandteile eines jeden macros
        String startOfMarkup = "<ac:structured-macro ac:macro-id=";
        String startMiddelOfMarkup = "ac:name=\"unmigrated-wiki-markup\"";
        String startEndOfMarkup = "<ac:plain-text-body><![CDATA[";

        // p tag ersetzt macro
        String startOfMarkupPTag = "<p>";
        String endOfMarkupPTag = "</p>";


        //
        boolean boolWhileWikiMarkupStartDelete = false;

        // solange boolWhileWikiMarkupStartDelete falsch ist läuft die Schleife
        while (boolWhileWikiMarkupStartDelete == false) {

            // sucht mit den Bestandteilen den index der Stellen
            int indexStartOfMarkup = txt.indexOf(startOfMarkup);
            int indexStartMiddelOfMarkup = txt.indexOf(startMiddelOfMarkup);
            int indexStartEndOfMarkup = txt.indexOf(startEndOfMarkup);

            // solange der Start von dem Ende( indexStartEndOfMarkup ) gefunden wird
            if (indexStartEndOfMarkup != -1) {

                // wird der Index + die länge des Strings zusammengerechnet, um das tatsächliche Ende ( der index dazu ) zu bekommen
                indexStartEndOfMarkup = txt.indexOf(startEndOfMarkup) + startEndOfMarkup.length();
            } else {

                // sollte das nicht der fall sein wird die variable auf -1 gesetzt, was später überprüft wird. Weil wenn kein ende da ist, soll auch nichts entfernt werden
                indexStartOfMarkup = -1;
            }

            // wenn Anfang und ende höher als -1 (also gefunden wurden) und der start kleiner ist als das Ende
            if (indexStartOfMarkup > -1 && indexStartEndOfMarkup > -1 && indexStartOfMarkup < indexStartEndOfMarkup) {

                // wird ein Stringbuffer zum bearbeiten des strings erstellt
                StringBuffer sbStartWikiMarup = new StringBuffer(txt);

                // solange die schleife nicht verlassen oder der wert auf flase gesetzt wird läuft sie weiter
                while (true) {

                    // wenn die differenz zwischen Start und middle größer als 73 ist, ist es kein macro sondern etwas anderes, was auf eines der beschreibungen( start oder middle) passen
                    if (indexStartMiddelOfMarkup - indexStartOfMarkup > 73) {

                        // da Start und middel - index nicht zusammenpassen wird der Start neu gesucht von ab einener Stelle, das er das vorherige nicht erkennt
                        indexStartOfMarkup = sbStartWikiMarup.indexOf(startOfMarkup, indexStartOfMarkup + 73);
                        indexStartMiddelOfMarkup = txt.indexOf(startMiddelOfMarkup, indexStartOfMarkup);
                        indexStartEndOfMarkup = txt.indexOf(startEndOfMarkup, indexStartOfMarkup) + startEndOfMarkup.length();
                    } else {

                        break;
                    }
                }

                // löscht den vorderen Teil des macros bis zum Text
                sbStartWikiMarup.delete(indexStartOfMarkup, indexStartMiddelOfMarkup);

                // gelöschter index den ich bei den andern mit ein berechnen muss
                int distance = indexStartMiddelOfMarkup - indexStartOfMarkup;

                // aktualisiert die Werte: Middel und End, sonst wird etwas ganz anders gelöscht, weil sich der ganze index verschoben hat. aber
                //indexStartMiddelOfMarkup = sbStartWikiMarup.indexOf(startMiddelOfMarkup);
                //indexStartEndOfMarkup = sbStartWikiMarup.indexOf(startEndOfMarkup) + startEndOfMarkup.length();

                // Index wurde durchs löschen verschoben, deswegen muss ich die Werte ändern
                indexStartMiddelOfMarkup = indexStartMiddelOfMarkup - distance;
                indexStartEndOfMarkup =  indexStartEndOfMarkup - distance;


                // ????
                sbStartWikiMarup.delete(indexStartMiddelOfMarkup, indexStartEndOfMarkup);

                // setzt an dem start index an der stelle das macro war, welches jetzt gelöscht ist ein <p> ein
                sbStartWikiMarup.insert(indexStartOfMarkup, startOfMarkupPTag);

                // wandelt der Strinbuffer zum String um
                txt = sbStartWikiMarup.toString();
            } else {

                break;
            }
        }


        // Ende des Macros entfernen

        // Bestandteile vom Ende des macros
        String markupEndeAnfang = "]]></ac:plain-text-body>";
        String markupEndeEnde = "</ac:structured-macro>";

        // sucht den Index des Anfang des Endes und des Ende des Ende mithilfe der Bestandteile
        int indexOfMarkupEndeAnfang = txt.indexOf(markupEndeAnfang);
        int indexOfMarkupEndeEnde = txt.indexOf(markupEndeEnde);

        // wenn der Anfang vorhanden ist( nicht mius 1)
        if (indexOfMarkupEndeAnfang != -1) {

            // wird der Index + die länge des Strings zusammengerechnet, um das tatsächliche Ende ( der index dazu ) zu bekommen
            indexOfMarkupEndeEnde = txt.indexOf(markupEndeEnde) + markupEndeEnde.length();
        } else {

            // sollte das nicht der fall sein wird die variable auf -1 gesetzt, was später überprüft wird. Weil wenn kein ende nicht da ist, soll auch nichts entfernt werden
            indexOfMarkupEndeEnde = -1;
        }

        // ???????
        boolean boolWhileWikiMarkupEndDelete = false;

        // solange der wert falsch ist wird die schleife nihct verlassen
        while (boolWhileWikiMarkupEndDelete == false) {

            // wenn Anfang und ende höher als -1 (also gefunden wurden) und der start kleiner ist als das Ende
            if (indexOfMarkupEndeAnfang > -1 && indexOfMarkupEndeEnde > -1) {

                // StringBudder sbEndeWikiMarkup wird erstellt
                StringBuffer sbEndWikiMarkup = new StringBuffer(txt);

                // solange die Schleife nicht verlassen wird oder der Wert verändert läuft sie ewig
                while (true) {

                    // Wenn der Anfang größer als das ende ist
                    if (indexOfMarkupEndeAnfang > indexOfMarkupEndeEnde) {

                        // wird neu gesucht nach dem EndeEnde ab dem Ende Abfang und dazu wird noch die länge des EndeEnde Strings dazuberechnet
                        indexOfMarkupEndeEnde = sbEndWikiMarkup.indexOf(markupEndeEnde, indexOfMarkupEndeAnfang) + markupEndeEnde.length();
                    } else {

                        break;
                    }
                }


                // txt in StringBuffer umwandeln und vom indexMarkupStart - indexEndofMarkup werden entfernt
                sbEndWikiMarkup.delete(indexOfMarkupEndeAnfang, indexOfMarkupEndeEnde);

                //indexMarkupStart: <p> tag eingesetzt per Index
                sbEndWikiMarkup.insert(indexOfMarkupEndeAnfang, endOfMarkupPTag);

                // Stringbuffer sbEndWikiMarkup zum String zurückwandeln
                txt = sbEndWikiMarkup.toString();

                // Index werte aktualisieren
                indexOfMarkupEndeAnfang = txt.indexOf(markupEndeAnfang);
                indexOfMarkupEndeEnde = txt.indexOf(markupEndeEnde) + markupEndeEnde.length();

            } else {

                break;
            }
        }
        return txt;
    }

    //Entfernen wiki markup in einer TABELLE
    public String wikiMarkupTableEntfernen(String txt) {

        // Schleifenvaiable, die für den abbruch der Schleife verantortlich ist
        double markupTableDelete = 0;

        // Schleife
        while (markupTableDelete == 0) {

            // Anfang & Ende der Tabelleninhalte werden definiert
            String markupTableMarkupAnfang = "<p>&lt;ac:structured-macro ac:name=\"unmigrated-wiki-markup\" ac:schema-version=\"1\" ac:macro-id=";
            String markupTableMarkupEnde = "&gt;&lt;ac:plain-text-body&gt;&lt;![CDATA[</p>\n";

            // Index für den Anfang wird gesucht, für das ende initilisiert
            int indexOfMarkupTableAnfang = txt.indexOf(markupTableMarkupAnfang);
            int indexOfmarkupTableMarkupEnde;

            // Anfang gefunden
            if (indexOfMarkupTableAnfang != -1) {

                // Index für das Ende wird Gesucht und mit seiner länge addiert um auf den Endwert zu kommen
                indexOfmarkupTableMarkupEnde = txt.indexOf(markupTableMarkupEnde) + markupTableMarkupEnde.length();

            } else {

                // Anfang nicht gefunden: Ende auf nicht gefunden setzen, Schleifenvariable plus 0,5 rechnen
                indexOfmarkupTableMarkupEnde = -1;
                markupTableDelete = markupTableDelete + 0.5;
            }

            // solange Anfang nicht gefunden
            while (indexOfMarkupTableAnfang != -1) {

                // index dekrement, um Text weiter vorn zu durchsuchen
                indexOfMarkupTableAnfang--;

                // der Index (Schleifenvariable) wird zum char vom txt aus zum String gemacht
                String tableStart = Character.toString(txt.charAt(indexOfMarkupTableAnfang));

                // Wenn der String "<" enthält
                if (tableStart.equalsIgnoreCase("<")) {

                    break;
                }
            }

            // solange das Ende gefunden wurde
            while (indexOfmarkupTableMarkupEnde != -1) {

                // inkrement um den Text weiter hinten zu suchen
                indexOfmarkupTableMarkupEnde++;

                // der Index (Schleifenvariable) wird zum char vom txt aus zum String gemacht
                String tableEnd = Character.toString(txt.charAt(indexOfmarkupTableMarkupEnde));

                // Wenn der String ">" beinhaltet
                if (tableEnd.equalsIgnoreCase(">")) {

                    // Wenn es gefunden wird noch plus eins
                    indexOfmarkupTableMarkupEnde++;

                    break;
                }
            }

            // Wenn der Anfang und das Ender der Tabellenrückstände gefunden wurden
            if (indexOfMarkupTableAnfang != -1 && indexOfmarkupTableMarkupEnde != -1) {

                // Tabellenrückstände werden mit Stringbuffer per Index entfernt und wieder zum String gemacht
                StringBuffer sbTableMarkupStart = new StringBuffer(txt);
                sbTableMarkupStart.delete(indexOfMarkupTableAnfang, indexOfmarkupTableMarkupEnde);
                txt = sbTableMarkupStart.toString();
            }

            //Entfernen wiki markup in einer TABELLE ENDE
            String markupTableMarkupEndeAnfang = "<p>]]&gt;&lt;/ac:plain-text-body&gt;&lt;/ac:structured-macro&gt;</p>";

            // EndeAnfang Index wird gesucht, EndeEnde deklariert
            int indexOfMarkupTableMarkupEndeAnfang = txt.indexOf(markupTableMarkupEndeAnfang);
            int indexOfmarkupTableMarkupEndeEnde;

            // Wenn Anfang gefunden
            if (indexOfMarkupTableAnfang != -1) {

                // Index für das Ende wird Gesucht und mit seiner länge addiert um auf den Endwert zu kommen
                indexOfmarkupTableMarkupEndeEnde = indexOfMarkupTableMarkupEndeAnfang + markupTableMarkupEndeAnfang.length();
            } else {

                // Anfang nicht gefunden: Ende auf nicht gefunden setzen, Schleifenvariable plus 0,5 rechnen
                indexOfmarkupTableMarkupEndeEnde = -1;
                markupTableDelete = markupTableDelete + 0.5;
            }

            // Solange der Anfang gefunden wurde
            while (indexOfMarkupTableMarkupEndeAnfang != -1) {

                // decrement um text zu durchsuchen
                indexOfMarkupTableMarkupEndeAnfang--;

                // der Index (Schleifenvariable) wird zum char vom txt aus zum String gemacht
                String tableStartEndMarkup = Character.toString(txt.charAt(indexOfMarkupTableMarkupEndeAnfang));

                // Wenn "<" im Text gefunden wurde
                if (tableStartEndMarkup.equalsIgnoreCase("<")) {

                    break;
                }
            }

            // Solange des Ende gefunden wurde
            while (indexOfmarkupTableMarkupEndeEnde != -1) {

                // increment um text zu durchsuchen
                indexOfmarkupTableMarkupEndeEnde++;

                // der Index (Schleifenvariable) wird zum char vom txt aus zum String gemacht
                String tableEndEndMarkup = Character.toString(txt.charAt(indexOfmarkupTableMarkupEndeEnde));

                // Wenn ">" gefunden wurde
                if (tableEndEndMarkup.equalsIgnoreCase(">")) {

                    // Wenn es gefunden wird noch plus eins
                    indexOfmarkupTableMarkupEndeEnde++;
                    break;
                }
            }

            // ist das ende und der Anfang gefunden
            if (indexOfMarkupTableMarkupEndeAnfang != -1 && indexOfmarkupTableMarkupEndeEnde != -1) {

                // löschen des zweiten (EndeEnde) teils mit Stringbuffer und index
                StringBuffer sbTableMarkupEnd = new StringBuffer(txt);
                sbTableMarkupEnd.delete(indexOfMarkupTableMarkupEndeAnfang, indexOfmarkupTableMarkupEndeEnde);
                txt = sbTableMarkupEnd.toString();
            }
        }
        return txt;
    }
}