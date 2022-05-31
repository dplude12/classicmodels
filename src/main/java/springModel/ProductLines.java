package springModel;

public class ProductLines {
	
	private int productLineId;
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	
	public ProductLines() {
	}
	
	public ProductLines(int productLineId, String productLine, String textDescription, String htmlDescription, byte[] image) {
		this.productLineId = productLineId;
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		
	}

	
	
	public int getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(int productLineId) {
		this.productLineId = productLineId;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	
}
