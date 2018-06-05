import { Component, OnInit } from '@angular/core';
import {Product} from "../../domain/Product";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [new Product(1, "some Description", 100, true),
    new Product(2, "some Description", 100, true),
    new Product(3, "some Description", 100, true),
    new Product(4, "some Description", 100, true)];
  selectedProduct: Product = this.products[1];

  constructor() { }

  ngOnInit() {
  }

  onSelect(product: Product): void {
    this.selectedProduct = product;
  }
}
