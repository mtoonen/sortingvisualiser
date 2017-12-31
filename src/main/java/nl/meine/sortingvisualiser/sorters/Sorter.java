/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.sorters;

import nl.meine.sortingvisualiser.helpers.Visualiser;

/**
 *
 * @author Meine Toonen
 */
public abstract class Sorter implements Runnable{
    
    private Visualiser v;
    protected int[] data;
    
    public Sorter(int[] data, String title, int number){
        this.data = data;
        v = new Visualiser(data, number);
        v.init();
        v.setTitle(title);
        
    }
    
    public void visualize(int currentIndex, int indexToCheck) {
        v.setNewData(data, currentIndex, indexToCheck);
    }
    
    public abstract void sort();
    
    @Override
    public void run() {
        sort();
    }


}
