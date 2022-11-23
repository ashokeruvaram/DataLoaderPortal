import { UserDetails } from "./user-details";

export class BaseResponse {
    statusCode: number;
    statusMessage: string;
    userDetils: UserDetails[];
}
