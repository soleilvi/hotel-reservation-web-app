import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  constructor(private http: HttpClient) { }

  getWelcomeMessages() {
    return this.http.get("http://localhost:8080/welcome");
  }
}
