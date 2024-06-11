import {apiCall} from "./ApiService";

export const getAllAccountsFromCustomer = (id) => {
    return apiCall("http://localhost:8080/accounts/customer/" + id, "GET");
};