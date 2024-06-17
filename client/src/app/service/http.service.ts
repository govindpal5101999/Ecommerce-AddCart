import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
  
@Injectable({
  providedIn: 'root'
})
export class PostService {

  public _url = 'http://localhost:8008/api/cartList'
   
  constructor(private httpClient: HttpClient) { }

  getData(){
    return this.httpClient.get(this._url);
  }

  postImg(img){
    return this.httpClient.post(this._url, img)
  }
  
}