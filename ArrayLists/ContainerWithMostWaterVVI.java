/*
 *    Container with Most Water
 *   -> For given n lines on x-axis, use 2 lines to form a container such that it holds
 *      maximum water.
 *    height= [1,8,6,2,5,4,8,3,7]
 */

 import java.util.ArrayList;

public class ContainerWithMostWaterVVI {
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int ht=Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater , currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height= new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));
    }
}

/*
 *     Output
 *     49
 */


/*
The storeWater method takes an ArrayList of integers height as input and returns an integer representing the maximum water that can be held.

Inside the storeWater method, there are two nested loops. The outer loop (for(int i=0; i<height.size(); i++)) iterates over the lines starting from the first line, and the inner loop (for(int j=i+1; j<height.size(); j++)) iterates over the lines starting from the line immediately to the right of the current outer loop line.

For each pair of lines represented by indices i and j, the code calculates the height of the container, which is the minimum height between the lines (int ht = Math.min(height.get(i), height.get(j))).

It also calculates the width of the container, which is the difference between the indices i and j (int width = j - i).

The code then calculates the current water that can be held by multiplying the height and width of the container (int currWater = ht * width).

The maxWater variable keeps track of the maximum water found so far, and it is updated whenever a larger water volume is encountered (maxWater = Math.max(maxWater, currWater)).

After both loops have finished, the maxWater variable contains the maximum water that can be held between any two lines in the height ArrayList.

In the main method, you create an ArrayList called height and populate it with integer values representing the heights of the lines.

You call the storeWater method with the height ArrayList as an argument and then print the result, which is the maximum water that can be held between any two lines.

The expected output for the provided height ArrayList is 49, which represents the maximum water that can be held between the lines with heights 8 and 7
*/
