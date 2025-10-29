// SynonymHandler

/****************************************************************

  SynonymHandler handles information about synonyms for various
  words.

  The synonym data can be read from a file and handled in various
  ways. These data consists of several lines, where each line begins
  with a word, and this word is followed with a number of synonyms.

  The synonym line for a given word can be obtained. It is possible
  to add a synonym line, and to remove the synonym line for a given
  word. Also a synonym for a particular word can be added, or
  removed. The synonym data can be sorted. Lastly, the data can be
  written to a given file.

Author: Fadil Galjic

 ****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
                     // IOException

class SynonymHandler
{
    // readSynonymData reads the synonym data from a given file
    // and returns the data as an array
    public static String[] readSynonymData (String synonymFile)
            throws IOException
        {
            BufferedReader reader = new BufferedReader(
                    new FileReader(synonymFile));
            int numberOfLines = 0;
            String synonymLine = reader.readLine();
            while (synonymLine != null)
            {
                numberOfLines++;
                synonymLine = reader.readLine();
            }
            reader.close();

            String[] synonymData = new String[numberOfLines];
            reader = new BufferedReader(new FileReader(synonymFile));
            for (int i = 0; i < numberOfLines; i++)
                synonymData[i] = reader.readLine();
            reader.close();

            return synonymData;
        }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData (String[] synonymData,
            String synonymFile) throws IOException
    {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    private static int synonymLineIndex (String[] synonymData,
            String word) throws IllegalArgumentException
    {
        int delimiterIndex = 0;
        String w = "";
        int i = 0;
        boolean wordFound = false;
        while (!wordFound  &&  i < synonymData.length)
        {
            delimiterIndex = synonymData[i].indexOf('|');
            w = synonymData[i].substring(0, delimiterIndex).trim();
            if (w.equalsIgnoreCase(word))
                wordFound = true;
            else
                i++;
        }

        if (!wordFound)
            throw new IllegalArgumentException(
                    word + " not present");

        return i;
    }

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine (String[] synonymData,
            String word) throws IllegalArgumentException
    {
        int index = synonymLineIndex(synonymData, word);

        return synonymData[index];
    }

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data.
    public static String[] addSynonymLine (String[] synonymData,
            String synonymLine)
    {
        String[] synData = new String[synonymData.length + 1];
        for (int i = 0; i < synonymData.length; i++)
            synData[i] = synonymData[i];
        synData[synData.length - 1] = synonymLine;

        return synData;
    }

    // removeSynonymLine accepts synonym data, and removes
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String[] removeSynonymLine (String[] synonymData,
            String word) throws IllegalArgumentException {
        // Get index of synonym line to be removed.
        int index = synonymLineIndex(synonymData, word);
        // Prepare new string array to contain processed data.
        String[] newData = new String[synonymData.length - 1];
        // Copy data into new array.
        for (int n = 0; n < synonymData.length - 1; n++){
            // Skips the synonym line to be removed at its index.
            if (n >= index) {
                newData[n] = synonymData[n+1];
            } else {
                newData[n] = synonymData[n];
            }
        }
        return newData;
    }


    // getSynonyms returns synonyms in a given synonym line.
    private static String[] getSynonyms (String synonymLine) {
        // Find index of char where synonyms appear in the synonym line.
        int delimiterIndex = synonymLine.indexOf('|');
        // Separates the word and synonyms in synonymLine, 
        // storing the part with synonyms.
        String synonyms = synonymLine.substring(delimiterIndex + 1, 
                synonymLine.length());
        // Removes all spaces, leaving only words separated by commas.
        synonyms = synonyms.replace(" ", "");
        // Splits at ",", storing the result in an array.
        String[] result = synonyms.split(",");
        // Returns an array of size 1 with an empty string if no synonyms 
        // are present in the given synonym line.
        return result;
    }

    // addSynonym accepts synonym data, and adds a given
    // synonym for a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static void addSynonym (String[] synonymData,
            String word, String synonym) throws IllegalArgumentException {
        int index = synonymLineIndex(synonymData, word);
        // if the first synonym returned by getSynonyms is an empty string 
        // there are no synonyms present in the synonymLine, in which case we 
        // omit adding a leading comma.
        if (!getSynonyms(getSynonymLine(synonymData, word))[0].equals("")) {
            synonymData[index] += ", ";
        }
        // append synonym
        synonymData[index] += synonym;
    }

    // removeSynonym accepts synonym data, and removes a given
    // synonym for a given word.
    // If the given word or the given synonym is not present, an
    // exception of the type IllegalArgumentException is thrown.
    // If there is only one synonym for the given word, an
    // exception of the type IllegalStateException is thrown.
    public static void removeSynonym (String[] synonymData,
            String word, String synonym)
            throws IllegalArgumentException, IllegalStateException {
            // Get the synonyms.
            String synonymLine = getSynonymLine(synonymData, word);
            String[] synonyms = getSynonyms(synonymLine);

            // Throw exception if there are not enough synonyms to remove.
            if (synonyms.length <= 1) {
                throw new IllegalStateException(
                        "Only one or fewer synonyms remaining");
            }

            // Throw exception if the word is not present.
            int synonymIndex = synonymLine.indexOf(synonym);
            if (synonymIndex == -1) {
                throw new IllegalArgumentException(word +
                        "not present");
            }

            // Sets the synonymline to the word plus the divider.
            synonymData[synonymLineIndex(synonymData, word)] = word + " | ";

            // Appends every synonym except the one to be removed.
            for (int i = 0; i < synonyms.length; i++) {
                if (!synonyms[i].equals(synonym)) {
                    addSynonym(synonymData, word, synonyms[i]);
                }
            }
        }

    // sortIgnoreCase sorts an array of strings, using
    // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings) {
        // lowestIndex represents the index of the current "lowest" string, 
        // as in the one that is alphabetically ahead of the other strings
        // it's compared to.
        int lowestIndex = 0; 

        // Iterate over the strings once for every string in the array.
        // Starting at the leftmost position the starting position is moved
        // one step to the right every iteration.
        for (int i = 0; i < strings.length; i++) {
            // Set the lowest index to i. 
            lowestIndex = i;
            // Search for the alphabetically first string among the strings,
            // starting at the position to the right of the previously found
            // first string.
            for (int k = i + 1; k < strings.length; k++) {
                // compareTo returns a negative number if strings[k] is
                // alphabetically ahead of strings[lowestIndex].
                if (strings[lowestIndex].toLowerCase().compareTo(
                            strings[k].toLowerCase()) > 0) {
                    lowestIndex = k; 
                }
            }
            // Swap position of the new lowest with the string at index i.
            String temp = strings[i];
            strings[i] = strings[lowestIndex];
            strings[lowestIndex] = temp;
        }
    }


    // sortSynonymLine accepts a synonym line, and sorts
    // the synonyms in this line
    private static String sortSynonymLine (String synonymLine) {
        // Get the synonyms in the given synonym line.
        String[] synonymsToSort = getSynonyms(synonymLine);
        String word = synonymLine.split("\\|")[0];
        // Note that word will contain a trailing space when it's
        // split in this manner.

        // sort the synonyms.
        sortIgnoreCase(synonymsToSort);

        // Construct the first part of the sorted string
        String result = word + "| " + synonymsToSort[0];
        // Add the remaining sorted synonyms.
        for (int i = 1; i < synonymsToSort.length; i++) {
            result += ", " + synonymsToSort[i];
        }

        return result;
    }

    // sortSynonymData accepts synonym data, and sorts its
    // synonym lines and the synonyms in these lines
    public static void sortSynonymData (String[] synonymData) {
        // Create a string array containing all words in synonymData.
        String[] words = new String[synonymData.length];
        for (int i = 0; i < synonymData.length; i++) {
            words[i] = synonymData[i].split("\\|")[0].trim();
        }

        // Sort the words.
        sortIgnoreCase(words);

        // Create a new synonymData which will be filled with the sorted
        // contents of synonymData.
        String [] sortedData = new String[synonymData.length];
        // Tnitialize variables to use in for loop.
        String synonymLineToSort = "";
        String sortedSynonymLine = "";

        // For every word, find the corresponding synonym line in
        // synonym data, sort its synonyms and add the line to
        // the new synonymData
        for (int i = 0; i < words.length; i++) {
            // Find the synonym line corresponding to the sorted word.
            synonymLineToSort = synonymData[synonymLineIndex(synonymData, words[i])];
            // Sort its synonyms.
            sortedSynonymLine = sortSynonymLine(synonymLineToSort);
            // Add to new sortedData.
            sortedData[i] = sortedSynonymLine;
        }

        // Replace the data in the original string array.
        for (int i = 0; i < sortedData.length; i++) {
            synonymData[i] = sortedData[i];
        }
    }
}
