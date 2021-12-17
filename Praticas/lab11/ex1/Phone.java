public class Phone {
    private double price;
    private int memory;
    private String brand;
    private int camera;

    public Phone(double price, int mem, String brand, int camera) {
        this.price = price;
        this.memory = mem;
        this.brand = brand;
        this.camera = camera;
    }

    @Override
	public String toString() {
		return "Phone [price=" + price + ", memory=" + memory + ", brand=" + brand + ", camera=" + camera + "]";
	}

	public double getPrice() {
        return this.price;
    }


}
