import { apiCall } from "./ApiService";

export const login = (email, password) => {
    return apiCall("http://localhost:8080/login", "POST", { email, password });
};