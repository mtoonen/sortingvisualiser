/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.sorters;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Meine Toonen
 */
public class InsertionSort extends Sorter {

    public InsertionSort(int[] data, int number) {
        super(data, "Insertion Sort", number);
    }

    public static void main(String[] args) {

    }

    @Override
    public void sort() {
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int tempI = i;
            for (int j = i - 1; j >= 0; j--) {
                int toCheck = data[j];
                if (value < toCheck) {
                    data[j] = value;
                    data[tempI] = toCheck;
                    visualize(tempI, j);
                    tempI -= 1;
                    value = data[tempI];
                } else {
                    break;
                }

            }
        }

    }

}
