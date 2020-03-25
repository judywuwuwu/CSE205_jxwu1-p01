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
    private static final  int RUNS_UP = 1;
    private static final  int RUNS_DN = 0;

    public static void main(String[] args) {
        try {
            Main mainObject = new Main();
            mainObject.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void run() throws FileNotFoundException {
        Scanner readInputFile = null;
        try {
            readInputFile = new Scanner(new File("p01-in.txt"));
        }
        catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open 'p01-in.txt' for reading. The program is ending");
            System.exit(-100);
        }

        PrintWriter writeOutputFile;
        try {
            writeOutputFile = new PrintWriter("p01-runs.txt");
        }
        catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open 'p01-runs.txt' for reading. The program is ending");
            System.exit(-200);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list= readInputFile("p01-in.txt");
        ArrayList<Integer> listRunsUpCount = new ArrayList<>();
        ArrayList<Integer> listRunsDnCount = new ArrayList<>();
        listRunsUpCount = findRuns(list, RUNS_UP);
        listRunsDnCount = findRuns(list, RUNS_DN);
        ArrayList<Integer> listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);

        writeOutputFile("p01-runs.txt" , listRunsCount);

    }//end run method

/* */


    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir) {
        int i = 0, k = 0;
        ArrayList<Integer> listRunsCount = arrayListCreate(pList.size(), 0);
        while (i < pList.size() - 1) {
            if (pDir == RUNS_UP && pList.get(i) <= pList.get(i + 1)) {
                k++;
            }
            else if (pDir == RUNS_DN && pList.get(i) >= pList.get(i+1)) {
                k++;
            }
            else if (k != 0) {
                listRunsCount.set(k, listRunsCount.get(k)+1);
                k = 0;
            }
            i++;
        }
        if (k != 0) {
            listRunsCount.set(k, listRunsCount.get(k)+1);
        }
        return listRunsCount;
    }

/* */


    public ArrayList<Integer> mergeLists(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount){
        ArrayList<Integer> listRunsCount = arrayListCreate(pListRunsUpCount.size(), 0);
        for(int i=0; i < pListRunsUpCount.size()-1; i++) {
            listRunsCount.set(i, pListRunsUpCount.get(i) + pListRunsDnCount.get(i));
        }
        return listRunsCount;
    }


    /* */
    public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<pSize; i++) {
            list.add(pInitValue);
        }
        return list;
    }


    /* */
    public  void writeOutputFile(String pFilename, ArrayList<Integer> pListRuns)  throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File(pFilename));
        int totalpListRuns = 0;
        for (int element : pListRuns) {
            totalpListRuns = totalpListRuns + element;
        }
        out.println("runs total: " + totalpListRuns);
        for (int k = 1; k < pListRuns.size() ; k++) {
            out.println("runs_" + k + ": "  + pListRuns.get(k));
        }
        out.close();
    }

/* */
    public  ArrayList<Integer> readInputFile(String pFilename) throws FileNotFoundException{
        Scanner in = new Scanner(new File(pFilename));
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNext()){
            list.add(in.nextInt());
        }
        in.close();
        return list;
    }
}
