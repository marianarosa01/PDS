public class SelectionSort implements Strategy {
	
	 public static void selectionSort(int[] array) {
		 
		}

	@Override
	public void sort(Phone[] phones) {
		 for (int fixo = 0; fixo < phones.length - 1; fixo++) {
			    int menor = fixo;
			   
			    for (int i = menor + 1; i < phones.length; i++) {
			       if (phones[i].getPrice() < phones[menor].getPrice()) {
			          menor = i;
			       }
			    }
			    if (menor != fixo) {
			      Phone t = phones[fixo];
			      phones[fixo] = phones[menor];
			      phones[menor] = t;
			    }
			  }
	}

}