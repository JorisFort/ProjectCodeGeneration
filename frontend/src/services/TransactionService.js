import { apiCall } from "@/services/ApiService.js";

export const getAllTransactions = () => {
    return apiCall("http://localhost:8080/getAllTransactions", "GET")
}

export const transfer = ( newTransfer ) => {
    return apiCall("http://localhost:8080/transfer", "POST", { newTransfer })
}