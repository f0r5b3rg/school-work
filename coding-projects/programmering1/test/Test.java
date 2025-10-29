class Test {
    public static void main (String[] args) {
        String[] strings = {"lovely", "pretty", "pleasing", "graceful", "appealing", "charming"};
        int lowestIndex = 0; 

        for (int i = 0; i < strings.length; i++){
           lowestIndex = i;
            for (int k = i + 1; k < strings.length; k++){
                if (strings[lowestIndex].toLowerCase().compareTo(strings[k].toLowerCase()) > 0){
                    lowestIndex = k; 
                }
            }
            String temp = strings[i];
            strings[i] = strings[lowestIndex];
            strings[lowestIndex] = temp;
        }

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }
    }
}
