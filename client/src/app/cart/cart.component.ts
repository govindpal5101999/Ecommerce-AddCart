import { Component, OnInit } from '@angular/core';
import { PostService } from '../service/http.service';

interface Products {
  id: number
  Title: string
  UnitPrice: number
  Quantity: number
  TotalAmount: number
  Image: string
  Description: string
}

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  public cart: any = []
  imageUrl = 'data:image/jpeg;base64,';

  constructor(private _postService: PostService) { }
  
  public Allproducts: any = [];

  ngOnInit(): void {
    this._postService.getData().subscribe({
      next: (data) => {

        this.Allproducts = data;
        Array.of(this.Allproducts);

      }
    }), (error) => {
      alert('not fetched data')
    };
  }

  addToCart(product: Products, unitPrice) {
    

    const existingItem = this.cart.find(i => i.id === product.id);
   
    if (existingItem) {
      existingItem.quantity++;
      existingItem.totalPrice = existingItem.quantity * existingItem.unitprice;
    } else {
      this.cart.push({ ...product, quantity: 1, totalPrice: unitPrice });
    }
  }


  removeCart(index: any) {
    this.cart.splice(index, 1);
  }

  getTotal(): number {
    return this.cart.reduce((acc, item) => acc + item.unitprice * item.quantity, 0);
  }

  increaseQuantity(index: number): void {
    this.cart[index].quantity++;

    this.cart[index].totalPrice = this.cart[index].quantity * this.cart[index].unitprice;
  }

  decreaseQuantity(index: number): void {
    if (this.cart[index].quantity > 1) {
      this.cart[index].quantity--;

      this.cart[index].totalPrice = this.cart[index].quantity * this.cart[index].unitprice;
    }
  }

}
