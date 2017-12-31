/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.helpers;

import java.util.Random;
import nl.meine.sortingvisualiser.sorters.BubbleSort;
import nl.meine.sortingvisualiser.sorters.InsertionSort;
import nl.meine.sortingvisualiser.sorters.Sorter;

/**
 *
 * @author Meine Toonen
 */
public class App {

    public static void main(String[] a) {
        int number = 50;

        Random rand = new Random();
        int max = 128;

        int[] data1 = new int[number];
        int[] data2 = new int[number];
        for (int i = 0; i < data1.length; i++) {
            int val = rand.nextInt(max) + 1;
            data1[i] = val;
            data2[i] = val;
        }
        
        BubbleSort s1 = new BubbleSort(data1,0);
      //  InsertionSort s2 = new InsertionSort(data2,1);
        Thread t1 = new Thread(s1);
   //     Thread t2 = new Thread(s2);
        t1.start();
   //     t2.start();
    }

}
