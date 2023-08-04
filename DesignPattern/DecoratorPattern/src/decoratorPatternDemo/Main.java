package decoratorPatternDemo;

public class Main {

	public static void main(String[] args) {
		// Tạo một hình chữ nhật
        Shape rectangle = new Rectangle();
        System.out.println(rectangle.draw()); 
        // Output: "Vẽ hình chữ nhật"

        // Tạo một hình chữ nhật và tô màu đỏ
        Shape redRectangle = new ColorDecorator(rectangle, "đỏ");
        System.out.println(redRectangle.draw()); 
        // Output: "Vẽ hình chữ nhật và tô màu đỏ"

        // Tạo một hình tròn và tô màu xanh
        Shape circle = new Circle();
        Shape greenCircle = new ColorDecorator(circle, "xanh");
        System.out.println(greenCircle.draw()); 
        // Output: "Vẽ hình tròn và tô màu xanh"
    }

}
