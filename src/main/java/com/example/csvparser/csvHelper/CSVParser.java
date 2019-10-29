package com.example.csvparser.csvHelper;

public class CSVParser {
    public String parseCSVString(String csv) {


        String finishedOutput = "";


        String[] lines;
        lines = csv.split("\\r\\n|\\n");
        for (int i = 0; i < lines.length; i++)
        {
            String line;
            line = lines[i];

            String finishedString = "";
            String[] pieces;
            pieces = line.split("");

            Boolean startsWithQuote = false;
            String tempX = "";

            if (pieces[0].equals("\"")) {
                startsWithQuote = true;
            }


            String parcedStr = "";
            Boolean startNewPiece = false;

            for (int j = 1; j < pieces.length; j++) {
                if (startsWithQuote) {
                    if (startNewPiece == true) {

                        if (pieces[j].equals("\"")) {
                            startNewPiece = false;
                        }
                    } else if (!pieces[j].equals("\"")) {
                        tempX += pieces[j];
                    } else {
                        parcedStr += "[" + tempX + "]";

                        finishedString += parcedStr;
                        parcedStr = "";
                        tempX = "";
                        startNewPiece = true;

                        if (finishedString.length() == 0) {
                        }

                        if (j + 2 < pieces.length && !pieces[j + 2].equals("\"")) {
                            startsWithQuote = false;
                        }
                    }

                } else {
                    if (pieces[j] == "," && tempX.length() == 0) {
                    } else if (!pieces[j].equals(",")) {
                        tempX += pieces[j];
                    } else {
                        parcedStr += "[" + tempX + "]";
                        finishedString += parcedStr;
                        if (finishedString.length()== 0) {

                        }
                        parcedStr = "";
                        tempX = "";
                        startNewPiece = true;
                        if (j + 1 < pieces.length && !pieces[j + 1].equals("\"")) {
                            startsWithQuote = true;
                        }
                    }
                }

            }

            if (finishedOutput.length() > 0) {
                finishedOutput += "\n";
            }
            finishedOutput += finishedString;

        }
        return finishedOutput;

    }


}

