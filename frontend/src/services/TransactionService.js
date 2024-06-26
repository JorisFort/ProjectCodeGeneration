import {apiCall} from "./ApiService";

export const getAllTransactionByUser = (id) => {
    return apiCall("/transactions/user/" + id, "GET");
};

export const getAllTransactionsByAccount = (id) => {
    return apiCall("/transactions/account/" + id, "GET");
}