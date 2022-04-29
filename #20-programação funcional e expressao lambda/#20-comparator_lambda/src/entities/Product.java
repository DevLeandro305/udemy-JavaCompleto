package entities;

public class Product {
	
	private String name;
	private Double price;
	
	public Product() {
		super();
	}

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	/*Com o uso da express�o lambda passado diretamento como sintaxe do m�todo .sort, esse m�todo n�o � mais necess�rio e nem a implementa��o da interface compareTo
	@Override
	public int compareTo(Product p) {
		return name.toUpperCase().compareTo(p.getName().toUpperCase());
	}
	*/

}
