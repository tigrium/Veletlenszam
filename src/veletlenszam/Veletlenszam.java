/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veletlenszam;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MOHANET-KATA
 */
public class Veletlenszam {
    
    private static ArrayList<Integer> numbers;
    private static ArrayList<Integer> randomNumbers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random r = new Random();
        
        numbers = new ArrayList<>();
        
        for ( int i = 0; i < 1000; i++ ) {
            numbers.add(i);
        }
        
        System.out.println(numbers);
        
        randomNumbers = new ArrayList<>();
        
        while ( numbers.size() > 0 ) {
            int size = numbers.size();
            int index = r.nextInt(size);
            randomNumbers.add(numbers.get(index));
            numbers.remove(index);
        }
        
        System.out.println(randomNumbers);
        
    }
}
