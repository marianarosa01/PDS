public class BubbleSort implements Strategy {
	@Override
	public void sort(Phone[] phones) {
		boolean swap = true;
        Phone aux;
        while (swap) {
            swap = false;
            for (int i = 0; i < phones.length - 1; i++) {
                if (phones[i].getPrice() > phones[i + 1].getPrice()) {
                    aux = phones[i];
                    phones[i] = phones[i + 1];
                    phones[i + 1] = aux;
                    swap = true;
                }
            }
        }
	}	
}
