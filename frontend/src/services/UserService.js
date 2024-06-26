import {apiCall} from "./ApiService";

export const login = (email, password) => {
    return apiCall("/login", "POST", {email, password});
};

export const register = (email, password, firstName, lastName, bsnNumber, phoneNumber) => {
    return apiCall("/register", "POST", {
        email,
        password,
        firstName,
        lastName,
        bsnNumber,
        phoneNumber
    })
}