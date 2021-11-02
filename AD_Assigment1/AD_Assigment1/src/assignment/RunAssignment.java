package assignment;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class RunAssignment {
    public static void main(String[] a) throws IOException, ParseException {
        /*
         *   Illustrates use of convert routine.
         */

        Scanner sc = new Scanner(new File("TestData.txt"));
        String re = sc.nextLine();
        while (sc.hasNextLine()) {
            System.out.println("Converting regular expression " + re + " to RegExp expression tree");
            try {
                RegExp.setNextStateNum(0);
                RegExp r = (new RegExp2AST(re)).convert();
                System.out.println("No syntax errors");
                System.out.println("Original fully parenthesised regular expression : " +
                        r.decompile());
                System.out.println("\nConverting regular expression " + re + " to NFA");
                Nfa n = r.makeNfa();
                System.out.println(n);

                Dfa d = new Dfa();
                String testData = sc.nextLine();
                while (!testData.equals("//")) {
                /* to test if each
                /* each string belongs to the current language;
                 */
                    //will uncomment this when we finished the DFA class
                   // if (d.isPartOfTheLanguage(0,0,testData))
                        System.out.println(testData + " is the member of the language denoted by" + re);
                  //  else
                        System.out.println(testData + " is NOT the member of the language denoted by" + re);
                    //we will edit this when we have the a code to test with
                    testData = sc.nextLine();
                }
                if (sc.hasNextLine())
                    re = sc.nextLine();
                System.out.println();

            } catch (ParseException ex) {
                System.out.println("Error at/near position " + ex.getErrorOffset() + " : " + ex.getMessage());
            }

        }
        sc.close();
    }
}
