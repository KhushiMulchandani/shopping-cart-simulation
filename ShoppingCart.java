import java.util.*;
class Product{
	String product;
	double price;
	int quantity;
	
	Product[] newP1;
	 
	String[] electronics=new String[]{"Smartphone","Laptop","TV","Smartwatch","Headphone"};
	double[] electronics_Price=new double[]{20999,64999,39999,1999,4999};
	 
	String[] clothingApparel=new String[]{"Shirts","Pants","Skirts","Jeans","Shoes","Boots","Sandals","Jackets","Coats","Sweaters"};
	double[] clothingApparel_Price=new double[]{499,799,599,499,999,1999,1499,2599,1299,699};
	 
	String[] beautyAndPersonalCare=new String[]{"Perfumes","Deodorants","Toothpaste","Serum","Facewash","Moisturizer","Face Mask","Sunscreen","Hair Gel","Shampoo"};
	double[] beautyAndPersonalCare_Price=new double[]{2499,299,149,1499,299,499,349,599,249,399};
	 
	String[] books=new String[]{"Sapiens","The Psychology of Money","Atomic Habits","Secret","The Power Of Your Subconscious Mind"};
	double[] books_Price=new double[]{799,599,699,599,350};
	
	int qty;
	
	Scanner sc=new Scanner(System.in);
	
	void set(String s){
		int n;
		if(s.equals("electronics")){
			do{
				System.out.print("\nEnter the product(1-5): ");
				n=sc.nextInt();
				System.out.print("Enter Quantity (upto 2): ");
				qty=sc.nextInt();
				if((n<1 || n>5) || (qty<1 || qty>2)){
					System.out.println("invalid product no. or quantity");
				}
			}while((n<1 || n>5) || (qty<1 || qty>2));
			product=electronics[n-1];
			quantity=qty;
			price=electronics_Price[n-1];
			System.out.println("\nProduct added successfully!\n");
		}
		else if(s.equals("clothing")){
			do{
				System.out.print("Enter the product(1-10): ");
				n=sc.nextInt();
				System.out.print("Enter Quantity (upto 10): ");
				qty=sc.nextInt();
				if((n<1 || n>10) || (qty<1 || qty>10)){
					System.out.println("invalid product no. or quantity");
				}
			}while((n<1 || n>10) || (qty<1 || qty>10));
			product=clothingApparel[n-1];
			quantity=qty;
			price=clothingApparel_Price[n-1];
			System.out.println("\nProduct added successfully!\n");
		}
		else if(s.equals("beauty")){
			do{
				System.out.print("\nEnter the product(1-10): ");
				n=sc.nextInt();
				System.out.print("Enter Quantity (upto 10): ");
				qty=sc.nextInt();
				if((n<1 || n>10) || (qty<1 || qty>10)){
					System.out.println("invalid product no. or quantity");
				}
			}while((n<1 || n>10) || (qty<1 || qty>10));
			product=beautyAndPersonalCare[n-1];
			quantity=qty;
			price=beautyAndPersonalCare_Price[n-1];
			System.out.println("\nProduct added successfully!\n");
		}
		else if(s.equals("books")){
			do{
				System.out.print("\nEnter the product(1-5): ");
				n=sc.nextInt();
				System.out.print("Enter Quantity (upto 10): ");
				qty=sc.nextInt();
				if((n<1 || n>5) || (qty<1 || qty>10)){
					System.out.println("invalid product no. or quantity");
				}
			}while((n<1 || n>5) || (qty<1 || qty>10));
			product=books[n-1];
			quantity=qty;
			price=books_Price[n-1];
			System.out.println("\nProduct added successfully!\n");
		}
	}
	
	Product[] addProduct(Product[] cart,Product newProduct){
		int index=-1;
		for(int i=0;i<cart.length;i++){
			if(cart[i].product.equalsIgnoreCase(newProduct.product)){
				index=i;
				break;
			}
		}
		if(index==-1){
			newP1=new Product[cart.length+1];
			for(int i=0;i<cart.length;i++){
				newP1[i]=cart[i];
			}
			newP1[newP1.length-1]=newProduct;
			return newP1;
		}
		else{
			newP1[index].quantity+=newProduct.qty;
			return newP1;
		}
	}
	Product[] removeProduct(Product[] cart,String productName){
		newP1=new Product[cart.length-1];
		int index=-1;
		for(int i=0;i<cart.length;i++){
			if(cart[i].product.equalsIgnoreCase(productName)){
				index=i;
				break;
			}
		}
		if(index==-1){
			System.out.println("\n---Product Not Found!---\n");
			return newP1;
		}
		else{
			for(int i=0;i<index;i++){
				newP1[i]=cart[i];
			}
			for(int i=index+1;i<cart.length;i++){
				newP1[i-1]=cart[i];
			}
			System.out.println("\nProduct removed from the cart successfully!\n");
			return newP1;
		}
	}
	
