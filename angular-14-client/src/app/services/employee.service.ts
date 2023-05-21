import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee.model';

const baseUrl = 'http://localhost:8080/api/employees';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(baseUrl);
  }

  get(id: any): Observable<Employee> {
    return this.http.get<Employee>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }


  updateWorkDays(id: any, workDays: number | undefined, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}/workdays/${workDays}`, data);
  }

  updateVacationDays(id: any, vacationDays: number | undefined, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}/vacationdays/${vacationDays}`, data);
  }



}
