import { BaseResponse } from "../entitys/base-response.model"
import { HttpClient, HttpHeaders } from '@angular/common/http';
export class HeadersForMethods {
    cookies: BaseResponse = new BaseResponse;

    public getHeaders() {
        this.cookies = JSON.parse(localStorage.getItem("details"))
        return {
            headers: new HttpHeaders({
                'Authorization': "Bearer " + this.cookies.authorDetails.jwtToken,
                'Content-Type': 'application/json',
            })
        }
    }
}