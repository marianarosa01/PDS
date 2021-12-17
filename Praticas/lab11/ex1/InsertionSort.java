public class InsertionSort implements Strategy {
	
	public static void insertionSort(int[] vetor) {

	}

	@Override
	public void sort(Phone[] phones) {
	    int j;
	    Phone key;
	    int i;
	    
	    for (j = 1; j < phones.length; j++)
	    {
	      key = phones[j];
	      for (i = j - 1; (i >= 0) && (phones[i].getPrice() > key.getPrice()); i--)
	      {
	         phones[i + 1] = phones[i];
	       }
	        phones[i + 1] = key;
	    }
	}

}