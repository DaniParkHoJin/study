package com.market.cart;

import com.market.bookitem.Book;

public class Cart implements CartInterface {

	static final int NUM_BOOK = 3;
	public CartItem[] cartItem = new CartItem[NUM_BOOK];
	public static int cartCount = 0;

	public Cart() {
		super();
	}

	@Override
	public void printBookList(Book[] booklist) {
		for (int i = 0; i < booklist.length; i++) {
			System.out.print(booklist[i].getBookId() + " | ");
			System.out.print(booklist[i].getIsbn() + " | ");
			System.out.print(booklist[i].getName() + " | ");
			System.out.print(booklist[i].getUnitPrice() + " | ");
			System.out.print(booklist[i].getAuthor() + " | ");
			System.out.print(booklist[i].getDescription() + " | ");
			System.out.print(booklist[i].getCategory() + " | ");
			System.out.print(booklist[i].getReleaseDate());
			System.out.println("");
		}

	}

	@Override
	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		for (int i = 0; i < cartCount; i++) {
			if (bookId == cartItem[i].getBookID()) {
				cartItem[i].setQuantity(cartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;

	}

	@Override
	public void insertBook(Book book) {
		cartItem[cartCount++] = new CartItem(book);

	}

	@Override
	public void removeCart(int numId) {
		CartItem[] cart_item = new CartItem[NUM_BOOK];
		int num = 0;
		for (int i = 0; i < cartCount; i++) {
			if (numId != i) {
				cart_item[num++] = cartItem[i];
			}
		}
		cartCount = num;
		cartItem = cart_item;
	}

	@Override
	public void deleteBook() {
		cartItem = new CartItem[NUM_BOOK];
		cartCount = 0;

	}

	public void printCart() {
		System.out.println("장바구니 상품 목록 :");
		System.out.println("---------------------------------------------");
		System.out.println(" 도서ID \t| 수량 \t| 합계");
		for (int i = 0; i < cartCount; i++) {
			System.out.print(" " + cartItem[i].getBookID() + " \t| ");
			System.out.print(" " + cartItem[i].getQuantity() + " \t| ");
			System.out.print(" " + cartItem[i].getTotalPrice());
			System.out.println(" ");
		}
		System.out.println("---------------------------------------------");
	}

}
