import { apiCall } from "./ApiService";

export const login = (email, password) => {
    return apiCall("http://localhost:8080/login", "POST", { email, password });
};

export const register = (email, password, firstName, lastName, bsnNumber, phoneNumber) => {
    return apiCall("http://localhost:8080/register", "POST", { email, password, firstName, lastName, bsnNumber, phoneNumber })
}