	void applyDiscount(Product newProduct){
		newProduct.price=newProduct.price;
	}
	
	boolean check() {
		sc.nextLine();
        boolean flag = true;
        while (flag) {
            
			System.out.print("Enter 16-digit Credit/Debit Card Number: ");
            boolean validCard = true;
            while (validCard) {
                String no = sc.nextLine();
                if (no.length() == 16){
					for (int i = 0;i<no.length();i++){
						if(no.charAt(i)>='0' && no.charAt(i)<='9'){
							validCard = false;
						}
						else{
							System.out.print("Invalid Card Number! Enter a 16-digit numeric value. : ");
							validCard = true;
							break;
						}
					}
                } 
				else {
                    System.out.print("Invalid Card Number! Enter a 16-digit numeric value. : ");
                }
            }
			
            System.out.print("Enter CVV: ");
			validCard = true;
			
			while (validCard) {
                String cvv = sc.nextLine();
                if (cvv.length()==3){
					for (int i = 0;i<cvv.length();i++){
						if(cvv.charAt(i)>='0' && cvv.charAt(i)<='9'){
							validCard = false;
							flag = false;
						}
						else{
							System.out.print("Invalid CVV Number! Enter a 3-digit numeric value. : ");
							validCard = true;
							break;
						}
					}
                } 
				else {
                    System.out.print("Invalid CVV Number! Enter a 3-digit numeric value. :");
                }
            }
        }
        return true;
    }
	
	void payment(double totalPrice){
		boolean flag = true;
		int choice =0;
		
		do{
			System.out.println("Payment option \n1. Cash \n2. Credit/Debit \n3. Upi");
			System.out.print("Enter Choice (1-3) : ");
			choice = sc.nextInt();
			if(choice>=1 && choice<=3){
				break;
			}
			else{
				System.out.print("Enter Valid Choice ");
			}
		}while(flag);
		
		while(flag){
			
			switch(choice){
			case 1 :
			System.out.println("Total Amount to be paid : "+(int)totalPrice);
			System.out.print("Enter Amount : ");
			double cashpay =  sc.nextDouble();
			if(cashpay == (int)totalPrice){
				System.out.print("Payment done Successfully ");
				flag = false;
			}
			else{
				System.out.println("Incorrect Amount! Please enter the exact amount.");
			}
			break;
			case 2 : 
			if(check()){
				System.out.println("Payment Done Successfully via Credit/Debit Card!");
				flag = false;
			}
			break;
			case 3 :
			    sc.nextLine();
			    while (flag) {
                    System.out.print("Enter UPI ID (example@bankupi): ");
                    String upiId = sc.nextLine();

                    if (upiId.endsWith("@bankupi")) {
                        System.out.println("Payment Done Successfully via UPI!");
                        flag = false;
                    } else {
                        System.out.println("Invalid UPI ID! Please enter a valid format (e.g., user@bankupi).");
                    }
                }
			break;
		}
		System.out.println();
		}
	}
	
}
class Electronics extends Product{
	Electronics(){
		int i=1;
		for(String x:electronics){
			System.out.println(i+". "+x+" (Rs."+electronics_Price[i-1]+"/-)");
			i++;
		}
	}
	void applyDiscount(Product newProduct){
		newProduct.price-=(0.10*newProduct.price);
	}
}
class Clothing extends Product{
	Clothing(){
		int i=1;
		for(String x:clothingApparel){
			System.out.println(i+". "+x+" (Rs."+clothingApparel_Price[i-1]+"/-)");
			i++;
		}
	}
	void applyDiscount(Product newProduct){
		newProduct.price-=(0.12*newProduct.price);
	}
}
class BeautyAndPersonalCare extends Product{
	BeautyAndPersonalCare(){
		int i=1;
		for(String x:beautyAndPersonalCare){
			System.out.println(i+". "+x+" (Rs."+beautyAndPersonalCare_Price[i-1]+"/-)");
			i++;
		}
	}
	void applyDiscount(Product newProduct){
		newProduct.price-=(0.05*newProduct.price);
	}
}
class Books extends Product{
	Books(){
		int i=1;
		for(String x:books){
			System.out.println(i+". "+x+"( Rs."+books_Price[i-1]+"/-)");
			i++;
		}
	}
	void applyDiscount(Product newProduct){
		newProduct.price-=(0.06*newProduct.price);
	}
	
}

