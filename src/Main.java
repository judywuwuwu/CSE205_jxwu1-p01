/*
********************************************************************************************************
 CLASS: Main.java

 DESCRIPTION
 A description of the contents of this file.

 COURSE AND PROJECT INFO
 CSE205 Object Oriented Programming and Data Structures, Spring Session B and 2020
 Project Number: project-01

 AUTHOR: Judy x Wu, jxwu1, judywuwuwu@gmail.com
********************************************************************************************************
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    private static final Object RUNS_UP = 1;
    private static final Object RUNS_DN = 0;

    public static void main(String[] args) {

    }
    public void run() {

//        -- Note: In the Java implementation, main() would call run(), so in essence, run() becomes the starting point
//        -- of execution.
//                Method run() Returns Nothing
//        -- Make sure to catch and handle the FileNotFoundExceptions that may get thrown in readInputFile() and
//                -- writeOutputFile() when the input and output files cannot be opened for reading and writing.
        Scanner readInputFile;
        try {
            //readInputFile = new Scanner(new File("p01-in.txt").getAbsolutePath());
            readInputFile = new Scanner(new File("p01-in.txt"));
        } catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open 'p01-in.txt' for reading. The program is ending");
            System.exit(-100);
        }

        PrintWriter writeOutputFile;
        try {
            writeOutputFile = new PrintWriter("p01-runs.txt");

        } catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open 'p01-runs.txt' for reading. The program is ending");
            System.exit(-200);
        }

//      Declare ArrayList of Integers list ← readInputFile("p01-in.txt") -- Reads the integers from the input file
        ArrayList<Integer> list = new ArrayList<>();
        int x = readInputFile.nextInt();
        list.add(x);
//      Declare and create an ArrayList of Integers named listRunsUpCount
        ArrayList<Integer> listRunsUpCount = new ArrayList<>();

//       Declare and create an ArrayList of Integers named listRunsDnCount
        ArrayList<Integer> listRunsDnCount = new ArrayList<>();
    }//end run method
//       listRunsUpCount ← findRuns(list, RUNS_UP) -- RUNS_UP and RUNS_DN are named constants, it does not matter what
 //      listRunsDnCount ← findRuns(list, RUNS_DN) -- value you assign to them as long as the values are different

    //Declare int variables initialized to 0: i ← 0, k ← 0 -- the left arrow represents the assignment operator
    //        While i < pList.size() - 1 Do
//        If pDir is RUNS_UP and pList element at i is ≤pList element at i + 1 Then
//        Increment k
//        ElseIf pDir is RUNS_DN and pList element at i is ≥pList element at i + 1 Then
//        Increment k
//        Else
//        If k does not equal 0 Then
//        Increment the element at index k of listRunsCount
//        k ← 0
//        End if
//        End If
//        Increment i
//        End While
//        If k does not equal 0 Then
//        Increment the element at index k of listRunsCount
//        End If
    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir)
    {
        int i=0, k=0;
        ArrayList<Integer> listRunsCount = arrayListCreate(pList.size(), 0);
        while(i<pList.size()-1){

            if(pDir==RUNS_UP && pList.get(i) <= (pList.get(i+1)))
            {
                k++;
            }

            elseif(pDir==RUNS_DN && pList.get(i) >= (pList.get(i) +1))
            {
                k++;
            }
            elseif(k!=0){
                listRunsCount.get(k)++;
            }
            i++;
        }

        if(k!=0)
        {
            listRunsCount.get(k)++;
        }
        return listRunsCount;
    }

        //Declare ArrayList of Integers listRunsCount ← mergeLists(listRunsUpCount, listRunsDnCount)
        ArrayList<Integer> listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);

//    -- pList is the ArrayList of Integers that were read from "p01-in.txt". pDir is an int and is either RUNS_UP or RUNS_DN
//     -- which specifies in this method whether we are counting the number of runs up or runs down.
//      Method findRuns(pList : ArrayList of Integers, pDir : int) Returns ArrayList of Integers
//      End Method run

            public mergeList(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount){
                for(i=0; i <plistRunsUpCount.size()-1; i++) {
                    listRunsCount[i]= pListRunsUpCount[i] + pListRunsDnCount[i];
                }
                return listRunsCount;
            }


//        listRunsCount ← arrayListCreate(pList.size(), 0) -- size is the same as pList and each element is init'd to 0
            public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue)
            {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=0; i<pSize; i++) {
                    list.add(pInitValue);
                }
                return list;
            }
 // writeOutputFile("p01-runs.txt", listRunsCount)
    // Method writeOutputFile(String pFilename; pListRuns is ArrayList of Integers) Returns Nothing
    //-- Make sure to throw the FileNotFoundException that is raised when the output file cannot be opened for writing.
    //            out ← open pFilename for writing
    //out.println("runs_total: ", the sum of pListRuns)
    //    For k ← 1 to pListRuns.size() - 1 Do
    //out.println("runs_k: ", the element at index k of pListRuns)
    //    End For
    //    Close out
    //    End Method output


    }
}
