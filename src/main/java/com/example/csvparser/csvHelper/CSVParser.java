package com.example.csvparser.csvHelper;

public class CSVParser {
    public String parseCSVString(String csv) {


        String finishedOutput = "yeeeeeeet";


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
                    } else if (pieces[j] != ",") {
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


//
//    let lines = [];
//        lines = csvString.split(/\r\n|\n/); // splits at \r\n or \n and assigns the input to array lines
//
//
//
//        for ( let i = 0; i < lines.length; i++) {
//        let line;
//        line = lines[i]
//
//        finishedString = "";
//        let pieces = [];
//        pieces = line.split(""); // splits each character
//
//        //takes lines at index i and sets it to line. then it takes line and splits it at each character and assigns it to array pieces
//        let startsWithQuote = false;
//        // assigns startsWithQuote to boolean false in preparation for the if statement
//        let tempX = "";
//
//        if (pieces[0] == '"'){
//        startsWithQuote = true;
//        }
//
//
//        let parcedStr = "";
//        startNewPiece = false;

//        for (let i = 1; i < pieces.length; i++) {
//        if (startsWithQuote) {
//        if (startNewPiece == true) {
//
//        if (pieces[i] == '"') {
//        startNewPiece = false;
//        }
//        } else if (pieces[i] != '"'){
//        tempX += pieces [i];
//        } else {
//        parcedStr += "[" + tempX + "]";
//
//        finishedString += parcedStr;
//        parcedStr = "";
//        tempX = "";
//        startNewPiece = true;
//
//        if(finishedString.length == 0) {
//        }
//
//        if ( i + 2 < pieces.length && pieces [i + 2] != '"'){
//        startsWithQuote = false;
//        }
//        }
//
//        } else {
//        if (pieces [i] == ',' && tempX.length == 0){
//        }
//        else if (pieces[i] != ','){
//        tempX += pieces[i];
//        }
//        else{
//        parcedStr += "[" + tempX + "]";
//        finishedString += parcedStr;
//        if(finishedString.length == 0) {
//
//        }
//        parcedStr = "";
//        tempX = "";
//        startNewPiece = true;
//        if (i + 1 < pieces.length && pieces [i + 1] == '"'){
//        startsWithQuote = true;
//        }
//        }
//        }
//
//        }
//
//        if (finishedOutput.length > 0){
//        finishedOutput += "\n";
//        }
//        finishedOutput += finishedString;
//
//        }
//
//        return finishedOutput;
//
//        }
