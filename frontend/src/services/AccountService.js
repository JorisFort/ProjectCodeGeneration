import {apiCall} from "./ApiService";

export const getAllAccountsFromCustomer = (id) => {
    return apiCall("/accounts/customer/" + id, "GET");
};

export const getAccountById = (id) => {
    return apiCall("/accounts/" + id, "GET");
}