import {apiCall} from "./ApiService";

export const getCustomer = (id) => {
    return apiCall("http://localhost:8080/customers/" + id, "GET");
};