class ShoppingCart{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("\n----WELCOME!----\n");
		boolean flag1;
		boolean flag2;
		int ch2;
		int ch1;
		Product p=new Product();
		Product[] cart=new Product[0];
		String name;
		String phno;
		String address;
		String shippingAddress;
		double totalPrice=0;
		do{
			flag1=false;
			System.out.println("1. ADD PRODUCT\n2. REMOVE PRODUCT\n3. VIEW PRODUCTS IN CART\n4. CHECKOUT\n5. EXIT");
			System.out.println();
			System.out.print("Enter your choice(1-5): ");
			ch1=sc.nextInt();
			switch(ch1){
				case 1:{
					do{
						flag2=false;
						System.out.println("\n---AVAILABLE CATEGORIES---\n");
						System.out.println("1. Electronics\n2. Clothing & Apparel\n3. Beauty & Personal Care\n4. Books");
						System.out.println();
						System.out.print("Enter the category (1-4): ");
						ch2=sc.nextInt();
						System.out.println();
						int i=1;
						switch(ch2){
							case 1:{
								Electronics newProduct = new Electronics();
								newProduct.set("electronics");
								cart=p.addProduct(cart,newProduct);
								newProduct.applyDiscount(newProduct);
								break;
							}
							case 2:{
								Clothing newProduct = new Clothing();
								newProduct.set("clothing");
								cart=p.addProduct(cart,newProduct);
								newProduct.applyDiscount(newProduct);
								break;
							}
							case 3:{
								BeautyAndPersonalCare newProduct = new BeautyAndPersonalCare();
								newProduct.set("beauty");
								cart=p.addProduct(cart,newProduct);
								newProduct.applyDiscount(newProduct);
								break;
							}
							case 4:{
								Books newProduct = new Books();
								newProduct.set("books");
								cart=p.addProduct(cart,newProduct);
								newProduct.applyDiscount(newProduct);
								break;
							}
							default:{
								flag2=true;
								System.out.println();
								System.out.println("---Invalid input---\n   Try Again! :(");
								System.out.println();
							}
						}
					}while(flag2);
					flag1=false;
					break;
				}
				case 2:{
					if(cart.length==0){
						System.out.println("\n---There are no products in cart---\n");
					}
					else{
						System.out.println();
						System.out.println("-----------------------------------------");
						System.out.println("\n<<<YOUR CART>>>\n");
						for(int i=1;i<=cart.length;i++){
							System.out.println(i+". "+cart[i-1].product+" (Qty="+cart[i-1].quantity+") Rs. "+cart[i-1].price+"/- each");
						}
						System.out.println("\n-----------------------------------------\n");
						int productNo;
						do{
							System.out.print("Enter the product no. : ");
							productNo=sc.nextInt();
							if(productNo<1 || productNo>cart.length){
								System.out.println("---Invalid---");
							}
						}while(productNo<1 || productNo>cart.length);
						cart=p.removeProduct(cart,cart[productNo-1].product);
					}
					break;
				}
				case 3:{
					if(cart.length==0){
						System.out.println("\n---There are no products in cart---\n");
					}
					else{
						System.out.println();
						System.out.println("-----------------------------------------");
						System.out.println("\n<<<YOUR CART>>>\n");
						for(int i=1;i<=cart.length;i++){
							System.out.println(i+". "+cart[i-1].product+" (Qty="+cart[i-1].quantity+") Rs. "+cart[i-1].price+"/- each");
						}
						System.out.println("\n-----------------------------------------\n");
					}
					flag1=false;
					break;
				}
				case 4:{
					if(cart.length==0){
							System.out.println("\n---There are no products in cart---\n");
					}
					else{
						System.out.print("Enter name: ");
						sc.nextLine();
						name=sc.nextLine();
						do{
							System.out.print("Enter 10-digit mobile no.");
							phno=sc.nextLine();
							if(phno.length()!=10){
								System.out.println("---Invalid---");
							}
						}while(phno.length()!=10);
						System.out.print("Enter address: ");
						address=sc.nextLine();
						System.out.println("Is the shipping address same as your address?(y/n): ");
						String chk=sc.nextLine();
						if(chk.equalsIgnoreCase("y")){
							shippingAddress=address;
						}
						else{
							System.out.print("Enter shipping address: ");
							shippingAddress=sc.nextLine();
						}
						System.out.println("Name : "+name);
						System.out.println("Mobile no. : "+phno);
						System.out.println("Address : "+address);
						System.out.println("Shipping Address : "+shippingAddress);
						System.out.println();
						for(int i=0;i<cart.length;i++){
							System.out.println(cart[i].product+" (Qty="+cart[i].quantity+") "+cart[i].price+"*"+cart[i].quantity+"=Rs."+(cart[i].price*cart[i].quantity+"/- (After discount)"));
						}
						for(int i=0;i<cart.length;i++){
							totalPrice+=cart[i].price*cart[i].quantity;
						}
						totalPrice+=0.12*totalPrice;
						System.out.println("Total Amount-------------------->Rs."+totalPrice+"/- (GST inclusive)\n");
						p.payment(totalPrice);
					}
					flag1=false;
				}
				case 5:{
					flag1=true;
					break;
				}
				default:{
					flag1=false;
					System.out.println();
					System.out.println("---Invalid input---\n   Try Again! :(");
					System.out.println();
				}
			}
		}while(!flag1);
	}
}