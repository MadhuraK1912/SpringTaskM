import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { error } from 'console';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  constructor(private http:HttpClient){

  }

  task ={
    "title":'',
    "status":0
  }

  Tasks:any = []

  ngOnInit(){
    this.http.get("http://localhost:8080/getall").subscribe(
      (data)=>{
        this.Tasks = data;
        console.log(data);
      }
      ,
      (error)=>{
        console.log(error)
      }
    )
  }
  insert(){
    this.http.post("http://localhost:8080/insert",this.task).subscribe(
      (data)=>{
        console.log("Inserted")
      },
      (error)=>{
        console.log(error)
      }
    )
    location.reload();
  }

  delete(id:any){
    this.http.delete(`http://localhost:8080/delete/${id}`).subscribe(
      (data)=>{
        console.log("Deleted")
      },
      (error)=>{
        console.log(error)
      }
    )

    location.reload()
  }
  updateStatus(task:any){
    task.status=1;
    this.http.put("http://localhost:8080/update",task).subscribe(
      (data)=>{
        console.log("Updated")
      },
      (error)=>{
        console.log(error)
      }
    )
    location.reload();
  }

  updateTitle(task:any){
    var title = prompt("Enter new Title",task.title)
    task.title=title
    this.http.put("http://localhost:8080/update",task).subscribe(
      (data)=>{
        console.log("Updated")
      },
      (error)=>{
        console.log(error)
      }
    )
    location.reload();
  }
}
