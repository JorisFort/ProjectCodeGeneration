import {apiCall} from "./ApiService";

export const getAllTransactionByUser = (id) => {
    return apiCall("http://localhost:8080/transactions/user/" + id, "GET");
};

export const getAllTransactionsByAccount = (id) => {
    return apiCall("http://localhost:8080/transactions/account/" + id, "GET");
}