import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {AuthService} from './auth.service';
import {map} from 'rxjs/operators';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const CHAT_URL = 'ws://localhost:8080/AT-Chat-war/ws/';
const ONLINE_USERS_URL = 'ws://localhost:8080/AT-Chat-war/users/';


export interface Message {
  receiver: string;
  sender: string;
  dateTime: string;
  subject: string;
}

export interface UserEvent {
  akcija: string;
  user: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  public messages: Subject<Message>;
  public onlineUsers: Subject<UserEvent>;

  constructor(private service: AuthService, private http: HttpClient) {
  }



}
