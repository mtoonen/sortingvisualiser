/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.sorters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meine Toonen
 */
public class BubbleSort extends Sorter{

    
    public BubbleSort(int[] data, int number) {
        super(data, "Bubble Sort", number);
    }

    @Override
    public void sort() {
        int to = data.length;
        boolean bubbled = false;
        do{
            try {
                bubbled = bubble(data, to);
                to--;
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(bubbled);
    }
    
    private boolean bubble(int[] data, int to) throws InterruptedException{
        boolean bubbled = false;
        for (int i = 0; i < (to-1); i++) {
            int left = data[i];
            int right = data[i+1];
            visualize(i, i+1);
            if(left > right){
                data[i+1] = left;
                data[i] = right;
                bubbled=true;
            }
            
        }
        return bubbled;
    }

}
