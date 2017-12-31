/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.sorters;

/**
 *
 * @author Meine Toonen
 */
public class CombSorter extends Sorter{

    public CombSorter(int[] data, int number) {
        super(data, "Comb Sorter", number);
    }

    @Override
    public void sort() {
        int gap = data.length;
        double shrink = 1.3;
        boolean sorted = false;
        
        do {            
            gap = (int)Math.floor(gap/shrink);
            if(gap > 1){
                sorted = false;
            }else{
                gap = 1;
                sorted = true;
            }
            bubble(gap);
        } while (!sorted);
        
    }
    
    private void bubble(int gap) {
        for (int i = 0; i < (data.length - gap); i++) {
            int valIndex = i;
            int checkIndex = i + gap;
            int val = data[valIndex];
            int checkVal = data[checkIndex];
            visualize(valIndex, checkIndex);
            if(val > checkVal){
                data[valIndex] = checkVal;
                data[checkIndex] = val;
            }
            //visualize(checkIndex, checkVal);
            
        }
    }
    
}
