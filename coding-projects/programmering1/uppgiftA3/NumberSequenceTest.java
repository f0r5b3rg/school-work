// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        sequence = new ArrayNumberSequence(realNumbers);
        // sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();
        // Length.
        out.println("Length: " + sequence.length());
        // Upper and lower bound.
        out.println("Upper bound: " + sequence.upperBound());
        out.println("Lower bound: " + sequence.lowerBound());
        // Number at and position of.
        out.println("Numbers at / positions of: ");
        for (int i = 1; i <= sequence.length(); i++) {
            out.println("numberAt(" + i + ") gives: " + sequence.numberAt(i));
            out.print("positionOf(numberAt(" + i + ") = " + i);
            if (sequence.positionOf(sequence.numberAt(i)) == i) {
                out.println(" OK!");
            } else {
                out.println(" NOT OK!");
            }
        }
        // Is Increasing/Decreasing
        out.println("Is increasing: " + sequence.isIncreasing());
        out.println("Is decreasing: " + sequence.isDecreasing());
        // Contains
        out.println("Contains 8.0: " + sequence.contains(8.0) + 
                " Contains 6.0: " + sequence.contains(6.0));
        // Add
        out.println("Adding 9.0. Sequence before: \n" + sequence);
        sequence.add(9.0);
        out.println("Sequence after: \n" + sequence);
        // Insert
        out.println("Inserting 24.0 at position 3. Sequence before: \n" + sequence);
        sequence.insert(3, 24.0);
        out.println("Sequence after: \n" + sequence);
        // Remove at
        out.println("Removing number at position 3. Sequence before: \n" + sequence);
        sequence.removeAt(3);
        out.println("Sequence after: \n" + sequence);
    }
}
