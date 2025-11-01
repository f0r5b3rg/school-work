// ArrayNumberSequence.java

/****************************************************************

  ArrayNumberSequence represents a sequence of real numbers.
  Such a sequence is defined by the interface NumberSequence.
  The class uses an array to store the numbers in the sequence.

  Author
  Fadil Galjic

 ****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
    // numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
        if (numbers.length < 2)
            throw new IllegalArgumentException("not a sequence");

        this.numbers = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            this.numbers[i] = numbers[i];
    }

    // toString returns the character string representing this
    // sequence
    public String toString ()
    {
        String s = "";
        for (int i = 0; i < numbers.length - 1; i++)
            s = s + numbers[i] + ", ";
        s = s + numbers[numbers.length - 1];

        return s;
    }
    
    // length returns the length of the number sequence.
    public int length () {
        return numbers.length;
    }
    
    // upperBound returns the mathematical upper bound of the number sequence.
    public double upperBound() {
        // Set initial value
        double upperBound = numbers[0];
        // Compare every number to the previous highest number.
        for (int i = 1; i < numbers.length; i++) {
            if (upperBound < numbers[i]) {
                // Replace the highest number when a higher one is found.
                upperBound = numbers[i];
            }
        }
        return upperBound;
    }

    // lowerBound returns the mathematical lower bound of the number sequence.
    public double lowerBound() {
        // Functions the same as upperBound, except it searches for lower
        // numbers.
        double lowerBound = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (lowerBound > numbers[i]) {
                lowerBound = numbers[i];
            }
        }
        return lowerBound;
    }

    // numberAt returns the number at the given position, starting from 1.
    public double numberAt (int position)
            throws IndexOutOfBoundsException {
            // Compensate for user input indexing from 1.
            position = position - 1;
            // Checks if the position exists in the number sequence.
            if (position < 0 || position > numbers.length) {
                throw new IndexOutOfBoundsException(
                        "No number exists at position " + position + ".");
            }
            return numbers[position];
    }

    // positionOf returns the first position of the given number, if it exists. 
    // Returns -1 if it does not.
    public int positionOf (double number) {
        // Loop through number sequence until the given number is found.
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i + 1;
            }
        }
        return -1;
    }

    // isIncreasing returns a true if the number sequence is increasing over
    // all its numbers, otherwise returns false.
    public boolean isIncreasing() {
        // Loop through the number sequence, stopping and returning false
        // if any number is not larger than the previous.
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }
        return true;
    }

    // isDecreasing returns a true if the number sequence is decreasing over
    // all its numbers, otherwise returns false.
    public boolean isDecreasing() {
        // Functions the same was as isDecreasing, except it stops looking when
        // a number is not smaller than the previous.
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) {
                return false;
            }
        }
        return true;
    }

    // contains returns true if the number sequence contains the given number.
    // Otherwise returns false.
    public boolean contains (double number) {
        // Loop through the number sequence, stopping and returning true if 
        // the given number is found.
        for (int i = 0; i < numbers.length; i++) {
            if (number == numbers[i]) {
                return true;
            }
        }
        return false;
    }

    // add appends the given number to the end of the number sequence.
    public void add (double number) {
        // Create a new double array one size larger than the current number
        // sequence.
        double[] newNumbers = new double[numbers.length + 1];
        // Add all previous numbers into the new number sequence.
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }
        // Add the new number to the end of the number sequence.
        newNumbers[numbers.length] = number;
        // Replace the old number sequence.
        numbers = newNumbers;
    }

    // insert adds the given number at a specified position, starting at 1,
    // pushing the following numbers forward one step.
    public void insert (int position, double number) 
            throws IndexOutOfBoundsException {
            // Compensate for user input indexing from 1.
            position = position - 1;
            // Checks if the position exists in the number sequence.
            if (position < 0 || position > numbers.length + 1) {
                throw new IndexOutOfBoundsException(
                        "Invalid position");
            }
            
            // Create a new double array one size larger than the current
            // number sequence.
            double[] newNumbers = new double[numbers.length + 1];
            // Add all previous numbers into the new number sequence until
            // the given position is reached, at which point the given number
            // is inserted. Then add the remaining old numbers.
            for (int i = 0; i < newNumbers.length; i++) {
                if (i == position){
                    newNumbers[i] = number;
                } else if (i > position) {
                    newNumbers[i] = numbers[i - 1];
                } else {
                    newNumbers[i] = numbers[i];
                }
            }
            // Replace the old number sequence.
            numbers = newNumbers;
    }

    // removeAt removes a number at the given position, starting at 1, 
    // moving all following numbers back one step.
    public void removeAt (int position) 
            throws IndexOutOfBoundsException, IllegalStateException {
            // Compensat for user input indexing from 1.
            position = position - 1;
            // Check if the position exists in the number sequence.
            if (position < 0 || position > numbers.length + 1) {
                throw new IndexOutOfBoundsException(
                        "Invalid position");
            }
            // Check if there are enough numbers in the number sequence to
            // remove one without leaving only one number.
            if (numbers.length < 2) {
                throw new IllegalStateException(
                        "Only two numbers remaining in sequence, " +
                        "cannot remove more.");
            }
            // Create a new double array one size smaller than the current
            // number sequence.
            double[] newNumbers = new double[numbers.length - 1];
            // Add all the previous numbers into the new number sequence until
            // the given position is reached, at which point it is skipped.
            // Then add the remaining old numbers.
            for (int i = 0; i < newNumbers.length; i++) {
                if (i >= position) {
                    newNumbers[i] = numbers[i + 1];
                } else {
                    newNumbers[i] = numbers[i];
                }
            }
            numbers = newNumbers;
    }

    // asArray returns the current number sequence as an array.
    public double[] asArray() {
        return numbers;
    }
}

